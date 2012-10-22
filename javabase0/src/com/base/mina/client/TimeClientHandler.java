package com.base.mina.client;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

/**
 * Description TimeClientHandler处理消息接收事件
 * @author Administrator 
 * 2012-10-21
 */
public class TimeClientHandler extends IoHandlerAdapter {

	public TimeClientHandler() {
	}

	@Override
	public void messageReceived(IoSession session, Object message)
			throws Exception {
		System.out.println("服务器发来的消息:" + message);													// 显示接收到的消息
	}

}
