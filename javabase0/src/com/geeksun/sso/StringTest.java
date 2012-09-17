package com.geeksun.sso;

import java.io.UnsupportedEncodingException;

public class StringTest {

	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 * 使用指定的字符集将此 String 解码为字节序列，并将结果存储到一个新的字节数组中。
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		//  将给定的字符串以给定的字符集进行解析,返回字节数组
		System.out.println("Test中国".getBytes("gb2312")); 
		String orderId=new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
		System.out.println(orderId);
	}
	
}
