package com.geek.system;

/**
 * @author 姜志强
 * 查看系统的编码方式：操作系统默认支持的编码格式
 * JAVA默认支持的编码是UNICODE
 */
public class Charactor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String encoding = System.getProperty("file.encoding");
		System.out.println(encoding);
	}

}
