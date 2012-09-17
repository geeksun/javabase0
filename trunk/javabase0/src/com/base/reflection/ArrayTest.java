package com.base.reflection;

import java.lang.reflect.Array;

/**
 *   Array 类提供了动态创建塔访问数组的各种静态方法
 */
public class ArrayTest {
	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		Class cla = Class.forName("java.lang.String");
		// 创建一个长度为 10 的字符串数组
		Object array = Array.newInstance(cla, 10);
		// 把索引位置为 5 的元素设为"hello"
		Array.set(array, 5, "hello");
		
		// 读取索引位置为 5 的元素的值
		String s = (String) Array.get(array, 5);
		System.out.println(s);
	}

}
