package com.boot.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.mvc.model.biz.MyBiz;
import com.boot.mvc.model.dto.CriteriaTen;
import com.boot.mvc.model.dto.pageDTO2;

@Controller
@RequestMapping("/myboard")
public class ProjectController {
	
	@Autowired
	private MyBiz myBiz;
	
	
	@GetMapping("/list")
	public String selectList(Model model,int page) {
		CriteriaTen cri = new CriteriaTen(page, 10);
		model.addAttribute("list", myBiz.selectList(cri));
		model.addAttribute("pageMaker", new pageDTO2(cri, myBiz.getTotal()));
		return "projectallgridview";
	}
	
	@PostMapping("/starupdate")
	public String updateForm(Model model, int no) {
		model.addAttribute("dto",myBiz.selectOne(no));
		return "starupdate";
	}
	
	@GetMapping("/main")
	public String root() {
		
		return "main";
	}
}
