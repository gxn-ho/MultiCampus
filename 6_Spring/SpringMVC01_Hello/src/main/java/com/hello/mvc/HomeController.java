package com.hello.mvc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hello.mvc.dto.AddressDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
	
	@RequestMapping(value="/command.do", method=RequestMethod.GET)
	public String getCommand(Model model, String name, @RequestParam("addr")String address, String phone) {
		
		model.addAttribute("dto", new AddressDto(name, address, phone));
		
		return "getCommand";
	}
	
	@RequestMapping(value="/command.do", method=RequestMethod.POST)
	public String postCommand(Model model, @ModelAttribute AddressDto dto) {
		//1. 요청시 넘어오는 parameter를 받아 dto 객체에 저장하고
		//2. postCommand 페이지로 응답하여, 데이터 처리
		model.addAttribute("dto", dto);
		return "postCommand";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
