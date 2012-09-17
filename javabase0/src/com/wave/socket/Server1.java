package com.wave.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ��־ǿ
 * @annotation: ServerSocket ��ʾ�������׽��֣�һ��ֻ��һ���׽��ֽ������ӡ����������׽��ַ�������С�
 * @create at 2009-4-12
 */
public class Server1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ServerSocket ssk = null;
		try{
			ssk = new ServerSocket(7777);	//ʹ��ָ���Ķ˿ںŴ����������׽��ֶ���
			System.err.println("�������׽����Ѵ���");
			while(true){
				System.out.println("�ȴ��ͻ���");
				Socket newSocket = ssk.accept();	//�ȴ��ͻ������������������ӣ��մ���һ�׽��֣������䷵�ء�
				System.out.println("����ͻ�������");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(ssk != null){
				try {
					ssk.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}

}
