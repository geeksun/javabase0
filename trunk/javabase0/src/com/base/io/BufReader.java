package com.base.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * @author wave
 * @category BufferedReader:����Ϊ��λ��������\��ȡ,�����ڲ�ʹ���˻���(buffer)����
 * @version  ���ļ���һ��һ�еض�ȡ���ݲ����
 *  2009-4-25
 */
public class BufReader {
	public static void main(String[] args) throws IOException{
		FileInputStream fi = new FileInputStream("G://moon.txt");
		InputStreamReader is = new InputStreamReader(fi);
		BufferedReader br = new BufferedReader(is);
		
		String s ;
		
		// һ��һ�еض�ȡ���ݲ����
		while((s=br.readLine())!=null)			// ֻҪ s �� null,��ѭ������
			System.out.println(s);
		
		br.close();
	}
}
