package com.base.mina.server;

import java.util.Date;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

/**
 * Description ҵ���߼�������TimeServerHandler���̳���IoHandlerAdapter��
 * ʵ�ֵĹ����У����ͻ��˴����Ựʱ����ʾ�ͻ����豸��IP�Ͷ˿ڣ����ͻ�������quitʱ�����Ự���ͻ���������������ʱ����ͻ��˷��͵�ǰʱ�䡣
 * @author Administrator
 * 2012-10-21
 */
public class TimeServerHandler extends IoHandlerAdapter {
	
	/**
	 * �Ự����ʱ
	 */
	@Override
	public void sessionCreated(IoSession session) {
		//��ʾ�ͻ��˵�ip�Ͷ˿�
		System.out.println("Client IP:" + session.getRemoteAddress().toString());
	}
	
	/**
	 * �Ự�ر�
	 */
	public void sessionClosed(IoSession session){
		System.out.println("One client disconnect!");
	}

	/**
	 * �յ��ͻ��˷��͵���Ϣ
	 */
	@Override
	public void messageReceived(IoSession session, Object message)
			throws Exception {
		//���������
		//Object obj = message;
		
		String str = message.toString();
		if (str.trim().equalsIgnoreCase("quit")) {
			//�����Ự,�Ͽ�����
			session.close(true);
			return;
		}
		
		Date date = new Date();
		// ����Ϣ���͸��ͻ���
		session.write("Server return to client: " + date.toString());															//���ص�ǰʱ����ַ��� 
		System.out.println("�յ��ͻ�����������Ϣ��" + str);
	}
}
