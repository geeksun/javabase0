package com.geeksun.io;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
/**
 * @author geeksun
 * @category FileInputStream:继承了Filter Stream, 可以读取基本数据类型的数据
 * 2009-5-6
 */
public class DataInput {
	public static void main(String[] args) throws IOException{
		File f = new File("G:\\moon.txt");
		FileInputStream fi = new FileInputStream(f);
		DataInputStream dis = new DataInputStream(fi);
		
		String name,country;
		int age,height;
		
		// 读取时,按照存入的数据类型读出非常重要,还有存入的顺序也不能错
		name = dis.readUTF();
		age = dis.readInt();
		height = dis.readInt();
		country = dis.readUTF();
		
		dis.close();
		
		System.out.println("name:"+name+" 年龄:"+age+" height:"+height+" country:"+country);
	}
}
