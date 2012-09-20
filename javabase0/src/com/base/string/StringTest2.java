package com.base.string;

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
		
		String a = "abc";
		String b = "abc";
		// a和b指向同一个对象, 因为"abc"存放在栈里
		System.out.println(a==b);
	}
	
	public static void change(String s,char c)
	{
		s = "test";
		c = 'c';
	}
	
}
