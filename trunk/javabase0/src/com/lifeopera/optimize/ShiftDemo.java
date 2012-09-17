package com.lifeopera.optimize;

/**
 * @author 姜志强
 *  位移运算的Demo：移动比特位
 *  2009-5-1
 */
public class ShiftDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// a<<b :左移运算符， 将比特位左移1位，右端空位全部填0。每左移一位，其数值就增加1倍。
		// a<<1相当于a*2， a<<2相当于a*4
		int a = 5<<2;
		//a>>b :右移运算符，表示右移1位，被移动的数若为正数，最左端填0，若为负数，则最左端填1.每右移1位，其值就减半。
		int b = 8>>3;
		int c = -89>>3;
		//a>>>b :表示右移1位，无论被移的数是正数还是负数，最左端均填0。其结果只能是正整数。
		int d = 29>>>3;
		int e = -38>>>63;
		int f = 893>>>63;
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);
	}

}
