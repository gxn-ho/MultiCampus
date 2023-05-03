package com.boot.leaf.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.boot.leaf.dto.LeafDto;

@Controller
public class LeafController {

	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("name","1");
		return "hello";
	}
	
	@GetMapping("/util")
	public String utility() {
		return "utility";
	}
	
	@GetMapping("/expr")
	public String expression(Model model) {
		model.addAttribute("name","Thymeleaf");
		
		LeafDto dto = new LeafDto("java", 1);
		model.addAttribute("dto", dto);
		
		List<LeafDto> list = new ArrayList<>();
		list.add(new LeafDto("Database",2));
		list.add(new LeafDto("HTML/CSS",3));
		model.addAttribute("list",list);
		
		return "expression";
	}
	@GetMapping("/param")
	public String param(HttpSession session, Model model) {
		session.setAttribute("pw", "session value");
		return "params";
	}
	
	@GetMapping("static")
	public String statics() {
		return "static";
	}
	
	
	
	
	
	
	
	
}
