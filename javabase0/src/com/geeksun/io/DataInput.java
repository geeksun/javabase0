package com.geeksun.io;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
/**
 * @author geeksun
 * @category FileInputStream:�̳���Filter Stream, ���Զ�ȡ�����������͵�����
 * 2009-5-6
 */
public class DataInput {
	public static void main(String[] args) throws IOException{
		File f = new File("G:\\moon.txt");
		FileInputStream fi = new FileInputStream(f);
		DataInputStream dis = new DataInputStream(fi);
		
		String name,country;
		int age,height;
		
		// ��ȡʱ,���մ�����������Ͷ����ǳ���Ҫ,���д����˳��Ҳ���ܴ�
		name = dis.readUTF();
		age = dis.readInt();
		height = dis.readInt();
		country = dis.readUTF();
		
		dis.close();
		
		System.out.println("name:"+name+" ����:"+age+" height:"+height+" country:"+country);
	}
}
