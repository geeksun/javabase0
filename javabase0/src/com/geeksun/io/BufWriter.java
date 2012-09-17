package com.geeksun.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author wave
 * @category BufferedWriter:以行为单位进行输入\输出,在类内部使用了缓冲(buffer)机制
 * 2009-4-25
 */
public class BufWriter {
	public static void main(String[] args) throws IOException{
		FileOutputStream fo = new FileOutputStream("G:\\moon.txt",true);
		OutputStreamWriter os = new OutputStreamWriter(fo);
		BufferedWriter bw = new BufferedWriter(os);
		
		bw.write("国防大学");			// 将字符串写入到输出流中
		bw.flush();					// 将缓冲区的数据强制写和输出流
		bw.newLine();				// 换行
		bw.write("glad");
		bw.flush();
		bw.newLine();
		
		bw.close();
		
		FileInputStream fi = new FileInputStream("G:\\moon.txt");
		InputStreamReader is = new InputStreamReader(fi);
		BufferedReader br = new BufferedReader(is);
		
		System.out.println(br.readLine());				// 读取一行
		System.out.println(br.readLine());
		
		br.close();
	}
}
