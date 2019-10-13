package com.haiwaibang.web;

import com.haiwaibang.common.utils.LoggerUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@Component
//@ServletComponentScan
//@WebFilter(urlPatterns = "/manage/*", filterName= "loginFilter")
public class LoginFilter implements Filter{
	
	public static final String SESSION_KEY = "user";
	public static final String LOGIN = "/login.html";

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		Object object = request.getSession().getAttribute(SESSION_KEY);
		if(object == null) response.sendRedirect(LOGIN);
		LoggerUtils.fmtInfo(LoginFilter.class, "用户%s 登陆成功", object);
		filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

}
