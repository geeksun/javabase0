package com.base.util;

/**
 * ��������
 * @author ��־ǿ
 * 2010-9-18
 */
public class Basic {
	
	/**
	 * ������Ч�ʵķ��������2��8���ڼ���
	 */
	static int shiftCompute() {
		int i = 2<<3;
		return i;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println(shiftCompute());
	}

}
