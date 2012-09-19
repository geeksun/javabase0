package com.base.io;

import java.io.IOException;

/**
 * @author geeksun
 * @category : System.in用于从键盘读取数据
 * @see 从键盘读取一个字节的数据
 */
public class SystemIn {
	public static void main(String[] args) throws IOException{
		System.out.println("输入一个字符,并以Enter结束");
		char r = (char)System.in.read();
		
		System.out.println("输入的字符为 "+r);
	}
}
