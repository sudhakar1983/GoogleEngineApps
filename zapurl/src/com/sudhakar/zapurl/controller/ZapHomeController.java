package com.sudhakar.zapurl.controller;

import java.text.SimpleDateFormat;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;

import com.sudhakar.zapurl.model.ui.ZapUrlDto;
import com.sudhakar.zapurl.processor.ZapProcessor;

@Controller
public class ZapHomeController implements ServletContextAware {

	private static final Logger log = Logger.getLogger(ZapHomeController.class.getName());
	public static final SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

	@Autowired
	private ZapProcessor zapProcessor;

	@Autowired
	private ZapHomeValidator homeValidator;

	private ServletContext serContext;

	@ModelAttribute("zapurl")
	public ZapUrlDto getCommand() {
		return new ZapUrlDto();
	}

	@RequestMapping(value = "/zap", method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest request) {

		return "home";
	}

	@RequestMapping(value = "/zap", method = RequestMethod.POST)
	public String zapIt(Model model, @ModelAttribute("zapurl") ZapUrlDto zapurl, HttpServletRequest request, BindingResult result) throws Exception {
		log.info("Zapping the url...... " + zapurl);

		homeValidator.validate(zapurl, result);
		
		if (result.hasErrors()) {
			log.info("has errors ");
			model.addAttribute("result", result);
			model.addAttribute("zapurl", zapurl);
			return "home";
		}		

		String remoteAddr = request.getRemoteAddr();
        String challenge = request.getParameter("recaptcha_challenge_field");
        String uresponse = request.getParameter("recaptcha_response_field");		
        
        log.info("remoteAddr :" + remoteAddr);
        log.info("challenge :" + challenge);
        log.info("uresponse :" + uresponse);
        
		boolean isValid = zapProcessor.isCaptchaValid(remoteAddr, challenge, uresponse);
		
		if(!isValid){
			result.reject("captcha.invalid", "captcha");
		}		

		if (result.hasErrors()) {
			log.info("has errors ");
			model.addAttribute("result", result);
			model.addAttribute("zapurl", zapurl);
			return "home";
		}
		
		
		

		String zappedUrl = zapProcessor.generateUniqueZapUrl();
		zapurl.setZappedUrl(zappedUrl);

		zapProcessor.save(zapurl);
		String appUrl = serContext.getInitParameter("APP_URL");
		
		model.addAttribute("result", result);
		model.addAttribute("success", true);
		model.addAttribute("APP_URL", appUrl);
		model.addAttribute("zapurl", zapurl);

		return "home";
	}

	@RequestMapping(value = "/zap/{zapValue}", method = RequestMethod.GET)
	public String forward(HttpServletRequest request,HttpServletResponse res, Model model, @PathVariable("zapValue") String zapValue,
			@RequestParam(value = "p", required = false) String password)
			throws Exception {
		String view = "home";
		ZapError errors = new ZapError();

		log.info("zapValue :" + zapValue);

		ZapUrlDto zap = zapProcessor.getZapUrl(zapValue);
		log.info("zap :" + zap	);		
		homeValidator.validateZapUrlAccess(zap, errors, password);

		
		//redirect to unauthorized page 
		if(null != zap && zap.isSecure()){
			if(!zap.getPassword().equals(password)){
				return "redirect:../authorize/"+zapValue;
			}
		}

		if (!errors.hasErrors()) {
			String urlToForward = zap.getUrl();
			view = "redirect:http://" + urlToForward;			

		} else {
			
			model.addAttribute("errors", errors.getErrors());			
			view = "error";
		}
		

		return view;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.context.ServletContextAware#setServletContext
	 * (javax.servlet.ServletContext)
	 */
	@Override
	public void setServletContext(ServletContext ctx) {
		serContext = ctx;
	}
}
