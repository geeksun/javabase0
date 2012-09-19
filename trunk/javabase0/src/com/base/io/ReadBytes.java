package com.base.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author ��־ǿ
 *  ��ȡ�ֽڣ�1���ո��һ�����֣�һ����ĸ����һ���ֽڣ�byte
 *  2009-4-25
 */
public class ReadBytes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			//D:\work\mianshi\class.dat  �ڹ���Ӧ�õ����·����
			System.out.println(new File("class.dat").getAbsolutePath());
			
			FileInputStream file = new FileInputStream("op.txt");
			boolean eof = false;
			int count = 0;
			while(!eof){
				int input = file.read();
				System.out.print(input + " ");
				//�����ļ�β
				if(input == -1)
					eof = true;
				else
					count++;
			}
			file.close();
			System.out.println("\nBytes read: " + count);
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}
