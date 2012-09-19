package com.base.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;

/**
 * @author ��־ǿ
 *  �ַ�����������Ż�: 109:32
 *  �����������������������������ļ��������, �ַ�������������������ı��ļ����ı���Ϣ������Ϊ�ַ��ļ���
 *  2009-5-9
 */
public class ReadWriteWithChar {

	public static void main(String[] args) {
		try{
			String fileName = "e://test.txt";
			//ֱ�Ӷ�ȡ�ļ�����
			Reader reader = new FileReader(fileName);
			long startTime = System.currentTimeMillis();
			int c;
			while((c=reader.read())!=-1){
				;		//too jd
			}
			long endTime = System.currentTimeMillis();
			System.out.println("ֱ�Ӷ�ȡ��д���ʱ��" + (endTime-startTime));
			reader.close();
			
			//ͨ�����ݻ�������ȡ�ļ�����
			reader = new FileReader(fileName);
			reader = new BufferedReader(reader);
			startTime = System.currentTimeMillis();
			while((c=reader.read())!=-1){
				;
			}
			endTime = System.currentTimeMillis();
			System.out.println("ͨ��ϵͳ��������ȡ��д���ʱ��" + (endTime-startTime));
			reader.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
