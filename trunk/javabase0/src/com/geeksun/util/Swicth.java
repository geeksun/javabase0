package com.geeksun.util;

/**
 * @author geeksun
 * @version case:n  中 n 的值可以为整数(int,byte,short,char),但不能是实数或字符串(long,String),可以是字符,因为字符实质上是整数
 */
public class Swicth {
	public static void main(String[] args){
		int i = 1;
		switch(i){
			case 1:System.out.println("11");
			case 2:System.out.println("32");
					break;
			default:System.out.println("未知");
		}
		
	}
}
