package com.geeksun.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * @author geeksun
 * @category : System.in用于从键盘读取数据
 * @see 从键盘读取一行数据
 */
public class SystemIn2 {
	public static void main(String[] args) throws IOException{
		System.out.println("输入一行数据,并以Enter结束");
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
		
		String s = br.readLine();
		System.out.println("刚才输入的数据为:"+s);
	}
}
