package com.geeksun.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * @author 姜志强
 *  使用低层API来读取URL的内容
 *  run notice:URL 必须是一个域名如 www.sun.com 或者 IP 地址。不能加上 http:// 作为 URL 的一部分。
 */
public class LowUrl {
	/**
	 * 直接使用底层的套接字来读取URL中的内容
	 * @throws Exception
	 */
	public static void main(String argv[]) throws Exception {
		final int HTTP_PORT = 80;
		
		if (argv.length != 1) {
			System.out.println("Usage: java ReadURL1 ");
			//  终止虚拟机的运行,0 表示正常终止,其他数字表示异常终止：返回退出的原因给系统 -- 0或1
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
