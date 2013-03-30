package com.sudhakar.zapurl.controller;

import java.util.Date;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sudhakar.zapurl.dao.ZapUrlDao;
import com.sudhakar.zapurl.model.ZapUrl;

@Controller
@RequestMapping("/zap")
public class ZapHomeController {

	private static final Logger log = Logger.getLogger(ZapHomeController.class.getName());
	
	@Autowired
	private ZapUrlDao zapUrlDao;
	
	@RequestMapping(value="/home" ,method=RequestMethod.GET)
	public String home( Model model, HttpServletRequest request){

		
		return "home";
	}
	
	
	@RequestMapping(value="/home" ,method=RequestMethod.POST)
	public String zapIt( Model model, @ModelAttribute ZapUrl zapurl ,HttpServletRequest request) throws Exception{
		
		zapurl.setValidTill(new Date());
		zapurl.setZappedUrl(zapurl.getUrl());
		
		log.info("Model :"+zapurl);
		zapUrlDao.save(zapurl);
		
		return "home";
	}
}
