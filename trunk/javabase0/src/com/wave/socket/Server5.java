package com.wave.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

/**
 * @author 姜志强
 * @annotation: 客户机相互通信
 * @create at 2009-4-17
 */
public class Server5 {
	private ServerSocket server;
	private BManager bMan = new BManager();		//消息广播者
	public Server5(){}
	
	void startServer(){
		try{
			server = new ServerSocket(7777);
			System.out.println("服务器套接字创建完毕");
			while(true){
				Socket socket = server.accept();
				
				//创建并运行与客户机通信的线程
				new Chat_Thread(socket).start();
				
				//向消息广播者列表添加 socket 
				bMan.add(socket);
				
				//消息广播者向所有客户机传送当前连接人数
				bMan.sendClientInfo();
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Server5 server = new Server5();
		server.startServer();
		
	}
	
	/**
	 * @author 姜志强
	 *  与客户机通信的线程类
	 */
	class Chat_Thread extends Thread{
		Socket socket;
		private BufferedReader reader;
		private PrintWriter writer;
		
		Chat_Thread(Socket socket){
			this.socket = socket;
		}
		
		public void run(){
			try{
				reader = new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
				writer = new PrintWriter(socket.getOutputStream(), true);
				String msg;
				
				//从输出流获取信息
				while((msg = reader.readLine()) != null){
					System.out.println(msg);
					
					//向所有客户机传送信息
					bMan.sendToAll(msg);
				}
			}catch(Exception e){
				System.out.println("从输出流获取的信息异常");
				e.printStackTrace();
			}finally{
				try{
					//从消息广播者列表删除 socket
					bMan.remove(socket);
					if(reader != null) reader.close();
					if(writer != null) writer.close();
					if(socket != null) socket.close();
					reader = null;
					writer = null;
					socket = null;
					
					System.out.println("客户机离开");
					
					//向所有客户机传送当前连接人数
					bMan.sendClientInfo();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}

}



/**
 * @author 姜志强
 * 消息广播者对象： 向所有客户机发送给定的消息
 */
class BManager extends Vector{
	BManager(){
		
	}
	
	void add(Socket socket){
		//添加套接字
		super.add(socket);
	}
	
	void remove(Socket socket){
		//删除套接字
		super.remove(socket);
	}
	
	/**
	 * 使用套接字的输出流，输出 msg, 向所有客户机传送 msg，同步化方法
	 */
	synchronized void sendToAll(String msg){
		PrintWriter writer = null;		//输出流
		Socket socket;		//套接字
		
		int len = size();
		for(int i=0;i<len;i++){
			socket = (Socket)elementAt(i);		//获取第 i 个套接字
			try{
				//获取第 i 个套接字输出流
				writer = new PrintWriter(socket.getOutputStream(), true);
			}catch(Exception e){
				e.printStackTrace();
			}
			
			//使用第 i 个套接字输出流，输出 msg
			if(writer != null){
				writer.println(msg);
			}
		}
		
	}
	
	/**
	 * 使用套接字的输出流，输出当前聊天人数
	 */
	synchronized void sendClientInfo(){
		String info = "当前聊天人数：" + size();
		System.out.println(info);
		sendToAll(info);
	}
	
}