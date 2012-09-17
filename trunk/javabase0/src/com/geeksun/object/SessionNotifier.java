package com.geeksun.object;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * @author ��־ǿ
 *  ��ȡ��ǰ�Ļ session (�Ự)��, �û��������� �����ڼ�ء������û���������Ӧ��������Ӧ����Ӧ�û������ʱ������ܲ�����
 *  2009-5-17
 */
public class SessionNotifier implements HttpSessionBindingListener {
	public static int activeSessions = 0;
	
	public SessionNotifier(){
		System.out.println("activeSessions= " + activeSessions);
	}
	
	/**
	 *  �� HttpSession ����ʱ, �����¼�
	 */
	public void valueBound(HttpSessionBindingEvent e) {
		HttpSession session = e.getSession();
		//handle session
		activeSessions++;
	}

	/**
	 *  �� HttpSession �������ʱ, �����¼�
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
