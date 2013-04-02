package com.sudhakar.zapurl.controller.error;

import java.util.ArrayList;
import java.util.List;

import com.sudhakar.zapurl.processor.PropertyLoader;


// TODO: Auto-generated Javadoc
/**
 * The Class ZapError.
 */
public class ZapError {
	
	/** The errors. */
	private List<UiError> errors = new ArrayList<UiError>();
	
	/**
	 * Adds the error.
	 *
	 * @param error the error
	 */
	public void addError(String error){
		if(null != error & !"".equals(error)) errors.add(new UiError(null,error));
	}

	/**
	 * Gets the errors.
	 *
	 * @return the errors
	 */
	public List<UiError> getErrors() {
		return errors;
	}

	/**
	 * Sets the errors.
	 *
	 * @param errors the new errors
	 */
	public void setErrors(List<String> errors) {
		for(String value: errors){
			this.errors.add(new UiError(null,value));
		}
		

	}

	/**
	 * Checks for error.
	 *
	 * @return true, if successful
	 */
	public boolean hasErrors(){
		return (errors.isEmpty())? false : true;
	}
	
	/**
	 * Reject.
	 *
	 * @param code the code
	 * @throws RuntimeException - when code not found 
	 */
	public void reject(String code) {
		String errorValue = PropertyLoader.getProperty(code);		
		System.out.println(code+":"+errorValue);
		if(null != errorValue ){
			this.errors.add(new UiError(code,errorValue));
		}
		else throw new RuntimeException("Error code not found");
	}
	
	/**
	 * Reject.
	 *
	 * @param code the code
	 * @param defaultMessage the default message
	 */
	public void reject(String code,String defaultMessage){
		String errorValue = PropertyLoader.getProperty(code);
		if(null != errorValue ){
			this.errors.add(new UiError(code,errorValue));
		}else{
			this.errors.add(new UiError(code,defaultMessage));
		}
	}	
	
}
