package com.mvc.upgrade.common.interceptor;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{
	private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	// Controller 실행 요청 전에 수행되는 메소드.
	// return false일 경우 controller 실행x.
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
							Object handler) throws IOException {
		logger.info("[interceptor] : preHandle");
		
		if(request.getRequestURI().contains("/loginform.do")
		||request.getRequestURI().contains("/ajaxlogin.do")
		||request.getSession().getAttribute("login") != null
		||request.getRequestURI().contains("/test.do")) {
			return true;
		}
		
		if(request.getSession().getAttribute("login") == null) {
			response.sendRedirect("loginform.do");
			return false;
		}
		
		
		return false;
	}
	
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
							Object handler, ModelAndView modelAndView) {
		logger.info("[interceptor] : postHandle");
	}
		
		
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
								Object handler, Exception ex) {
		logger.info("[interceptor] : afterCompletion");
	}
	
	
		
		
		
		
		
		
}
	
	
	
	
	
	
	
	
	
	

