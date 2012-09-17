package com.geeksun.string;

/**
 * @author Administrator
 * 值传递和引用传递测试
 */
public class StringTest2 {
	String s = "sss";
	public static void main(String[] args){
		//StringTest2 st = new StringTest2();
		String s = new String("abcdefg");
		char ch = 'a';
		change(s,ch);
		System.out.println("s:"+s+" ch:"+ch);
		System.out.println(s.substring(0,4).concat(s.substring(4).toUpperCase()));
	}
	public static void change(String s,char c)
	{
		s = "test";
		c = 'c';
	}
}
