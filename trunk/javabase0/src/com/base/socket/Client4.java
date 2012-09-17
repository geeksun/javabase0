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
 * @author ��־ǿ
 * @annotation: ��ͻ�ͨ�źͷ����: ���ӣ�����������Ϸ�Ŀͻ���
 * @create at 2009-4-15
 */
public class Client4 extends Frame implements ActionListener{
	private TextArea msgView= new TextArea();
	private Button kwai, bawi, bo;		//���ӣ�����������ť
	private DataInputStream reader;
	private DataOutputStream writer;
	
	public static int KWAI = 0;		//���ӵĳ���
	public static int BAWI = 1;		//���ĳ���
	public static int BO = 2;		//�����ĳ���
	Socket socket;	
	
	public Client4(String title){
		super(title);
		msgView.setEditable(false);	//���ɱ༭
		
		//������Ҫ�İ�ť���󣬲��������
		kwai = new Button("����");
		bawi = new Button("��");
		bo = new Button("����");
		add(msgView, "Center");
		
		Panel p = new Panel();
		p.add(kwai);
		p.add(bawi);
		p.add(bo);
		add(p, "South");
		
		//����ť�¼�
		kwai.addActionListener(this);
		bawi.addActionListener(this);
		bo.addActionListener(this);
		
		pack();
	}
	
	private void conect(){
		try{
			msgView.append("�����������������\n");
			socket = new Socket("127.0.0.1", 7777);
			msgView.append("��ʼ��Ϸ\n");
			
			//��ȡ�׽��ֵ����������
			reader = new DataInputStream(socket.getInputStream());
			writer = new DataOutputStream(socket.getOutputStream());
		}catch(Exception e){
			msgView.append("����ʧ��");
		}
	}
	
	/**
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 *  �¼�������
	 */
	public void actionPerformed(ActionEvent ae) {
		//���ѡ���������ѡ��
		int player = -1;	//-1 ��ʾδѡ��״̬
		int server = -1;
		
		//�������������ѡ��
		if(ae.getSource() == kwai){
			player = KWAI;
		}else if(ae.getSource() == bawi){
			player = BAWI;
		}else if(ae.getSource() == bo){
			player = BO;
		}
		
		//�� player == -1�����˳��÷���
		if(player == -1){
			return;
		}
		
		
		try{
			//��������� ��OK��
			writer.writeUTF("OK");
			writer.flush();			//ǿ��ˢ�£�ǿ�����;
			
			//��ȡ������Ӧ�� 0��2 ֮��ĳ���
			server = reader.readInt();
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
		
		//����ʤ�����������ʾ�� msgView ��
		if(player == server)
			msgView.append("ƽ��\n");
		else if(player > server||server - player == 2)
			msgView.append("��ʤ\n");
		else 
			msgView.append("ʧ��\n");
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Client4 client = new Client4("���Ӱ�������Ϸ");
		client.setVisible(true);
		client.conect();
		
	}

}
