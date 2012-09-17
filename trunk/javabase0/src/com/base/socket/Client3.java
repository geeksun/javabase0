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
 * @author ��־ǿ
 * @annotation: ˫��ͨ�ŵĿͻ�����ͬserver3��Ӧ��
 * @create at 2009-4-14
 */
public class Client3 extends Frame {
	private TextArea ta = new TextArea();	//��ʾ�ļ��Ķ����ı���
	private TextField tf = new TextField();	//���������ļ����ĵ����ı���
	private DataInputStream reader;			//������
	private DataOutputStream writer;		//�����
	private Socket socket;			//�׽���
	
	public Client3(String title){
		super(title);
		ta.setEditable(false);
		add(ta, "Center");
		add(tf, "South");
		
		tf.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					//������������ļ���
					writer.writeUTF(tf.getText());
					writer.flush();
					
					//���׽��ֵ���������ȡ�ļ���
					String fileInfo = reader.readUTF();
					ta.setText("<" + tf.getText() + "������>\n\n");
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
	 *  ���ӷ�����: connect to server
	 */
	private void connect(){
		try{
			ta.append("���������������\n");
			socket = new Socket("127.0.0.1", 7777);
			ta.append("�������...�������ļ���\n");
			
			//��ȡ�׽��ֵ����������
			reader = new DataInputStream(socket.getInputStream());
			writer = new DataOutputStream(socket.getOutputStream());
			
		}catch(Exception e){
			ta.append("����ʧ��");
			e.printStackTrace();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Client3 client = new Client3("�鿴������ϵͳ�ļ�");
		client.setVisible(true);
		client.connect();
		
	}

}
