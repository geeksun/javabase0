package com.base.listen;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionAttributeListener;

/**
 * @author ��־ǿ
 * �û�����ʱ���ͳ��
 * ����û�������˳���, ���Լ�¼�����������û���Ϣ���Ե�ʱ��,��ȥ�����õ�timeoutʱ��,�����û����˳�ʱ����.
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
			
			//����ֻ�Ǵ�ӡ������԰�������Session���ĳ��Map����List��,��Map����List���������û����б���        
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
		
		//����ֻ�Ǵ�ӡ������԰�������Session���ĳ��Map����List��,��Map����List���������û����б���,��ʱ�����˴�Map����List�������id         
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
