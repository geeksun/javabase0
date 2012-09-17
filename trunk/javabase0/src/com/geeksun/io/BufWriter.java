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
 * @category BufferedWriter:����Ϊ��λ��������\���,�����ڲ�ʹ���˻���(buffer)����
 * 2009-4-25
 */
public class BufWriter {
	public static void main(String[] args) throws IOException{
		FileOutputStream fo = new FileOutputStream("G:\\moon.txt",true);
		OutputStreamWriter os = new OutputStreamWriter(fo);
		BufferedWriter bw = new BufferedWriter(os);
		
		bw.write("������ѧ");			// ���ַ���д�뵽�������
		bw.flush();					// ��������������ǿ��д�������
		bw.newLine();				// ����
		bw.write("glad");
		bw.flush();
		bw.newLine();
		
		bw.close();
		
		FileInputStream fi = new FileInputStream("G:\\moon.txt");
		InputStreamReader is = new InputStreamReader(fi);
		BufferedReader br = new BufferedReader(is);
		
		System.out.println(br.readLine());				// ��ȡһ��
		System.out.println(br.readLine());
		
		br.close();
	}
}
