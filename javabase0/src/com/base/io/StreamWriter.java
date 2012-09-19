package com.base.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author Administrator
 * @version OutputStreamWriter: 字符流,负责字符的读取(输入)工作
 * @category OutputStreamWriter : 以字符为单位进行输入输出的流,InputStreamReader:一次只能读取一个字符
 */
public class StreamWriter {
	public static void main(String[] args) throws IOException{
		FileOutputStream fo = new FileOutputStream("G:\\moon.txt");
		OutputStreamWriter osw = new OutputStreamWriter(fo);
		
		osw.write("姜志强");				// write a character to OutputStream
		osw.write("SUN");
		
		osw.close();
		
		FileInputStream fi = new FileInputStream("G:\\moon.txt");
		InputStreamReader isr = new InputStreamReader(fi);
		
		System.out.println((char)isr.read());
		System.out.println((char)isr.read());
		isr.close();
	}
}
