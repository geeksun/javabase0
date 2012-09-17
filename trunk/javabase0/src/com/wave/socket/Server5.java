package com.wave.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

/**
 * @author ��־ǿ
 * @annotation: �ͻ����໥ͨ��
 * @create at 2009-4-17
 */
public class Server5 {
	private ServerSocket server;
	private BManager bMan = new BManager();		//��Ϣ�㲥��
	public Server5(){}
	
	void startServer(){
		try{
			server = new ServerSocket(7777);
			System.out.println("�������׽��ִ������");
			while(true){
				Socket socket = server.accept();
				
				//������������ͻ���ͨ�ŵ��߳�
				new Chat_Thread(socket).start();
				
				//����Ϣ�㲥���б���� socket 
				bMan.add(socket);
				
				//��Ϣ�㲥�������пͻ������͵�ǰ��������
				bMan.sendClientInfo();
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Server5 server = new Server5();
		server.startServer();
		
	}
	
	/**
	 * @author ��־ǿ
	 *  ��ͻ���ͨ�ŵ��߳���
	 */
	class Chat_Thread extends Thread{
		Socket socket;
		private BufferedReader reader;
		private PrintWriter writer;
		
		Chat_Thread(Socket socket){
			this.socket = socket;
		}
		
		public void run(){
			try{
				reader = new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
				writer = new PrintWriter(socket.getOutputStream(), true);
				String msg;
				
				//���������ȡ��Ϣ
				while((msg = reader.readLine()) != null){
					System.out.println(msg);
					
					//�����пͻ���������Ϣ
					bMan.sendToAll(msg);
				}
			}catch(Exception e){
				System.out.println("���������ȡ����Ϣ�쳣");
				e.printStackTrace();
			}finally{
				try{
					//����Ϣ�㲥���б�ɾ�� socket
					bMan.remove(socket);
					if(reader != null) reader.close();
					if(writer != null) writer.close();
					if(socket != null) socket.close();
					reader = null;
					writer = null;
					socket = null;
					
					System.out.println("�ͻ����뿪");
					
					//�����пͻ������͵�ǰ��������
					bMan.sendClientInfo();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}

}



/**
 * @author ��־ǿ
 * ��Ϣ�㲥�߶��� �����пͻ������͸�������Ϣ
 */
class BManager extends Vector{
	BManager(){
		
	}
	
	void add(Socket socket){
		//����׽���
		super.add(socket);
	}
	
	void remove(Socket socket){
		//ɾ���׽���
		super.remove(socket);
	}
	
	/**
	 * ʹ���׽��ֵ����������� msg, �����пͻ������� msg��ͬ��������
	 */
	synchronized void sendToAll(String msg){
		PrintWriter writer = null;		//�����
		Socket socket;		//�׽���
		
		int len = size();
		for(int i=0;i<len;i++){
			socket = (Socket)elementAt(i);		//��ȡ�� i ���׽���
			try{
				//��ȡ�� i ���׽��������
				writer = new PrintWriter(socket.getOutputStream(), true);
			}catch(Exception e){
				e.printStackTrace();
			}
			
			//ʹ�õ� i ���׽������������� msg
			if(writer != null){
				writer.println(msg);
			}
		}
		
	}
	
	/**
	 * ʹ���׽��ֵ�������������ǰ��������
	 */
	synchronized void sendClientInfo(){
		String info = "��ǰ����������" + size();
		System.out.println(info);
		sendToAll(info);
	}
	
}