package com.base.optimize;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 姜志强
 *  ArrayList 与 LinkedList 的性能对比（插入与搜索）: ArrayList查找快，插入和删除慢; LinkedList查找慢，插入和删除快。
 *  因为ArrayList是基于数组，LinkedList是基于链表
 *  2009-5-8
 */
public class ArrayListPKLinkedList {
	final static int M = 25000;
	final static int N = 25000;
	static long startTime;
	static long endTime;
	
	/**
	 *  插入元素测试
	 */
	public static void insertElementToList(){
		//使用 ArrayList 对象插入新元素
		List al = new ArrayList();
		startTime = System.currentTimeMillis();
		for(int i=1;i<M;i++){
			al.add(0, new Integer(i));
		}
		endTime = System.currentTimeMillis();
		System.out.println("Use ArrayList Insert:" + (endTime-startTime)+"ms");
		//使用 LinkedList 对象插入新元素
		List ll = new LinkedList();
		startTime = System.currentTimeMillis();
		for(int i=1;i<M;i++){
			ll.add(0, new Integer(i));
		}
		endTime = System.currentTimeMillis();
		System.out.println("Use LinkedList Insert:" + (endTime-startTime)+"ms");
		
	}
	
	/**
	 *  搜索元素测试
	 */
	static void lookUpElement(){
		Object o;
		//在 ArrayList 中随机查找元素
		List al = new ArrayList();
		for(int i=0;i<N;i++){
			al.add(new Integer(i));
		}
		startTime = System.currentTimeMillis();
		for(int i=0;i<N;i++){
			o = al.get(i);
		}
		endTime = System.currentTimeMillis();
		System.out.println("Use ArrayList lookUp:" + (endTime-startTime)+"ms");
		//在 LinkedList 对象中随机查找元素
		List ll = new LinkedList();
		for(int i=0;i<N;i++){
			ll.add(new Integer(i));
		}
		startTime = System.currentTimeMillis();
		for(int i=0;i<N;i++){
			o = ll.get(i);
		}
		endTime = System.currentTimeMillis();
		System.out.println("Use LinkedList lookUp:" + (endTime-startTime)+"ms");
	}
	
	public static void main(String[] args) {
		insertElementToList();
		lookUpElement();

	}

}
