package com.base.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author 姜志强
 *  读取字节：1个空格或一个数字，一个字母都是一个字节：byte
 *  2009-4-25
 */
public class ReadBytes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			//D:\work\mianshi\class.dat  在工程应用的相对路径下
			System.out.println(new File("class.dat").getAbsolutePath());
			
			FileInputStream file = new FileInputStream("op.txt");
			boolean eof = false;
			int count = 0;
			while(!eof){
				int input = file.read();
				System.out.print(input + " ");
				//到达文件尾
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
