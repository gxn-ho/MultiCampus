package com.boot.jdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.jdbc.biz.MyBiz;
import com.boot.jdbc.dto.CriteriaTen;
import com.boot.jdbc.dto.MainDto;
import com.boot.jdbc.dto.pageDTO2;

@Controller
@RequestMapping("/myboard")
public class ProjectController {
	
	@Autowired
	private MyBiz myBiz;
	private pageDTO2 pageDto;
	
	
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
	
	@GetMapping("/logintest")
	public String root2() {
		
		return "logintest";
	}
	
}
