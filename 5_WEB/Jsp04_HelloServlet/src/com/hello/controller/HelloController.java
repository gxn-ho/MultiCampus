package com.hello.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloController")
public class HelloController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String initP;
	
	
    public HelloController() {
    	System.out.println("servlet 생성자!");
    }
    
    @Override
    public void init(ServletConfig config) {
    	System.out.println("servlet init(생성!)");
    	
    	initP = config.getInitParameter("driver");
    	System.out.println("contextP: "+ 
    					config.getServletContext().getInitParameter("url"));
    	
    	
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get방식!!");
		doPost(request,response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post방식!!");
		String command = request.getParameter("command");
		System.out.println("parameter: " + command);
		System.out.println("initP: "+initP);
		System.out.println("contextP: "+ 
				request.getServletContext().getInitParameter("url"));
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.print("<h1 style='background:skyblue;' >helloServlet</h1>");
		out.print("<h3>servlet 라이프사이클, url mapping</h3>");
		out.print("<a href='home.html'>홈으로</a>");
		
		
	}
	
	
	@Override
	public void destroy() {
		System.out.println("servlet destroy(종료!)");
	}
	
	
	
	
	

}
