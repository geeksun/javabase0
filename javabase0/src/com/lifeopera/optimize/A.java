package com.lifeopera.optimize;

import java.util.Hashtable;
import java.util.Map;

/**
 * @author ��־ǿ
 *  validate:��Ҫ��һ�������ʼ�����
 *  2009-4-29
 */
public class A {
	/*  ��Ϊ���������̬�����ɷ�ֹ�ظ���ֵ  */
	private static Map table = new Hashtable();
	
	/**
	 *  �ظ���ʼ����Ӧ����
	 */
	public A(){
		table = new Hashtable(); 
	}
	
	public void run(){
		System.err.print("\nA is runing");
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		for(int i=0;i<100000;i++){
			A a = new A();
		}
		long end = System.currentTimeMillis();
		System.out.print("\ntime:" + (end-start));
	}

}
