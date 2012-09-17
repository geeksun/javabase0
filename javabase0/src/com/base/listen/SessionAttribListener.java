package com.base.listen;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionAttributeListener;

/**
 * @author 姜志强
 * 用户在线时间的统计
 * 对于没有正常退出的, 可以记录服务器移走用户信息属性的时间,减去你设置的timeout时间,就是用户的退出时间了.
 */
public class SessionAttribListener implements HttpSessionAttributeListener {
	public SessionAttribListener() { 
		
	}       
	public void attributeAdded(HttpSessionBindingEvent se) { 
			HttpSession session = se.getSession( );       
			String id = session.getId( );        
			String name = se.getName( );       
			String value = (String) se.getValue( );     
			String source = se.getSource( ).getClass( ).getName( );  
			
			//这里只是打印，你可以把它放在Session里的某个Map或者List里,这Map或者List就是所有用户的列表了        
			String message = new StringBuffer("Attribute bound to session in ").append(source).
			append("\nThe attribute name: ").append(name).append("\n").append("The attribute value:")
			.append(value).append("\n").append("The session ID: ").append(id).toString( );              
			System.out.println(message);     
	}        
	public void attributeRemoved(HttpSessionBindingEvent se) {      
		HttpSession session = se.getSession( );        
		String id = session.getId( );         
		String name = se.getName( );         
		if(name == null)  
			name = "Unknown";         
		String value = (String) se.getValue( );         
		String source = se.getSource( ).getClass( ).getName( );
		
		//这里只是打印，你可以把它放在Session里的某个Map或者List里,这Map或者List就是所有用户的列表了,此时别忘了从Map或者List移走这个id         
		String message = new StringBuffer("Attribute unbound from session in ").append(source).
		append("\nThe attribute name: ").append(name).
		append("\n").append("The attribute value: ").
		append(value).append("\n").append("The session ID: ").append(id).toString( ); 
		System.out.println(message);     
	}        
	public void attributeReplaced(HttpSessionBindingEvent se) {     
		String source = se.getSource( ).getClass( ).getName( );       
		String message = new StringBuffer("Attribute replaced in session  ").
		append(source).toString( );          
		System.out.println(message);    
	}
}
