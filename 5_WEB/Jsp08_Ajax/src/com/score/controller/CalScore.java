package com.score.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

@WebServlet("/CalScore")
public class CalScore extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String name = request.getParameter("name");
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int math = Integer.parseInt(request.getParameter("math"));
		
		int sum = kor+eng+math;
		double avg = (double)sum/3;
		
		//json_simple.jar: 자바에서 json 처리 위한 라이브러리
		//내부적으로 json 처리 위해서 map, list를 사용.
		//대표적인 클래스 JSONObject: HashMap을 상속받는다.
		
		JSONObject obj = new JSONObject();
		obj.put("name", name);
		obj.put("sum", sum);
		obj.put("avg", avg);
		// {"name":val, "sum":val, "avg":val}
		
		PrintWriter out = response.getWriter();
		out.print(obj);
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
