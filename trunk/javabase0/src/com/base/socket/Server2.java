package com.base.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 姜志强
 * @annotation: 单向通信和服务器套接字:和Client2配合
 * @create at 2009-4-12
 */
public class Server2 {

	private BufferedReader reader;	//负责输入
	private ServerSocket server;	//服务器套接字
	private Socket socket;	//套接字
	public Server2(){
	}
	
	/**
	 *  启动服务器
	 */
	void startServer(){
		try{
			server = new ServerSocket(7777);	//创建服务器套接字
			System.out.println("服务器套接字创建完毕");
			while(true){
				System.out.println("等待客户机");
				
				socket = server.accept();	//若客户端提出连接请求，则使其与 socket 连接
				System.out.println("完成与客户机的连接");
				
				//获取 socket 输入流
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				getMessage();		//读取来自客户机的数据，并输出到画面上
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 *  读取来自套接字的信息
	 */
	void getMessage(){
		try{
			while(true){
				
				//从套接字输入流中读取一行数据，并输出至画面上
				System.err.println("客户机：" + reader.readLine());
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			System.err.println("客户机中断连接");
			try{
				if(reader != null)
					reader.close();		//关闭套接字的输入流
				if(socket != null)		//关闭套接字
					socket.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Server2 server = new Server2();
		server.startServer();
		
	}

}
