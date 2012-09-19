package com.base.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author Administrator
 * @version OutputStreamWriter: �ַ���,�����ַ��Ķ�ȡ(����)����
 * @category OutputStreamWriter : ���ַ�Ϊ��λ���������������,InputStreamReader:һ��ֻ�ܶ�ȡһ���ַ�
 */
public class StreamWriter {
	public static void main(String[] args) throws IOException{
		FileOutputStream fo = new FileOutputStream("G:\\moon.txt");
		OutputStreamWriter osw = new OutputStreamWriter(fo);
		
		osw.write("��־ǿ");				// write a character to OutputStream
		osw.write("SUN");
		
		osw.close();
		
		FileInputStream fi = new FileInputStream("G:\\moon.txt");
		InputStreamReader isr = new InputStreamReader(fi);
		
		System.out.println((char)isr.read());
		System.out.println((char)isr.read());
		isr.close();
	}
}
