package com.sudhakar.zapurl.controller;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sudhakar.zapurl.controller.error.ZapError;
import com.sudhakar.zapurl.model.db.ZapUrl;
import com.sudhakar.zapurl.model.ui.AuthorizeMe;

@Component
public class AuthorizemeValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		return (AuthorizeMe.class.isInstance(arg0));
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		 
		AuthorizeMe auth = (AuthorizeMe) arg0;
		
		if(null != auth){
			
			if(null != auth && "".equals(auth.getPassword().trim())){
				errors.rejectValue("password", "password.invalid");
			}

			if(null != auth && "".equals(auth.getRecaptcha_response_field().trim())){
				errors.rejectValue("captcha", "captcha.invalid");
			}
			
			
		}
		
	}
	
	
	
	public void validateZapUrlAccess(Object obj, ZapError error) {
		ZapUrl zap = (ZapUrl) obj;		
		
		Date today = new Date(); 
		Calendar todayCal = Calendar.getInstance();
		todayCal.setTime(today);
		
		Calendar urlCal = Calendar.getInstance();
		urlCal.setTime(zap.getValidTill());
		
		
		if(urlCal.before(today) ){
			error.reject("zap.link.expired");
		}else if(zap.isSecure()){
			error.reject("zap.link.unauthorized");
		}
	}

}
