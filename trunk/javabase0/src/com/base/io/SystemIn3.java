package com.base.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author geeksun
 * @category : System.in用于从键盘读取数据
 * @see 从键盘读取一行数据
 */
public class SystemIn3 {
	public static void main(String[] args) throws IOException {
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);				// 键盘输入流
		
		//true:不覆盖原有的内容
		FileWriter fw = new FileWriter("G://moon.txt",true);
		BufferedWriter bw = new BufferedWriter(fw);
		
		System.out.println("请输入内容(结束为:of)");
		String data;
		
		while(true){
			data = br.readLine();								// 循环 ,同 for(;;)
			if(data.equals("of")) break;
			bw.write(data);
			bw.newLine();
		}
		bw.close();
		System.out.println("文件创建完毕");
	}	
}
