/**
 * 
 */
package com.sudhakar.zapurl.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sudhakar.zapurl.controller.error.ZapError;
import com.sudhakar.zapurl.model.db.ZapUrl;
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
			try {				
				sdf.parse(zap.getValidTill());				
			} catch (Exception e) {				
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
		
		ZapUrl zap = (ZapUrl) obj;		
		if(null == zap ) {
			error.reject("zap.invalid.link");		
					
		}

		if(null != zap ) {
			Date today = new Date(); 
			Calendar todayCal = Calendar.getInstance();
			todayCal.setTime(today);
			
			Calendar urlCal = Calendar.getInstance();
			urlCal.setTime(zap.getValidTill());			
			
			if( !(
					todayCal.get(Calendar.ERA) == urlCal.get(Calendar.ERA)
		            && todayCal.get(Calendar.YEAR) == urlCal.get(Calendar.YEAR) 
		            && todayCal.get(Calendar.DAY_OF_YEAR) == urlCal.get(Calendar.DAY_OF_YEAR)
			) && !todayCal.before(urlCal)	){
				error.reject("zap.link.expired");
			}
		}
		
	}
	
	
}
