package com.geeksun.test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author jzq
 * JDK5增强for循环的应用
 * 2009-5-8
 */
public class TestFor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
		for (int i : arr) {
			System.out.println(i);
		}

		Collection c = new ArrayList();
		c.add(new String("111"));
		c.add(new String("222"));
		c.add(new String("333"));
		c.add(new String("444"));
		c.add(new String("555"));
		c.add(new String("666"));
		c.add(new String("777"));
		c.add(new String("888"));
		c.add(new String("999"));
		c.add(new String("000"));
		for (Object o : c) {
			System.out.println(o);
		}
		
	}

}
