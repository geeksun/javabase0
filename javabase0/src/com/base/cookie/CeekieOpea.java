package com.base.cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 姜志强
 * JAVA 操作 cookie
 */
public class CeekieOpea {
	String name;
	String password;
	Cookie namecookie;
	Cookie passwordcookie;
	Cookie optioncookie;
	HttpServletRequest request;
	HttpServletResponse response;
	/*
	 * 写cookie
	*/
	public void writeCookie()
	{
		Cookie namecookie = new Cookie("name",name);
		Cookie passwordcookie = new Cookie("password",password);
		Cookie optioncookie = new Cookie("option","1");
	}
	//生命周期    
	public void active()
	{
		namecookie.setMaxAge(60*60*24*365);
		passwordcookie.setMaxAge(60*60*24*365);
		optioncookie.setMaxAge(60*60*24*365);
		    
		response.addCookie(namecookie);
		response.addCookie(passwordcookie); 
		response.addCookie(optioncookie); 
	}
	/*
	 * 读cookie
	*/
	public void readCookie()
	{
		Cookie[] cookies = request.getCookies(); 
		if(cookies!=null)
		{
		    String name = "";
		    String password = "";
		    String option = "";
		    for (int i = 0; i < cookies.length; i++) 
		    {
		       Cookie c = cookies[i];     
		       if(c.getName().equalsIgnoreCase("name"))
		       {
		    	  
		          name = c.getValue();
		       }
		       else if(c.getName().equalsIgnoreCase("password"))
		       {
		          password = c.getValue();
		       }
		       else if(c.getName().equalsIgnoreCase("option"))
		       {
		          option = c.getValue();
		       }     
		    } 
		}
	}
}