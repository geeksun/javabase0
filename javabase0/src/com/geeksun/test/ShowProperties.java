package com.geeksun.test;

/**
 * @author 姜志强
 *  显示系统属性
 *  2009-11-23
 */
public class ShowProperties {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.getProperties().list(System.out);
		System.out.println(System.getProperty("user.name"));
		System.out.println(System.getProperty("java.library.path"));
	}

}
