package com.sudhakar.zapurl.model.ui;


public class AuthorizeMe {
	
	private String password;
	
	private String recaptcha_response_field;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRecaptcha_response_field() {
		return recaptcha_response_field;
	}

	public void setRecaptcha_response_field(String recaptcha_response_field) {
		this.recaptcha_response_field = recaptcha_response_field;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AuthorizeMe [password=");
		builder.append(password);
		builder.append(", recaptcha_response_field=");
		builder.append(recaptcha_response_field);
		builder.append("]");
		return builder.toString();
	}

	
	
	
}
