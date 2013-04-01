package com.sudhakar.zapurl.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sudhakar.zapurl.model.ui.AuthorizeMe;
import com.sudhakar.zapurl.model.ui.ZapUrlDto;
import com.sudhakar.zapurl.processor.ZapProcessor;

@Controller
public class AuthorizemeController {

	@Autowired
	private AuthorizemeValidator authorizemeValidator;
	
	@Autowired
	private ZapProcessor zapProcessor;
	
	@ModelAttribute("auth")
	public AuthorizeMe getCommand() {
		return new AuthorizeMe();
	}
	
	@RequestMapping(value="authorize/{zappedUrl}", method=RequestMethod.GET)
	public String authorize(Model model , @ModelAttribute AuthorizeMe auth, BindingResult errors){
		String view="unauthorized";		
		return view;
	}	

	
	@RequestMapping(value="authorize/{zapValue}", method=RequestMethod.POST)
	public String authorizeme(Model model , @ModelAttribute AuthorizeMe auth, BindingResult errors ,@PathVariable String zapValue,HttpServletResponse response) throws Exception{
		String view="unauthorized";
		
		
		authorizemeValidator.validate(auth, errors);
		ZapUrlDto zap = zapProcessor.getZapUrl(zapValue);
		
		if(null == zap){
			errors.reject("zap.invalid.link", "password");
		}
		
		if(errors.hasErrors()){
			return view;
		}
		
		if(zap.getPassword().equals(auth.getPassword())){
			response.sendRedirect("http://"+zap.getUrl());
		}
		
		
		
		System.out.println("AuthorizeMe :"+ auth);
		return view;
	}
	
	
	
}
