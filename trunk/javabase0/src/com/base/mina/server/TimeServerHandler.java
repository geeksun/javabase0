package com.base.mina.server;

import java.util.Date;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

/**
 * Description 业务逻辑处理器TimeServerHandler，继承自IoHandlerAdapter，
 * 实现的功能有：当客户端创建会话时会显示客户端设备的IP和端口；当客户端输入quit时结束会话；客户端输入其它内容时则向客户端发送当前时间。
 * @author Administrator
 * 2012-10-21
 */
public class TimeServerHandler extends IoHandlerAdapter {
	
	/**
	 * 会话创建时
	 */
	@Override
	public void sessionCreated(IoSession session) {
		//显示客户端的ip和端口
		System.out.println("Client IP:" + session.getRemoteAddress().toString());
	}
	
	/**
	 * 会话关闭
	 */
	public void sessionClosed(IoSession session){
		System.out.println("One client disconnect!");
	}

	/**
	 * 收到客户端发送的信息
	 */
	@Override
	public void messageReceived(IoSession session, Object message)
			throws Exception {
		//若传输对象
		//Object obj = message;
		
		String str = message.toString();
		if (str.trim().equalsIgnoreCase("quit")) {
			//结束会话,断开连接
			session.close(true);
			return;
		}
		
		Date date = new Date();
		// 将消息发送给客户机
		session.write("Server return to client: " + date.toString());															//返回当前时间的字符串 
		System.out.println("收到客户机发来的消息：" + str);
	}
}
