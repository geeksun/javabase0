package com.base.io;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author geeksun
 * @see FileOutputStream :文件写入流,负责向文件中写入数据
 * 
 */
public class OutStream {
	public static void main(String[] args) throws IOException{
		// 以追加模式打开文件
		FileOutputStream fo = new FileOutputStream("G:\\sun.txt",true);
		for(int i='a';i<='z';i++){
			fo.write(i);
		}
		fo.close(); 
	}
}
