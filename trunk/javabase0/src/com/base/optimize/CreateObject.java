package com.base.optimize;

import java.util.Hashtable;
import java.util.Map;

/**
 * @author 姜志强
 *  创建对象的应用规则：
 *  创建对象时避免在循环体中声明创建对象，即使该对象占用内存空间不大。
 *	尽量及时使对象符合垃圾回收标准。
 *	不要采用过深的继承层次。
 *	访问本地变量优于访问类中的变量。
 *	不要对一个对象初始化多次。见：A, B类
 *	不要提前创建对象，重复的分配、构造对象可能会因垃圾回收做额外的工作，降低系统性能。
 *	2009-4-28
 */
public class CreateObject {
	private Map table = new Hashtable();
	
	/**
	 *  不要对一个对象初始化多次，这样会带来较大的内存开销，降低系统性能。
	 */
	public CreateObject(){
		/*correct code: 不对 table 进行处理
		 * */
		//将table 对象初始化了两次
		table = new Hashtable();
	}
	
	/**
	 *  创建对象时避免在循环体中声明创建对象，即使该对象占用内存空间不大。
	 *  这样会浪费较大的内存空间（在创建较多对象时）,因为会创建很多个对象的引用，增加JVM做垃圾回收的负荷。
	 */
	static void refuseOne(){
		/*  correct code: Object obj = null;   这样在内存中只保存一份对该对象的引用
		for(int i=0;i<10000;i++){
			obj = new Object();
			System.out.print("\nobj:" + obj);
		}*/
		long start = System.currentTimeMillis();
		for(int i=0;i<10000;i++){
			Object obj = new Object();
			System.out.print("\nobj:" + obj);
		}
		long end = System.currentTimeMillis();
		System.err.print("Consume Time:" + (end-start));
		
	}
	
	static void refuseTwo(){
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		refuseOne();
		
		
	}

}
