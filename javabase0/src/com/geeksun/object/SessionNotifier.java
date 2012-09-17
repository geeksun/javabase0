package com.geeksun.object;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * @author 姜志强
 *  获取当前的活动 session (会话)数, 用户数。。。 可用于监控、跟踪用户并发访问应用数量及应用响应用户请求的时间等性能参数。
 *  2009-5-17
 */
public class SessionNotifier implements HttpSessionBindingListener {
	public static int activeSessions = 0;
	
	public SessionNotifier(){
		System.out.println("activeSessions= " + activeSessions);
	}
	
	/**
	 *  当 HttpSession 被绑定时, 触发事件
	 */
	public void valueBound(HttpSessionBindingEvent e) {
		HttpSession session = e.getSession();
		//handle session
		activeSessions++;
	}

	/**
	 *  当 HttpSession 被解除绑定时, 触发事件
	 */
	public void valueUnbound(HttpSessionBindingEvent e) {
		activeSessions--;
		HttpSession session = e.getSession();
		//handle session
	}

	public int getActiveSessions(){
		return activeSessions;
	}
	
}
