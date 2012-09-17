package com.base.common;

/**
 * @author geeksun
 * @version 一个单态类:私有构造函数;私有静态属性;私有静态方法。
 */
public class SingleTon {
	private SingleTon(){}
	private static SingleTon instance = new SingleTon();
	public  static SingleTon getInstance()
	{
		return instance;
	}
	public static void main(String [] args){
		String s = "  ";								//  空字符串也有长度，每个空格都是一个元素
		System.out.println(s.length());
	}
}
