package com.base.mina.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

/**
 * Description 用来启动MINA服务端
 * @author Administrator
 * 2012-10-21
 */
public class MinaTimeServer {
	
	private static final int PORT = 9123;											// 定义监听端口

	public static void main(String[] args) throws IOException {
		//创建服务端监听
		IoAcceptor acceptor = new NioSocketAcceptor();
		acceptor.getFilterChain().addLast("logger", new LoggingFilter());
		acceptor.getFilterChain().addLast(
				"codec",
				new ProtocolCodecFilter(new TextLineCodecFactory(Charset
						.forName("GBK"))));											// 指定编码过滤器
		// 若传输对象, 设定对象过滤器
		/*ProtocolCodecFilter filter = new ProtocolCodecFilter(new ObjectSerializationCodecFactory());
		acceptor.getFilterChain().addLast("objectFilter", filter);*/
		
		acceptor.setHandler(new TimeServerHandler());								// 指定业务逻辑处理器
		acceptor.setDefaultLocalAddress(new InetSocketAddress(PORT));               // 设置端口号
		acceptor.bind();                                                            // 启动监听
	}
}
