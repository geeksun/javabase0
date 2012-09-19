package com.base.io;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

/**
 * @author wave
 * @category FileReader:提供了将字符写入文件或从文件读出的简便方法,此例为BufferedReader的简化
 *  字符流：FileReader 从InputStreamReader 派生而来，读取字节流中的字节，并将其转化为表示Unicode字符的整数值。
 * @update at 2009-4-25
 */
public class FileRead {
	public static void main(String[] args) throws IOException{
		FileReader fr = new FileReader("G://moon.txt");
		BufferedReader br = new BufferedReader(fr);
		
		String s;
		
		while((s=br.readLine())!=null){
			System.out.println(s);
		}
		
		br.close();
	}
}
