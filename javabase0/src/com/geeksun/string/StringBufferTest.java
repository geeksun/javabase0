package com.geeksun.string;

/**
 * @author Administrator
 * @category StringBuffer可以对字符串进行操作
 */

public class StringBufferTest {
	public static void main(String[] args){
		StringBuffer ss = new StringBuffer();
		ss.append("AC");
		ss.append(false);
		ss.append(23323);
		System.out.println(ss.reverse());
	}
}
