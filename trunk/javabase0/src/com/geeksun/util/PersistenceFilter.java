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
 * 对于Web程序而言，我们可以借助Servlet2.3规范中新引入的Filter机制，轻松实现线程生命周期内的Session管理
 */
public class PersistenceFilter implements Filter{
	protected static ThreadLocal hibernateHolder = new ThreadLocal();
	/* 
	 * 通过在doFilter中获取和关闭Session，并在周期内运行的所有对象（Filter链中其余的Filter，及其覆盖的Servlet 和其他对象）
	 * 对此Session 实例进行重用，保证了一个Http Request处理过程中只占用一个Session，提高了整体性能表现。
	 * 在实际设计中，Session的重用做到线程级别一般已经足够.
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

