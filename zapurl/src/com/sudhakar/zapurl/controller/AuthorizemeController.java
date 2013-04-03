package com.sudhakar.zapurl.controller;

import java.util.logging.Logger;

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

import com.sudhakar.zapurl.controller.error.UiError;
import com.sudhakar.zapurl.controller.error.ZapError;
import com.sudhakar.zapurl.model.db.ZapUrl;
import com.sudhakar.zapurl.model.ui.AuthorizeMe;
import com.sudhakar.zapurl.model.ui.ZapUrlDto;
import com.sudhakar.zapurl.processor.ZapProcessor;

@Controller
public class AuthorizemeController {
	private static final Logger log = Logger.getLogger(AuthorizemeController.class.getName());
	@Autowired
	private AuthorizemeValidator authorizemeValidator;

	
	
	@Autowired
	private ZapProcessor zapProcessor;
	
	@ModelAttribute("auth")
	public AuthorizeMe getCommand() {
		return new AuthorizeMe();
	}
	
	@RequestMapping(value="authorize/{zapValue}", method=RequestMethod.GET)
	public String authorize(Model model , @ModelAttribute AuthorizeMe auth, BindingResult errors, @PathVariable("zapValue") String zapValue) throws Exception{
		String view="unauthorized";	
		ZapUrl zap = zapProcessor.getZap(zapValue);		
		ZapError zapError = new ZapError();
		
		authorizemeValidator.validateZapUrlAccess(zap, zapError);
		
		for(UiError err :zapError.getErrors()){
			log.info(err.getValue());
		}
		
		
		model.addAttribute("zaperror", zapError);
		return view;
	}	

	
	@RequestMapping(value="authorize/{zapValue}", method=RequestMethod.POST)
	public String authorizeme(Model model , @ModelAttribute("auth") AuthorizeMe auth, BindingResult errors ,@PathVariable String zapValue,HttpServletRequest request, HttpServletResponse response) throws Exception{
		String view="unauthorized";
		
		//Validation
		authorizemeValidator.validate(auth, errors);
		ZapUrlDto zap = zapProcessor.getZapUrl(zapValue);
		
		if(errors.hasErrors()){
			return view;
		}
		
		String remoteAddr = request.getRemoteAddr();
        String challenge = request.getParameter("recaptcha_challenge_field");
        String uresponse = request.getParameter("recaptcha_response_field");		
                
        boolean isValid = true; 
        if(ZapHomeController.enableCaptcha)isValid= zapProcessor.isCaptchaValid(remoteAddr, challenge, uresponse);
        
		if(!isValid){
			errors.rejectValue("captcha", "captcha.invalid");
		}	
		
		if(null == zap){
			errors.reject("zap.invalid.link", "password");
		}
		
		if(errors.hasErrors()){
			return view;
		}
		
		if(zap.getPassword().equals(auth.getPassword())){			
			return "redirect:http://"+zap.getUrl();
		}

		return view;
	}
	
	
	
}
