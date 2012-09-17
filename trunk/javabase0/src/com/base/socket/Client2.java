package com.base.socket;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author 姜志强
 * @annotation: 单向通信中发送字符串的客户机 AWT
 * @create at 2009-4-14
 */
public class Client2 extends Frame{
	private TextArea ta = new TextArea();	//show info multi textarea
	private TextField tf = new TextField();	//show info single textarea
	private PrintWriter writer;				//套接字输出流
	Socket socket;							//套接字
	
	public Client2(String title){
		super(title);
		ta.setEditable(false);		//使多行文本框不可编辑
		add(ta, "North");
		add(tf, "South");
		//向tf 输入字符串，并按下 Enter 键
		//传送字符串
		tf.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			
			//使用输出流传送 sf 中的字符串
			writer.println(tf.getText());
			//向 ta 添加发送的字符串
			ta.append(tf.getText() + "\n");
			//清空 tf 内的内容
			tf.setText("");
			}
		}
		);
		pack();			//自动调整Frame大小
	}
	
	private void connect(){			//实现与服务器的连接
		try{
			ta.append("尝试与服务器连接\n");
			socket = new Socket("127.0.0.1", 7777);
			ta.append("完成连接。清除待传字符串\n");
			
			//关闭 socket 的输出流
			writer = new PrintWriter(socket.getOutputStream(), true);
		}catch(Exception e){
			ta.append("连接失败");
		}
	}
	
	public static void main(String[] args) {
		Client2 client = new Client2("向服务器发送数据");
		client.setVisible(true);
		client.connect();
	}

}
