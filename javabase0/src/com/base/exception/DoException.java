package com.base.exception;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DoException {
	/***
	 * “Ï≥£¥¶¿Ì
	 * @param e
	 * @param request
	 * @param response
	 */
	private  void doException(Exception e,HttpServletRequest request,HttpServletResponse response,String desc) {
		try{
			//Ω˚÷πª∫¥Ê 
			response.addHeader("Cache-Control", "private");
			response.addHeader("Pragma", "no-cache");
			response.addDateHeader("Expires", System.currentTimeMillis() - 24 * 60 * 1000);
			
			//log(e,desc);
			//ServletContext sc = this.getServletContext();
			//RequestDispatcher rd = sc.getRequestDispatcher("/404.html");
			//rd.forward(request, response);
		}catch(Exception ex){
			//log("doException error!",ex);
			//ex.printStackTrace();
		}
	}
}
