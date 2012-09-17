package com.wave.socket;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 姜志强
 * @annotation: 双向通信：客户机和服务机相互通信,此服务机只支持单客户机连接。
 * @create at 2009-4-14
 */
public class Server3 {
	private DataInputStream reader;			//输入流
	private DataOutputStream writer;		//输出流
	private ServerSocket server;			//服务器套接字
	private Socket socket;			//套接字
	
	void startServer3(){	//启动服务器
		try{
			server = new ServerSocket(7777);
			System.out.println("服务器套接字被成功创建");
			while(true){
				System.out.println("等待客户机连接请求");
				socket = server.accept();
				System.out.println("连接客户机完毕");
				
				//获取 socket 的输入输出流
				reader = new DataInputStream(socket.getInputStream());
				writer = new DataOutputStream(socket.getOutputStream());
				
				getCommand();		//与客户机进行通信
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	void getCommand(){
		try{
			while(true){
				String fileName = reader.readUTF();		//获取文件名
				
				//向客户端传送文件内容
				writer.writeUTF(getFileInfo(fileName));
				writer.flush();
				
				System.out.println(fileName + "的信息传送完毕");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			System.out.println("与客户机的连接中断");
			try{
				if(reader!=null)reader.close();
				if(writer!=null)writer.close();
				if(socket!=null)socket.close();
				reader = null;
				writer = null;
				socket = null;
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * @param fileName
	 * @return 文件内容
	 */ 
	String getFileInfo(String fileName){
		String fileInfo = "";
		try{
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String temp;
			while((temp = br.readLine())!=null){
				fileInfo += temp + "\n";
			}
			br.close();
		}catch(FileNotFoundException e){
			fileInfo = "文件不存在";
		}catch(IOException ie){
			ie.printStackTrace();
		}
		return fileInfo;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Server3 server = new Server3();
		server.startServer3();
	}

}
