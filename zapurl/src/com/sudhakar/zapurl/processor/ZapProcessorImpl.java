/**
 * 
 */
package com.sudhakar.zapurl.processor;

import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sudhakar.zapurl.RandomStringUtils;
import com.sudhakar.zapurl.RandomStringUtils.URL_LENGTH;
import com.sudhakar.zapurl.controller.ZapHomeController;
import com.sudhakar.zapurl.dao.ZapUrlDao;
import com.sudhakar.zapurl.model.db.ZapUrl;
import com.sudhakar.zapurl.model.ui.ZapUrlDto;

/**
 * @author Sudhakar Duraiswamy
 *
 */
@Component
public class ZapProcessorImpl implements ZapProcessor{

	
	@Autowired
	private ZapUrlDao zapUrlDao;
	/* (non-Javadoc)
	 * @see com.sudhakar.zapurl.processor.ZapProcessor#save(com.sudhakar.zapurl.model.ui.ZapUrl)
	 */
	@Override
	public void save(ZapUrlDto zapurl) throws Exception {
		
		com.sudhakar.zapurl.model.db.ZapUrl zapDb = new  com.sudhakar.zapurl.model.db.ZapUrl();
		zapDb.setUrl(zapurl.getUrl());
		zapDb.setValidTill(ZapHomeController.sdf.parse(zapurl.getValidTill() ));
		zapDb.setZappedUrl(zapurl.getZappedUrl());
		zapDb.setSecure(zapurl.isSecure());
		zapDb.setPassword(zapurl.getPassword());		
		zapUrlDao.save(zapDb);
		
	}

	
	/* (non-Javadoc)
	 * @see com.sudhakar.zapurl.processor.ZapProcessor#generateUniqueZapUrl()
	 */
	@Override
	public String generateUniqueZapUrl() throws Exception {
		
		String randomValue = RandomStringUtils.randomString(URL_LENGTH.FIVE);
		com.sudhakar.zapurl.model.db.ZapUrl zapDb = zapUrlDao.getLink(randomValue);
		
		System.out.println("Zap fetched from DB "+ zapDb);
		
		while(null != zapDb){
			System.out.println("Retrying random string generation");
			randomValue = RandomStringUtils.randomString(URL_LENGTH.FIVE);
			zapDb = zapUrlDao.getLink(randomValue);
		}
		
		return randomValue;
	}
	/* (non-Javadoc)
	 * @see com.sudhakar.zapurl.processor.ZapProcessor#getZapUrl(java.lang.String)
	 */
	@Override
	public ZapUrlDto getZapUrl(String zapValue) throws Exception {
		ZapUrlDto zapUrl = null;
		
		com.sudhakar.zapurl.model.db.ZapUrl zapDb = zapUrlDao.getLink(zapValue);
		
		if(null != zapDb ){
			zapUrl = new ZapUrlDto();
			zapUrl.setUrl(zapDb.getUrl());
			zapUrl.setValidTill(ZapHomeController.sdf.format(zapDb.getValidTill() ));
			zapUrl.setZappedUrl(zapDb.getZappedUrl());
			zapUrl.setSecure(zapDb.isSecure());
			zapUrl.setPassword(zapDb.getPassword());
		}
		return zapUrl;
	}
	
	
	@Override
	public ZapUrl getZap(String zapValue) throws Exception {
		com.sudhakar.zapurl.model.db.ZapUrl zapDb = zapUrlDao.getLink(zapValue);
		return zapDb;
	}	
	
	
	@Override
	public boolean isCaptchaValid(String remoteAddr, String challenge,
			String uresponse) throws Exception {
			boolean isValid = false;
			
		   ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
		   reCaptcha.setPrivateKey("6LdnC98SAAAAAJ3q4yEdt3lPcM9yigZtf5B80HzQ");
	       ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(remoteAddr, challenge, uresponse);
	       isValid = reCaptchaResponse.isValid();
	       return isValid;
	}

	
}
