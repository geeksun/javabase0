package com.base.mina.client;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

/**
 * Description TimeClientHandler������Ϣ�����¼�
 * @author Administrator 
 * 2012-10-21
 */
public class TimeClientHandler extends IoHandlerAdapter {

	public TimeClientHandler() {
	}

	@Override
	public void messageReceived(IoSession session, Object message)
			throws Exception {
		System.out.println("��������������Ϣ:" + message);													// ��ʾ���յ�����Ϣ
	}

}
