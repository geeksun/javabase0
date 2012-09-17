package com.geeksun.test;

/**
 * @author jzq
 *  二进制数计算
 *  2009-5-8
 */
public class BinaryTest {
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//十进制数-3的二进制表示
		System.out.println(Integer.toBinaryString(-3));
		//十进制数-3的十六进制表示
		System.out.println(Integer.toHexString(-3));
		//大整数：BigInteger
		
		//异或： 开关
		System.out.println(8^8);
		System.out.println(8 ^(8 ^8));
		
		System.out.println(Integer.reverse(3));
		
		
	}

}
