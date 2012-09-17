package com.base.socket;

import java.io.IOException;
import java.net.Socket;

/**
 * @author 姜志强
 * @annotation: Socket,套接字，在客户机上创建的套接字。与服务器进行连接。
 * @create at 2009-4-12
 */
public class Client1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Socket client = null;
		try{
			System.err.println("尝试与服务器连接");
			client = new Socket("127.0.0.1", 7777);
			System.err.println("连接完成");
		}catch(Exception e){
			System.out.println("连接失败");
			e.printStackTrace();
		}finally{
			if(client != null){
				try {
					client.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
