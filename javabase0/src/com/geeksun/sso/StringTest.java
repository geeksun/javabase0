package com.geeksun.sso;

import java.io.UnsupportedEncodingException;

public class StringTest {

	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 * ʹ��ָ�����ַ������� String ����Ϊ�ֽ����У���������洢��һ���µ��ֽ������С�
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		//  ���������ַ����Ը������ַ������н���,�����ֽ�����
		System.out.println("Test�й�".getBytes("gb2312")); 
		String orderId=new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
		System.out.println(orderId);
	}
	
}
