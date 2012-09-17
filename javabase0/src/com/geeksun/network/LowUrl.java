package com.geeksun.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * @author ��־ǿ
 *  ʹ�õͲ�API����ȡURL������
 *  run notice:URL ������һ�������� www.sun.com ���� IP ��ַ�����ܼ��� http:// ��Ϊ URL ��һ���֡�
 */
public class LowUrl {
	/**
	 * ֱ��ʹ�õײ���׽�������ȡURL�е�����
	 * @throws Exception
	 */
	public static void main(String argv[]) throws Exception {
		final int HTTP_PORT = 80;
		
		if (argv.length != 1) {
			System.out.println("Usage: java ReadURL1 ");
			//  ��ֹ�����������,0 ��ʾ������ֹ,�������ֱ�ʾ�쳣��ֹ�������˳���ԭ���ϵͳ -- 0��1
			System.exit(0);
		}
		Socket socket = new Socket(argv[0], HTTP_PORT);
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		// this line action is ?
		out.write("GET /index.html HTTP/1.0\n\n");
		out.flush();
		String line;
		StringBuffer sb = new StringBuffer();
		while ((line = in.readLine()) != null) {
			sb.append(line);
		}
		out.close();
		in.close();
		System.out.println(sb.toString());
	}
}
