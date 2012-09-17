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
 * @author ��־ǿ
 * @annotation: �������Ŀͻ��ˣ��ͻ���֮��ͨ��
 * @create 2009-4-18
 */
public class Client5 extends Frame implements Runnable{
	private TextField nameBox = new TextField("<����>");				//��ʾ�û�����
	private TextArea msgView = new TextArea();
	private TextField sendBox = new TextField();
	private BufferedReader reader;		//
	private PrintWriter writer;
	private Socket socket;
	
	public Client5(String title){
		super(title);
		msgView.setEditable(false);
		
		//������
		add(nameBox, "North");
		add(msgView, "Center");
		add(sendBox, "South");
		
		//��Ӷ����¼�������
		sendBox.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					//�����û�������Ϣ����
					writer.println(nameBox.getText() + ":" + sendBox.getText());
					
					sendBox.setText("");		//��� sendBox ����
					
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
				//����������ȡ���ݣ�Ȼ������� msgView ��
				msgView.append(reader.readLine() + "\n");
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	private void connect(){
		try{
			msgView.append("������������׽�������\n");
			socket = new Socket("127.0.0.1", 7777);
			msgView.append("����׼�����\n");
			
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new PrintWriter(socket.getOutputStream(), true);
			new Thread(this).start();
		}catch(Exception e){
			msgView.append("����ʧ��..");
			e.printStackTrace();
			
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Client5 client = new Client5("����");
		
		client.setVisible(true);
		client.connect();
	}

}
