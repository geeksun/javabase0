package com.base.socket;

import java.io.IOException;
import java.net.Socket;

/**
 * @author ��־ǿ
 * @annotation: Socket,�׽��֣��ڿͻ����ϴ������׽��֡���������������ӡ�
 * @create at 2009-4-12
 */
public class Client1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Socket client = null;
		try{
			System.err.println("���������������");
			client = new Socket("127.0.0.1", 7777);
			System.err.println("�������");
		}catch(Exception e){
			System.out.println("����ʧ��");
			e.printStackTrace();
		}finally{
			if(client != null){
				try {
					client.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
