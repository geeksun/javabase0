package com.base.io;

import java.io.IOException;

/**
 * @author geeksun
 * @category : System.in���ڴӼ��̶�ȡ����
 * @see �Ӽ��̶�ȡһ���ֽڵ�����
 */
public class SystemIn {
	public static void main(String[] args) throws IOException{
		System.out.println("����һ���ַ�,����Enter����");
		char r = (char)System.in.read();
		
		System.out.println("������ַ�Ϊ "+r);
	}
}
