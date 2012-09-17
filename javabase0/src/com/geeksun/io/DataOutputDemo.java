package com.geeksun.io;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 姜志强
 *  DataOutputStream 继承自 FilterOutputStream , 实现了 DataOutput 接口
 *  filter stream 可以用于处理诸如: char,int,double,String 的数据.InputStream 和 OutputStream以
 *  byte为单位读写数据, 很处理这些。
 *  Demo 流程图： 数据 --> dos --> fos --> 文件
 *  2009-5-7
 */
public class DataOutputDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		File f = new File("e://test.txt");
		FileOutputStream fos = new FileOutputStream(f);
		DataOutputStream dos = new DataOutputStream(fos);
		
		dos.writeUTF("姜志强");	//将字符串"姜志强"按UTF格式写到输出流
		dos.writeInt(29);		//将int 型数据 29 写到输出流
		dos.writeInt(130);
		dos.writeUTF("中国");	
		
		dos.close();
		System.out.println("文件已创建完毕");
	}

}
