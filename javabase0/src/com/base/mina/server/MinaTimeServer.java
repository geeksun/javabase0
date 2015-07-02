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
 * Description ��������MINA�����
 * @author Administrator
 * 2012-10-21
 */
public class MinaTimeServer {
	
	private static final int PORT = 9123;											// ��������˿�

	public static void main(String[] args) throws IOException {
		//��������˼���
		IoAcceptor acceptor = new NioSocketAcceptor();
		acceptor.getFilterChain().addLast("logger", new LoggingFilter());
		acceptor.getFilterChain().addLast(
				"codec",
				new ProtocolCodecFilter(new TextLineCodecFactory(Charset
						.forName("GBK"))));											// ָ�����������
		// ���������, �趨���������
		/*ProtocolCodecFilter filter = new ProtocolCodecFilter(new ObjectSerializationCodecFactory());
		acceptor.getFilterChain().addLast("objectFilter", filter);*/
		
		acceptor.setHandler(new TimeServerHandler());								// ָ��ҵ���߼�������
		acceptor.setDefaultLocalAddress(new InetSocketAddress(PORT));               // ���ö˿ں�
		acceptor.bind();                                                            // ��������
	}
}