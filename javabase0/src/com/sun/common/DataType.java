package com.sun.common;

public class DataType {
	/**
	 * @param args
	 *  shift 位移运算符的用法,要进行位移的数字位于运算符的左边,切记切记!
	 */
	public static void main(String[] args) {
		//  << 左位移运算符,每左移一位,其数值就增加1倍. 将比特位左移1位,右端空位全部填0.
		System.out.println(8<<1);	// 8*4
		System.out.println(8<<2);	// 8*2   即 8 的 n 次方
		System.out.println(8<<3);	// 8*8
		System.out.println("**************************");
		//  >> 右位移运算符,每右移一位,其数值就减少1倍; 将比特位右移1位,被移动的数若为正数,最左端填0,若为负数,则最左端填1.
		System.out.println(27>>1);	// 27/2
		System.out.println(27>>2);	// 27/4
		System.out.println(27>>3);	// 27/8
		//  >>> 右位移运算符,每右移一位,其数值就减少1倍; 表示将比特位右移1位,无论被移的数是正数还是负数,最左端均填0.
		System.out.println(29>>>1);		// 29/2
		//  使用 >>> 运算符操作负数后,将得到正整数
		System.out.println(-28>>>1);	// 得到正整数 2147483634
		System.out.println(2/5);
		
	}
}
