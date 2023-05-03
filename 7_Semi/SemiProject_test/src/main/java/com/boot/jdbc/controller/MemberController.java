package com.boot.jdbc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boot.jdbc.biz.MemberBiz;
import com.boot.jdbc.dto.MemberDto;

@Controller
public class MemberController {
	private Logger logger =LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberBiz biz;
	
	@RequestMapping("/loginform.do")
	public String loginForm() {
		logger.info("LOGIN FORM");
		return "logintest";
	}
	
	@RequestMapping(value="ajaxlogin.do", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Boolean> ajaxLogin(HttpSession session, @RequestBody MemberDto dto){
		//@RequestBody : request 객체로 넘어오는 데이터를 java객체
		//@ResponseBody : java객체를 response객체에 binding
		logger.info("LOGIN");
		
		MemberDto res=biz.login(dto);
		System.out.println(res);
		System.out.println(dto.getMemberid());
		System.out.println(dto.getMemberpw());
		boolean check=false;
		if(res!=null) {
			session.setAttribute("login", res);
			check=true;
		}
		
		Map<String, Boolean> map=new HashMap<String, Boolean>();
		map.put("check", check);
		
		
		return map;
	}
	
	
	
	
}
