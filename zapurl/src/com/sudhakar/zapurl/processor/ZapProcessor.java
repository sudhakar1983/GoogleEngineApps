/**
 * 
 */
package com.sudhakar.zapurl.processor;

import com.sudhakar.zapurl.model.ui.ZapUrlDto;

/**
 * @author Sudhakar Duraiswamy
 *
 */
public interface ZapProcessor {

	public void save(ZapUrlDto zapurl) throws Exception;
	
	public String generateUniqueZapUrl () throws Exception;
	
	public ZapUrlDto getZapUrl(String zapValue)  throws Exception;
	
	public boolean isCaptchaValid(String remoteAddr,String challenge,String  uresponse)  throws Exception;
}
