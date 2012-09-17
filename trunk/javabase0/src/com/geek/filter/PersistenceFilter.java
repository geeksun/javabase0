package com.geek.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * @author : geeksun
 * @version : Session 管理的 Filter, 管理hibernate的Session
 * 
 */
public class PersistenceFilter {
	protected ThreadLocal hibernateHolder = new ThreadLocal();
	
	public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
		try
		{
			chain.doFilter(request,response);
		}catch(Exception e){}
		finally{
			Session sess = (Session)hibernateHolder.get();
			if(sess!=null){
				hibernateHolder.set(null);
				try{
					sess.close();
				} catch(HibernateException e) { 
					throw new ServletException(e);
				}
			}
		}
    }
	
	
}