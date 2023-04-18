package com.mvc.upgrade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mvc.upgrade.model.biz.BoardBiz;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private BoardBiz biz;
	
	
	@RequestMapping("/list.do")
	public String list(Model model) {
		
		logger.info("SELECT LIST");
		model.addAttribute("list", biz.selectList());
		
		return "mvclist";
	}
	
	
	
	
	
	
}
