package com.scope.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ScopeController")
public class ScopeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ScopeController() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		System.out.println("[controller]");
		
		String reqVal = (String)request.getAttribute("reqId");
		
		HttpSession session = request.getSession();
		String sessionVal = (String)session.getAttribute("sessionId");
		
		ServletContext application = getServletContext();
		String appVal = (String)application.getAttribute("appId");
		
		System.out.println("request: " + reqVal);
		System.out.println("session: " + sessionVal);
		System.out.println("application: " + appVal);
		
		request.setAttribute("reqId", "reqId in servlet");
		RequestDispatcher disp = request.getRequestDispatcher("result.jsp");
		disp.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
