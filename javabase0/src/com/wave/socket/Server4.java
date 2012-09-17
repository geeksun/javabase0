package com.wave.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Vector;

/**
 * @author 姜志强
 * @annotation: 多客户通信和服务机
 * @create at 2009-4-15
 */
public class Server4 {
	private ServerSocket server;
	Vector sManager = new Vector();	//管理套接字的 Vector
	Random rnd = new Random();		//创建随机数发生器
	
	public Server4(){
		
	}
	
	void startServer(){
		try{
			server = new ServerSocket(7777);
			System.out.println("服务器套接字已创建");
			while(true){
				Socket socket = server.accept();
				System.err.println("已经与客户机连接");
				
				//创建与客户机进行通信的线程，并启动它
				new KBBCom_Thread(socket).start();
				
				//向套接字管理器列表添加套接字
				sManager.add(socket);
				
				//对当前客户机连接数进行屏幕输出
				System.out.println("当前客户机连接数：" + sManager.size());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		Server4 server = new Server4();
		server.startServer();		//运行服务器
		
	}
	
	//与客户机进行通信的线程类
	class KBBCom_Thread extends Thread{
		Socket socket;		//套接字引用变量
		private DataInputStream reader;			//套接字输入流
		private DataOutputStream writer;		//套接字输出流
		
		KBBCom_Thread(Socket socket){
			this.socket = socket;
		}
		
		public void run(){
			try{
				//获取套接字的输入输出流
				reader = new DataInputStream(socket.getInputStream());
				writer = new DataOutputStream(socket.getOutputStream());
				
				String msg;
				//从输入流获取信息
				while((msg = reader.readUTF())!=null){
					if(msg.equals("OK")){	//若收到的信息为“OK”
						//向客户机传送0～2之间的整型随机数
						writer.writeInt(rnd.nextInt(3));
						writer.flush();
					}
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				//与客户机断开连接后，进行的处理
				try{
					sManager.remove(socket);		//从套接字管理器列表中删除套接字
					
					//关闭输入输出流及套接字
					if(reader!=null)	reader.close();
					if(writer!=null)	writer.close();
					if(socket!=null)	socket.close();
					reader = null;
					writer = null;
					socket = null;
					
					//向屏幕输出相关信息
					System.out.println("客户机离开");
					System.out.println("当前客户机连接数：" + sManager.size());
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		
	}
	
}
