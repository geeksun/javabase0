package com.base.filter;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * @author geeksun
 * @category 过滤未登录的非法URL请求
 * 2009-11-15
 */
public class LoginFilter implements Filter{
	protected String forwardPath = null;						  //  跳转路径
	protected FilterConfig filterConfig = null;
	
	public void destroy() {
		this.filterConfig = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		
		String requesturi = httpServletRequest.getRequestURI();
		// 通过检查session中的变量，过滤请求
		HttpSession session = httpServletRequest.getSession();
		Object currentUser = session.getAttribute("user");
		Object currentManager = session.getAttribute("manager");
		// 当前会话用户为空而且不是请求登录，退出登录，欢迎页面和根目录则退回到应用的根目录
		// 这样配置的效果就是当用户未登陆，直接键入 URL 请求系统资源会被自动退回到 index.ftl 页面
		if (currentUser == null && currentManager == null
				&& !requesturi.endsWith("/login.action")		//  endsWith(String suffix): 字符串是否以指定的后缀结束
				&& !requesturi.endsWith("/managerLogin.action")
				&& !requesturi.endsWith("/login.ftl")
				&& !requesturi.endsWith(httpServletRequest.getContextPath()	+ "/"))
				{
					httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/");
					return;          // 结束过滤，不再执行 chain.doFilter(request,response)
				}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		this.forwardPath = filterConfig.getInitParameter("forwardpath");
	}

}
