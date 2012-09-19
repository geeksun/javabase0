package com.base.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author geeksun
 * @category : System.in���ڴӼ��̶�ȡ����
 * @see �Ӽ��̶�ȡһ������
 */
public class SystemIn3 {
	public static void main(String[] args) throws IOException {
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);				// ����������
		
		//true:������ԭ�е�����
		FileWriter fw = new FileWriter("G://moon.txt",true);
		BufferedWriter bw = new BufferedWriter(fw);
		
		System.out.println("����������(����Ϊ:of)");
		String data;
		
		while(true){
			data = br.readLine();								// ѭ�� ,ͬ for(;;)
			if(data.equals("of")) break;
			bw.write(data);
			bw.newLine();
		}
		bw.close();
		System.out.println("�ļ��������");
	}	
}
