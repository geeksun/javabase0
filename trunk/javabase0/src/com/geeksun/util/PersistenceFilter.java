package com.geeksun.util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * @author Administrator
 * ����Web������ԣ����ǿ��Խ���Servlet2.3�淶���������Filter���ƣ�����ʵ���߳����������ڵ�Session����
 */
public class PersistenceFilter implements Filter{
	protected static ThreadLocal hibernateHolder = new ThreadLocal();
	/* 
	 * ͨ����doFilter�л�ȡ�͹ر�Session���������������е����ж���Filter���������Filter�����串�ǵ�Servlet ����������
	 * �Դ�Session ʵ���������ã���֤��һ��Http Request���������ֻռ��һ��Session��������������ܱ��֡�
	 * ��ʵ������У�Session�����������̼߳���һ���Ѿ��㹻.
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	throws IOException, ServletException
	{
		hibernateHolder.set(HibernateSessionFactory.getSession());
		try
		{
			chain.doFilter(request, response);
		}
		finally
		{
			Session sess = (Session)hibernateHolder.get();
			if (sess != null)
			{
				hibernateHolder.set(null);
				try
				{
					sess.close();
				}
				catch (HibernateException ex) {
					throw new ServletException(ex);
				}
			}
		}
	}
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
}

