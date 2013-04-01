package com.sudhakar.zapurl.controller;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sudhakar.zapurl.model.ui.AuthorizeMe;

@Component
public class AuthorizemeValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return (AuthorizeMe.class.isInstance(arg0));
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		 
		AuthorizeMe auth = (AuthorizeMe) arg0;
		
		if(null != auth){
			
			if(null != auth && "".equals(auth.getPassword().trim())){
				//errors.reject("password.invalid", "password");
				errors.rejectValue("password", "password.invalid");
			}

			if(null != auth && "".equals(auth.getRecaptcha_response_field().trim())){
				errors.rejectValue("recaptcha_response_field", "captcha.invalid");
			}
			
			
		}
		
	}

}
