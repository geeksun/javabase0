package com.base.socket;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author ��־ǿ
 * @annotation: ����ͨ���з����ַ����Ŀͻ��� AWT
 * @create at 2009-4-14
 */
public class Client2 extends Frame{
	private TextArea ta = new TextArea();	//show info multi textarea
	private TextField tf = new TextField();	//show info single textarea
	private PrintWriter writer;				//�׽��������
	Socket socket;							//�׽���
	
	public Client2(String title){
		super(title);
		ta.setEditable(false);		//ʹ�����ı��򲻿ɱ༭
		add(ta, "North");
		add(tf, "South");
		//��tf �����ַ����������� Enter ��
		//�����ַ���
		tf.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			
			//ʹ����������� sf �е��ַ���
			writer.println(tf.getText());
			//�� ta ��ӷ��͵��ַ���
			ta.append(tf.getText() + "\n");
			//��� tf �ڵ�����
			tf.setText("");
			}
		}
		);
		pack();			//�Զ�����Frame��С
	}
	
	private void connect(){			//ʵ���������������
		try{
			ta.append("���������������\n");
			socket = new Socket("127.0.0.1", 7777);
			ta.append("������ӡ���������ַ���\n");
			
			//�ر� socket �������
			writer = new PrintWriter(socket.getOutputStream(), true);
		}catch(Exception e){
			ta.append("����ʧ��");
		}
	}
	
	public static void main(String[] args) {
		Client2 client = new Client2("���������������");
		client.setVisible(true);
		client.connect();
	}

}
