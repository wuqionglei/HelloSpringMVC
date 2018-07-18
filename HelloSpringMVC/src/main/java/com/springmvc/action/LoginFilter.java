package com.springmvc.action;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springmvc.model.User;
//在请求是/user/*的时候拦截验证权限，没有权限重定向/login，有权限放行
public class LoginFilter implements Filter {			//登录拦截器

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		//登录权限验证
		HttpServletRequest hsq = (HttpServletRequest)req;
		User u = (User)hsq.getSession().getAttribute("loginUser");
		if(u==null) {
			((HttpServletResponse)resp).sendRedirect(hsq.getContextPath()+"/login");
		}
		chain.doFilter(req, resp);			//filter拦截下来之后，放行
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
