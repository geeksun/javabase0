package com.base.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilterOutputStream;
import java.io.IOException;

/**
 * @author ��־ǿ 
 * �ַ��������FileWriter,��Unicodeת��Ϊ�ֽڡ�
 * update at 2009-4-25 ţ��Ҫæ
 */
public class FilterOut {
	
	public static void main(String[] args) throws IOException{
		//�ֽ��� begin
		File f = new File("G:\\moon.txt");
		//��ԭ�ļ���׷�����ݶ�������
		FileOutputStream fo = new FileOutputStream(f, true);
		//������
		FilterOutputStream fil = new FilterOutputStream(fo);
		
		for(int i='A';i<'Z';i++){
			fil.write(i);
		}
		fil.close();
		//�ֽ��� end
		
		//�ַ��� begin
		//��ԭ�ļ���׷�����ݶ�������
		FileWriter fr = new FileWriter("G:\\moon.txt", true);
		BufferedWriter bw = new BufferedWriter(fr);
		
		int i = 0;
		for(i=1;i<10;i++){
			bw.write(i);
		}
		if(i==10){		//�����ļ�β
			System.err.println(i);
			//�������г����ƽ̨ʹ�õ���β�ַ�, ��ʹ�����ڿ�ƽ̨ʱ���û����Ѻá�
			bw.newLine();	// д���зָ���
		}
		bw.close();
		//�ַ��� end
	}
}
