package com.wave.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 姜志强
 * @annotation: ServerSocket 表示服务器套接字，一次只与一个套接字进行连接。会把请求的套接字放入队列中。
 * @create at 2009-4-12
 */
public class Server1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ServerSocket ssk = null;
		try{
			ssk = new ServerSocket(7777);	//使用指定的端口号创建服务器套接字对象
			System.err.println("服务器套接字已创建");
			while(true){
				System.out.println("等待客户机");
				Socket newSocket = ssk.accept();	//等待客户机的连接请求，若连接，刚创建一套接字，并将其返回。
				System.out.println("已与客户机连接");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(ssk != null){
				try {
					ssk.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}

}
