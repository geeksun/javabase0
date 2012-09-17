package com.lifeopera.optimize;

import java.util.Hashtable;
import java.util.Map;

/**
 * @author 姜志强
 *  validate:不要对一个对象初始化多次
 *  2009-4-29
 */
public class B {
	private Map table = new Hashtable();
	
	/**
	 *  没有重复初始化
	 */
	public B(){
		//table = new Hashtable(); 
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		for(int i=0;i<100000;i++){
			B b = new B();
		}
		long end = System.currentTimeMillis();
		System.out.print("\ntime:" + (end-start));
	}

}
