package com.base.listen;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author 姜志强
 *  用户在线人数统计(show)
 */
public class SessionCounter implements HttpSessionListener {
	private static int activeSessions = 0; 

	public void sessionCreated(HttpSessionEvent se) { 
		activeSessions++; 
	} 

	public void sessionDestroyed(HttpSessionEvent se) { 
	if(activeSessions > 0) 
		activeSessions--; 
	} 

	public static int getActiveSessions() { 
		return activeSessions; 
	} 

}
