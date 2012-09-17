package com.base.reflection;

import java.lang.reflect.Array;

/**
 *   Array ���ṩ�˶�̬��������������ĸ��־�̬����
 */
public class ArrayTest {
	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		Class cla = Class.forName("java.lang.String");
		// ����һ������Ϊ 10 ���ַ�������
		Object array = Array.newInstance(cla, 10);
		// ������λ��Ϊ 5 ��Ԫ����Ϊ"hello"
		Array.set(array, 5, "hello");
		
		// ��ȡ����λ��Ϊ 5 ��Ԫ�ص�ֵ
		String s = (String) Array.get(array, 5);
		System.out.println(s);
	}

}
