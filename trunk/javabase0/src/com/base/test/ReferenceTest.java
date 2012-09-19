package com.base.test;

/**
 * @author jzq
 *  ÒıÓÃ²âÊÔ£º
 *  2009-5-5
 *  
 */
public class ReferenceTest {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String a = "abc";
		String b = "abc";
		a = "aaa";
		System.out.println(b);
		
		int i = 3;
		int j = 3;
		i = 4;
		System.out.println(j);
		
	}

}
