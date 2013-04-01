/**
 * 
 */
package com.sudhakar.zapurl.controller;

import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sudhakar.zapurl.model.ui.ZapUrlDto;



/**
 * @author Sudhakar Duraiswamy
 *
 */
@Component
public class ZapHomeValidator implements Validator{

	private static final SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy");
	
	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(Class<?> arg0) {		
		return ZapUrlDto.class.isInstance(arg0);
	}

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
	 */
	@Override
	public void validate(Object obj, Errors errors) {
		
		ZapUrlDto zap = (ZapUrlDto) obj;
		
		ValidationUtils.rejectIfEmpty(errors, "url", "url.empty");
		ValidationUtils.rejectIfEmpty(errors, "validTill", "invalid.date");
		
		
		if(null != zap.getValidTill() && !"".equals(zap.getValidTill()))
		try {
			sdf.parse(zap.getValidTill());
		} catch (Exception e) {
			errors.rejectValue("validTill", "invalid.date");
		}
		
		if (zap.isSecure()) {
			ValidationUtils.rejectIfEmpty(errors, "password","password.invalid");
			if ( null != zap.getPassword()
					&& "".equals(zap.getPassword().trim())) {

				errors.rejectValue("password", "password.invalid");
			}
		}
	}
	
	
	public void validateZapUrlAccess(Object obj, Errors errors,String password) {
		ZapUrlDto zap = (ZapUrlDto) obj;
		
		if(null == zap ) {
			errors.reject("zap.invalid.link", "zap.error");			
					
		}else {
			if(zap.isSecure()){
				
				if(!zap.getPassword().equals(password)){
					errors.reject("zap.link.unauthorized", "zap.error");
				}
				
			}
		}
		
	}

}
