package com.base.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ��־ǿ
 * @annotation: ����ͨ�źͷ������׽���:��Client2���
 * @create at 2009-4-12
 */
public class Server2 {

	private BufferedReader reader;	//��������
	private ServerSocket server;	//�������׽���
	private Socket socket;	//�׽���
	public Server2(){
	}
	
	/**
	 *  ����������
	 */
	void startServer(){
		try{
			server = new ServerSocket(7777);	//�����������׽���
			System.out.println("�������׽��ִ������");
			while(true){
				System.out.println("�ȴ��ͻ���");
				
				socket = server.accept();	//���ͻ����������������ʹ���� socket ����
				System.out.println("�����ͻ���������");
				
				//��ȡ socket ������
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				getMessage();		//��ȡ���Կͻ��������ݣ��������������
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 *  ��ȡ�����׽��ֵ���Ϣ
	 */
	void getMessage(){
		try{
			while(true){
				
				//���׽����������ж�ȡһ�����ݣ��������������
				System.err.println("�ͻ�����" + reader.readLine());
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			System.err.println("�ͻ����ж�����");
			try{
				if(reader != null)
					reader.close();		//�ر��׽��ֵ�������
				if(socket != null)		//�ر��׽���
					socket.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Server2 server = new Server2();
		server.startServer();
		
	}

}
