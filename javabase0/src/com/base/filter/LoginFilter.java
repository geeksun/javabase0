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
 * @category ����δ��¼�ķǷ�URL����
 * 2009-11-15
 */
public class LoginFilter implements Filter{
	protected String forwardPath = null;						  //  ��ת·��
	protected FilterConfig filterConfig = null;
	
	public void destroy() {
		this.filterConfig = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		
		String requesturi = httpServletRequest.getRequestURI();
		// ͨ�����session�еı�������������
		HttpSession session = httpServletRequest.getSession();
		Object currentUser = session.getAttribute("user");
		Object currentManager = session.getAttribute("manager");
		// ��ǰ�Ự�û�Ϊ�ն��Ҳ��������¼���˳���¼����ӭҳ��͸�Ŀ¼���˻ص�Ӧ�õĸ�Ŀ¼
		// �������õ�Ч�����ǵ��û�δ��½��ֱ�Ӽ��� URL ����ϵͳ��Դ�ᱻ�Զ��˻ص� index.ftl ҳ��
		if (currentUser == null && currentManager == null
				&& !requesturi.endsWith("/login.action")		//  endsWith(String suffix): �ַ����Ƿ���ָ���ĺ�׺����
				&& !requesturi.endsWith("/managerLogin.action")
				&& !requesturi.endsWith("/login.ftl")
				&& !requesturi.endsWith(httpServletRequest.getContextPath()	+ "/"))
				{
					httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/");
					return;          // �������ˣ�����ִ�� chain.doFilter(request,response)
				}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		this.forwardPath = filterConfig.getInitParameter("forwardpath");
	}

}
