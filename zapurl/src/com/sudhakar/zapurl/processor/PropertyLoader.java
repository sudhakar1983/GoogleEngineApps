package com.sudhakar.zapurl.processor;

import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {

	private final static Properties property ;
	
	static{
		property = new Properties(); 
		try {
			property.load(PropertyLoader.class.getClassLoader().getResourceAsStream("message.properties"))	;
		} catch (IOException e) {
		
		}
	}
	
	
	public static String getProperty(String key){
		String temp=property.getProperty(key);
		return temp;
	}
}
