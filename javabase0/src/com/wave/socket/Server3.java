package com.wave.socket;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ��־ǿ
 * @annotation: ˫��ͨ�ţ��ͻ����ͷ�����໥ͨ��,�˷����ֻ֧�ֵ��ͻ������ӡ�
 * @create at 2009-4-14
 */
public class Server3 {
	private DataInputStream reader;			//������
	private DataOutputStream writer;		//�����
	private ServerSocket server;			//�������׽���
	private Socket socket;			//�׽���
	
	void startServer3(){	//����������
		try{
			server = new ServerSocket(7777);
			System.out.println("�������׽��ֱ��ɹ�����");
			while(true){
				System.out.println("�ȴ��ͻ�����������");
				socket = server.accept();
				System.out.println("���ӿͻ������");
				
				//��ȡ socket �����������
				reader = new DataInputStream(socket.getInputStream());
				writer = new DataOutputStream(socket.getOutputStream());
				
				getCommand();		//��ͻ�������ͨ��
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	void getCommand(){
		try{
			while(true){
				String fileName = reader.readUTF();		//��ȡ�ļ���
				
				//��ͻ��˴����ļ�����
				writer.writeUTF(getFileInfo(fileName));
				writer.flush();
				
				System.out.println(fileName + "����Ϣ�������");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			System.out.println("��ͻ����������ж�");
			try{
				if(reader!=null)reader.close();
				if(writer!=null)writer.close();
				if(socket!=null)socket.close();
				reader = null;
				writer = null;
				socket = null;
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * @param fileName
	 * @return �ļ�����
	 */ 
	String getFileInfo(String fileName){
		String fileInfo = "";
		try{
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String temp;
			while((temp = br.readLine())!=null){
				fileInfo += temp + "\n";
			}
			br.close();
		}catch(FileNotFoundException e){
			fileInfo = "�ļ�������";
		}catch(IOException ie){
			ie.printStackTrace();
		}
		return fileInfo;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Server3 server = new Server3();
		server.startServer3();
	}

}
