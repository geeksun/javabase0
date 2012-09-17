package com.geeksun.io;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author 姜志强
 *  DataOutputStream 继承自 FilterOutputStream , 实现了 DataOutput 接口
 *  filter stream 可以用于处理诸如: char,int,double,String 的数据.InputStream 和 OutputStream以
 *  byte为单位读写数据, 很处理这些。
 *  Demo 流程图： 文件 --> fos --> dos --> 数据
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
		
		//读取时，按照存入的数据类型读取非常重要
		name = dis.readUTF();
		age = dis.readInt();
		height = dis.readInt();
		country = dis.readUTF();
		
		dis.close();
		
		System.out.println("名字:" + name);
		System.out.println("年龄:" + age);
		System.out.println("身高:" + height);
		System.out.println("国藉:" + country);
		
	}

}
