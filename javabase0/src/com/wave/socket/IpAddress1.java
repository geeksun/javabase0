package com.wave.socket;

import java.net.InetAddress;

/**
 * @author ��־ǿ
 * @annotation: InetAddress��IP��ַ��ص���
 * @create at 2009-4-10
 */
public class IpAddress1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InetAddress ip = null;
		try{
			ip = InetAddress.getByName("www.google.cn");
			System.err.println("��������" + ip.getHostName());
			System.err.println("����IP��ַ��" + ip.getHostAddress());
			System.err.println("����IP��ַ��" + InetAddress.getLocalHost().getHostAddress());
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
