package com.sudhakar.zapurl.model.ui;

import java.util.Date;

import com.sudhakar.zapurl.controller.ZapHomeController;


public class ZapUrlDto {


	private Long id;
	
	
	private String url;
	
	private String captcha;
	
	
	private String zappedUrl;
	

	private String validTill = ZapHomeController.sdf.format(new Date());
	
	private boolean secure;
	


	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getZappedUrl() {
		return zappedUrl;
	}

	public void setZappedUrl(String zappedUrl) {
		this.zappedUrl = zappedUrl;
	}

	public String getValidTill() {
		return validTill;
	}

	public void setValidTill(String validTill) {
		this.validTill = validTill;
	}

	public boolean isSecure() {
		return secure;
	}

	public void setSecure(boolean secure) {
		this.secure = secure;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ZapUrlDto [id=");
		builder.append(id);
		builder.append(", url=");
		builder.append(url);
		builder.append(", captcha=");
		builder.append(captcha);
		builder.append(", zappedUrl=");
		builder.append(zappedUrl);
		builder.append(", validTill=");
		builder.append(validTill);
		builder.append(", secure=");
		builder.append(secure);
		builder.append(", password=");
		builder.append(password);
		builder.append("]");
		return builder.toString();
	}


	
}
