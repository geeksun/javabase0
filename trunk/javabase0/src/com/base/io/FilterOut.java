package com.base.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilterOutputStream;
import java.io.IOException;

/**
 * @author 姜志强 
 * 字符输出流：FileWriter,将Unicode转换为字节。
 * update at 2009-4-25 牛仔要忙
 */
public class FilterOut {
	
	public static void main(String[] args) throws IOException{
		//字节流 begin
		File f = new File("G:\\moon.txt");
		//在原文件中追加数据而不覆盖
		FileOutputStream fo = new FileOutputStream(f, true);
		//过滤流
		FilterOutputStream fil = new FilterOutputStream(fo);
		
		for(int i='A';i<'Z';i++){
			fil.write(i);
		}
		fil.close();
		//字节流 end
		
		//字符流 begin
		//在原文件中追加数据而不覆盖
		FileWriter fr = new FileWriter("G:\\moon.txt", true);
		BufferedWriter bw = new BufferedWriter(fr);
		
		int i = 0;
		for(i=1;i<10;i++){
			bw.write(i);
		}
		if(i==10){		//到达文件尾
			System.err.println(i);
			//发送运行程序的平台使用的行尾字符, 可使程序在跨平台时对用户更友好。
			bw.newLine();	// 写入行分隔符
		}
		bw.close();
		//字符流 end
	}
}
