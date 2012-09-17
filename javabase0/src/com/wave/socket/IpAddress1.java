package com.wave.socket;

import java.net.InetAddress;

/**
 * @author 姜志强
 * @annotation: InetAddress与IP地址相关的类
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
			System.err.println("主机名：" + ip.getHostName());
			System.err.println("主机IP地址：" + ip.getHostAddress());
			System.err.println("本机IP地址：" + InetAddress.getLocalHost().getHostAddress());
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
