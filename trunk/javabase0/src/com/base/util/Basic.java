package com.base.util;

/**
 * 基础运算
 * @author 姜志强
 * 2010-9-18
 */
public class Basic {
	
	/**
	 * 用最有效率的方法计算出2×8等于几？
	 */
	static int shiftCompute() {
		int i = 2<<3;
		return i;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println(shiftCompute());
	}

}
