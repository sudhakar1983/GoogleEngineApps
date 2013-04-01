/**
 * 
 */
package com.sudhakar.zapurl.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

	private static final SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	{
		sdf.setLenient(false);
	}
	
	public static void main(String[] args) throws ParseException {
		sdf.setLenient(false);
		String d = "59/01/1983";
		Date dd = sdf.parse(d);
		
		System.out.println(dd);
		
	}


	
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
		ValidationUtils.rejectIfEmpty(errors, "captcha", "captcha.invalid");
		
	
		
		if(null != zap.getValidTill() && !"".equals(zap.getValidTill())){
			System.out.println("validating date");
			try {
				System.out.println("date passed :" +zap.getValidTill());
				sdf.parse(zap.getValidTill());
				System.out.println("After parsing");
			} catch (Exception e) {
				System.out.println("date is invalid");
				errors.rejectValue("validTill", "invalid.date");
			}			
		}

		
		if (zap.isSecure()) {
			ValidationUtils.rejectIfEmpty(errors, "password","password.invalid.length");			
			if(null != zap.getPassword() && !"".equals(zap.getPassword())){
				if(zap.getPassword().length() <4) {
					errors.rejectValue("password", "invalid.date");
				}
				
			}
		}
	}
	
	
	public void validateZapUrlAccess(Object obj, ZapError error ,String password) {
		ZapUrlDto zap = (ZapUrlDto) obj;
		
		if(null == zap ) {
			error.reject("zap.invalid.link");			
					
		}else {
			
			if(zap.isSecure()){
				
				if(!zap.getPassword().equals(password)){
					error.reject("zap.link.unauthorized");
				}
				
			}
		}
		
	}

}
