package com.mvc.upgrade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.upgrade.model.biz.BoardBiz;
import com.mvc.upgrade.model.dto.BoardDto;

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
	
	@RequestMapping("/insertform.do")
	public String insertFrom() {
		logger.info("INSERT FORM");
		return "mvcinsert";
	}
	
	@RequestMapping("/insertres.do")
	public String insertRes(BoardDto dto) {
		logger.info("INSERT RES");
		int res = biz.insert(dto);
		
		if(res>0) {
			return "redirect:list.do";
		}else {
			return "redirect:insertform.do";
		}
	}
	
	@RequestMapping("/detail.do")
	public String detail(Model model, int myno) {
		logger.info("SELECT ONE");
		model.addAttribute("dto", biz.selectOne(myno));
		return "mvcdetail";
	}
	
	
	
	
	
	@RequestMapping("/updateform.do")
	public String updateForm(Model model, int myno) {
		logger.info("SELECT ONE");
		model.addAttribute("dto", biz.selectOne(myno));
		return "mvcupdate";
	}
	
	@RequestMapping("/updateres.do")
	public String updateRes(BoardDto dto) {
		logger.info("UPDATE RES");
		
		int res = biz.upgrade(dto);
		if(res>0) {
			return "redirect:detail.do?myno="+dto.getMyno();
		}else {
			return "redirect:updateform.do?myno="+dto.getMyno();
		}
	}
	
	@RequestMapping("/delete.do")
	public String delete(int myno) {
		logger.info("DELETE");
		int res = biz.delete(myno);
		if(res>0) {
			return "redirect:list.do";
		}else {
			return "redirect:detail.do?myno="+myno;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
