package com.base.io;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

/**
 * @author wave
 * @category FileReader:�ṩ�˽��ַ�д���ļ�����ļ������ļ�㷽��,����ΪBufferedReader�ļ�
 *  �ַ�����FileReader ��InputStreamReader ������������ȡ�ֽ����е��ֽڣ�������ת��Ϊ��ʾUnicode�ַ�������ֵ��
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
