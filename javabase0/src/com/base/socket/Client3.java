package com.base.socket;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 * @author 姜志强
 * @annotation: 双向通信的客户机，同server3对应。
 * @create at 2009-4-14
 */
public class Client3 extends Frame {
	private TextArea ta = new TextArea();	//显示文件的多行文本框
	private TextField tf = new TextField();	//用于输入文件名的单行文本框
	private DataInputStream reader;			//输入流
	private DataOutputStream writer;		//输出流
	private Socket socket;			//套接字
	
	public Client3(String title){
		super(title);
		ta.setEditable(false);
		add(ta, "Center");
		add(tf, "South");
		
		tf.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					//向服务器发送文件名
					writer.writeUTF(tf.getText());
					writer.flush();
					
					//从套接字的输入流获取文件名
					String fileInfo = reader.readUTF();
					ta.setText("<" + tf.getText() + "的内容>\n\n");
					ta.append(fileInfo);
					
					tf.setText("");
				}catch(Exception ee){
					ee.printStackTrace();
				}
			}
		});
		pack();
	}
	
	/**
	 *  连接服务器: connect to server
	 */
	private void connect(){
		try{
			ta.append("尝试与服务器连接\n");
			socket = new Socket("127.0.0.1", 7777);
			ta.append("连接完毕...请输入文件名\n");
			
			//获取套接字的输入输出流
			reader = new DataInputStream(socket.getInputStream());
			writer = new DataOutputStream(socket.getOutputStream());
			
		}catch(Exception e){
			ta.append("连接失败");
			e.printStackTrace();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Client3 client = new Client3("查看服务器系统文件");
		client.setVisible(true);
		client.connect();
		
	}

}
