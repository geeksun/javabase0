package com.geeksun.io;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author ��־ǿ
 *  DataOutputStream �̳��� FilterOutputStream , ʵ���� DataOutput �ӿ�
 *  filter stream �������ڴ�������: char,int,double,String ������.InputStream �� OutputStream��
 *  byteΪ��λ��д����, �ܴ�����Щ��
 *  Demo ����ͼ�� �ļ� --> fos --> dos --> ����
 *  2009-5-7
 */
public class DataInputDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		File f = new File("e://test.txt");
		FileInputStream fis = new FileInputStream(f);
		DataInputStream dis = new DataInputStream(fis);
		String name, country;
		int age, height;
		
		//��ȡʱ�����մ�����������Ͷ�ȡ�ǳ���Ҫ
		name = dis.readUTF();
		age = dis.readInt();
		height = dis.readInt();
		country = dis.readUTF();
		
		dis.close();
		
		System.out.println("����:" + name);
		System.out.println("����:" + age);
		System.out.println("���:" + height);
		System.out.println("����:" + country);
		
	}

}
