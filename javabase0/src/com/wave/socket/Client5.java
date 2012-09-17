package com.wave.socket;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author 姜志强
 * @annotation: 聊天程序的客户端：客户机之间通信
 * @create 2009-4-18
 */
public class Client5 extends Frame implements Runnable{
	private TextField nameBox = new TextField("<名字>");				//显示用户名字
	private TextArea msgView = new TextArea();
	private TextField sendBox = new TextField();
	private BufferedReader reader;		//
	private PrintWriter writer;
	private Socket socket;
	
	public Client5(String title){
		super(title);
		msgView.setEditable(false);
		
		//添加组件
		add(nameBox, "North");
		add(msgView, "Center");
		add(sendBox, "South");
		
		//添加动作事件监听器
		sendBox.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					//发送用户名及消息内容
					writer.println(nameBox.getText() + ":" + sendBox.getText());
					
					sendBox.setText("");		//清除 sendBox 内容
					
				}catch(Exception ee){
					ee.printStackTrace();
				}
			}
		});
		pack();
		
	}
	
	public void run(){
		while(true){
			try{
				//从输入流读取数据，然后添加至 msgView 中
				msgView.append(reader.readLine() + "\n");
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	private void connect(){
		try{
			msgView.append("尝试与服务器套接字连接\n");
			socket = new Socket("127.0.0.1", 7777);
			msgView.append("聊天准备完毕\n");
			
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new PrintWriter(socket.getOutputStream(), true);
			new Thread(this).start();
		}catch(Exception e){
			msgView.append("连接失败..");
			e.printStackTrace();
			
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Client5 client = new Client5("聊天");
		
		client.setVisible(true);
		client.connect();
	}

}
