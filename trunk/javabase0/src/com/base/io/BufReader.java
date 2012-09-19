package com.base.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * @author wave
 * @category BufferedReader:以行为单位进行输入\读取,在类内部使用了缓冲(buffer)机制
 * @version  从文件中一行一行地读取数据并输出
 *  2009-4-25
 */
public class BufReader {
	public static void main(String[] args) throws IOException{
		FileInputStream fi = new FileInputStream("G://moon.txt");
		InputStreamReader is = new InputStreamReader(fi);
		BufferedReader br = new BufferedReader(is);
		
		String s ;
		
		// 一行一行地读取数据并输出
		while((s=br.readLine())!=null)			// 只要 s 非 null,则循环往复
			System.out.println(s);
		
		br.close();
	}
}
