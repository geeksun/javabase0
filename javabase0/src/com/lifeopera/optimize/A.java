package com.lifeopera.optimize;

import java.util.Hashtable;
import java.util.Map;

/**
 * @author 姜志强
 *  validate:不要对一个对象初始化多次
 *  2009-4-29
 */
public class A {
	/*  此为类变量，静态变量可防止重复赋值  */
	private static Map table = new Hashtable();
	
	/**
	 *  重复初始化，应避免
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
