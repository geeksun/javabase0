package com.base.io;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author geeksun
 * @see FileOutputStream :�ļ�д����,�������ļ���д������
 * 
 */
public class OutStream {
	public static void main(String[] args) throws IOException{
		// ��׷��ģʽ���ļ�
		FileOutputStream fo = new FileOutputStream("G:\\sun.txt",true);
		for(int i='a';i<='z';i++){
			fo.write(i);
		}
		fo.close(); 
	}
}
