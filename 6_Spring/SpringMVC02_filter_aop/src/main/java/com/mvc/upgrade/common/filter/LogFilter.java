package com.mvc.upgrade.common.filter;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogFilter implements Filter{

	private Logger logger = LoggerFactory.getLogger(LogFilter.class);
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//	전/후 처리
		
		HttpServletRequest req = (HttpServletRequest)request;
		String uri = req.getRequestURI();
		String url = req.getRequestURL().toString();
		String queryString = req.getQueryString();
		String addr = req.getRemoteAddr();
		
		String referer = req.getHeader("referer"); //이전 페이지(보내는 페이지) url
		logger.info("LOG FILTER");
		logger.info("uri: " + uri);
		logger.info("url: " + url);
		logger.info("queryString: " + queryString);
		logger.info("addr: " + addr);
		logger.info("referer: " + referer);
		
		chain.doFilter(request, response);
		//해당 필터 처리 후 다음 처리로 넘겨주는 역할
		//다음에 필터가 있다면 다음 필터 실행, 없다면 servlet 실행
		
		
		
		
		
	}

	@Override
	public void destroy() {
		
	}

}
