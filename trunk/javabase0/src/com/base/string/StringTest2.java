package com.base.string;

/**
 * @author Administrator
 * ֵ���ݺ����ô��ݲ���
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
		// a��bָ��ͬһ������, ��Ϊ"abc"�����ջ��
		System.out.println(a==b);
	}
	
	public static void change(String s,char c)
	{
		s = "test";
		c = 'c';
	}
	
}
