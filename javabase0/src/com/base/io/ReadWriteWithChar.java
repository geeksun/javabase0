package com.base.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;

/**
 * @author 姜志强
 *  字符输入输出流优化: 109:32
 *  二进制输入输出流用来处理二进制文件或对象流, 字符数据输入输出流处理文本文件和文本信息。本案为字符文件。
 *  2009-5-9
 */
public class ReadWriteWithChar {

	public static void main(String[] args) {
		try{
			String fileName = "e://test.txt";
			//直接读取文件内容
			Reader reader = new FileReader(fileName);
			long startTime = System.currentTimeMillis();
			int c;
			while((c=reader.read())!=-1){
				;		//too jd
			}
			long endTime = System.currentTimeMillis();
			System.out.println("直接读取与写入耗时：" + (endTime-startTime));
			reader.close();
			
			//通过数据缓冲流读取文件内容
			reader = new FileReader(fileName);
			reader = new BufferedReader(reader);
			startTime = System.currentTimeMillis();
			while((c=reader.read())!=-1){
				;
			}
			endTime = System.currentTimeMillis();
			System.out.println("通过系统缓冲区读取与写入耗时：" + (endTime-startTime));
			reader.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
