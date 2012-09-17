package com.wave.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Vector;

/**
 * @author ��־ǿ
 * @annotation: ��ͻ�ͨ�źͷ����
 * @create at 2009-4-15
 */
public class Server4 {
	private ServerSocket server;
	Vector sManager = new Vector();	//�����׽��ֵ� Vector
	Random rnd = new Random();		//���������������
	
	public Server4(){
		
	}
	
	void startServer(){
		try{
			server = new ServerSocket(7777);
			System.out.println("�������׽����Ѵ���");
			while(true){
				Socket socket = server.accept();
				System.err.println("�Ѿ���ͻ�������");
				
				//������ͻ�������ͨ�ŵ��̣߳���������
				new KBBCom_Thread(socket).start();
				
				//���׽��ֹ������б�����׽���
				sManager.add(socket);
				
				//�Ե�ǰ�ͻ���������������Ļ���
				System.out.println("��ǰ�ͻ�����������" + sManager.size());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		Server4 server = new Server4();
		server.startServer();		//���з�����
		
	}
	
	//��ͻ�������ͨ�ŵ��߳���
	class KBBCom_Thread extends Thread{
		Socket socket;		//�׽������ñ���
		private DataInputStream reader;			//�׽���������
		private DataOutputStream writer;		//�׽��������
		
		KBBCom_Thread(Socket socket){
			this.socket = socket;
		}
		
		public void run(){
			try{
				//��ȡ�׽��ֵ����������
				reader = new DataInputStream(socket.getInputStream());
				writer = new DataOutputStream(socket.getOutputStream());
				
				String msg;
				//����������ȡ��Ϣ
				while((msg = reader.readUTF())!=null){
					if(msg.equals("OK")){	//���յ�����ϢΪ��OK��
						//��ͻ�������0��2֮������������
						writer.writeInt(rnd.nextInt(3));
						writer.flush();
					}
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				//��ͻ����Ͽ����Ӻ󣬽��еĴ���
				try{
					sManager.remove(socket);		//���׽��ֹ������б���ɾ���׽���
					
					//�ر�������������׽���
					if(reader!=null)	reader.close();
					if(writer!=null)	writer.close();
					if(socket!=null)	socket.close();
					reader = null;
					writer = null;
					socket = null;
					
					//����Ļ��������Ϣ
					System.out.println("�ͻ����뿪");
					System.out.println("��ǰ�ͻ�����������" + sManager.size());
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		
	}
	
}
