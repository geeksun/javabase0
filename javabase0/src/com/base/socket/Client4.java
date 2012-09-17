package com.base.socket;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @author 姜志强
 * @annotation: 多客户通信和服务机: 剪子－包袱－锤游戏的客户端
 * @create at 2009-4-15
 */
public class Client4 extends Frame implements ActionListener{
	private TextArea msgView= new TextArea();
	private Button kwai, bawi, bo;		//剪子，布，包袱按钮
	private DataInputStream reader;
	private DataOutputStream writer;
	
	public static int KWAI = 0;		//剪子的常数
	public static int BAWI = 1;		//锤的常数
	public static int BO = 2;		//包袱的常数
	Socket socket;	
	
	public Client4(String title){
		super(title);
		msgView.setEditable(false);	//不可编辑
		
		//创建必要的按钮对象，并进行添加
		kwai = new Button("剪子");
		bawi = new Button("锤");
		bo = new Button("包袱");
		add(msgView, "Center");
		
		Panel p = new Panel();
		p.add(kwai);
		p.add(bawi);
		p.add(bo);
		add(p, "South");
		
		//处理按钮事件
		kwai.addActionListener(this);
		bawi.addActionListener(this);
		bo.addActionListener(this);
		
		pack();
	}
	
	private void conect(){
		try{
			msgView.append("尝试与服务器的连接\n");
			socket = new Socket("127.0.0.1", 7777);
			msgView.append("开始游戏\n");
			
			//获取套接字的输入输出流
			reader = new DataInputStream(socket.getInputStream());
			writer = new DataOutputStream(socket.getOutputStream());
		}catch(Exception e){
			msgView.append("连接失败");
		}
	}
	
	/**
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 *  事件处理动作
	 */
	public void actionPerformed(ActionEvent ae) {
		//玩家选择与服务器选择
		int player = -1;	//-1 表示未选中状态
		int server = -1;
		
		//保存玩家做出的选择
		if(ae.getSource() == kwai){
			player = KWAI;
		}else if(ae.getSource() == bawi){
			player = BAWI;
		}else if(ae.getSource() == bo){
			player = BO;
		}
		
		//若 player == -1，则退出该方法
		if(player == -1){
			return;
		}
		
		
		try{
			//向服务器发 “OK”
			writer.writeUTF("OK");
			writer.flush();			//强制刷新，强制输出;
			
			//获取服务器应答， 0－2 之间的常数
			server = reader.readInt();
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
		
		//处理胜负结果，并显示在 msgView 中
		if(player == server)
			msgView.append("平局\n");
		else if(player > server||server - player == 2)
			msgView.append("获胜\n");
		else 
			msgView.append("失败\n");
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Client4 client = new Client4("剪子包袱锤游戏");
		client.setVisible(true);
		client.conect();
		
	}

}
