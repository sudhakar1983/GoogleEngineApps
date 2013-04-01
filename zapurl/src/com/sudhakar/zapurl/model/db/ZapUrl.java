package com.sudhakar.zapurl.model.db;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ZapUrl {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false, length=1000)
	private String url;
	
	@Column(nullable=false, length=50)
	private String zappedUrl;
	
	@Column(nullable=false)
	private Date validTill;
	
	@Column
	private boolean secure;
	
	@Column
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

	public void setUrl(String url) {
		this.url = url;
	}

	public String getZappedUrl() {
		return zappedUrl;
	}

	public void setZappedUrl(String zappedUrl) {
		this.zappedUrl = zappedUrl;
	}

	public Date getValidTill() {
		return validTill;
	}

	public void setValidTill(Date validTill) {
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
		return "ZapUrl [id=" + id + ", url=" + url + ", zappedUrl=" + zappedUrl
				+ ", validTill=" + validTill + ", secure=" + secure
				+ ", password=" + password + "]";
	}
	
	
	
}
