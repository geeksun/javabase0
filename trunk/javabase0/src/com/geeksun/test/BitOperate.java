package com.geeksun.test;

/**
 * @author jzq
 * & 与 && 的区别
 * 
 */
public class BitOperate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i = 2 & 3;
		boolean l = false & true;	//&: 位运算符
		System.out.println(i);
		System.out.println(l);
		
		boolean j = false && false;	//&&: 逻辑运算符, 短路运算符, 
		System.out.println(j);
		
	}

}
