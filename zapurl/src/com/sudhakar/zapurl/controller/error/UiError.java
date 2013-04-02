package com.sudhakar.zapurl.controller.error;

import com.sudhakar.zapurl.RandomStringUtils;
import com.sudhakar.zapurl.RandomStringUtils.URL_LENGTH;

public class UiError {

	private final String code;
	private final String value;
	
	public UiError(String code,String value){
		if(null == code) code = RandomStringUtils.randomString(URL_LENGTH.FIVE);
		this.code = code;
		this.value = value;
	}

	public String getCode() {
		return code;
	}

	public String getValue() {
		return value;
	}

	@Override
	public boolean equals(Object obj) {
		if(!UiError.class.isInstance(obj)){
			return false;
		}
		UiError temp = (UiError) obj;
		if(null != temp && this.getCode().equals(temp.getCode())){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UiError [code=");
		builder.append(code);
		builder.append(", value=");
		builder.append(value);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
