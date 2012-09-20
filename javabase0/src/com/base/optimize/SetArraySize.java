package com.base.optimize;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 姜志强 
 *  如果有一个很大的数组，并且你预料这个数组将会变得异常庞大，这里给出一个办法可以提高添加新元素的速度，优化系统性能。
 *  使用 ArrayList 对象的 ensureCapacity() 可以预先设置数组的大小，提前告诉系统这个数组的容量，做好初始化工作.
 *  添加元素效率： 数组>ArrayList>LinkedList
 *  2009-5-7
 */
public class SetArraySize {
	
	/**
	 * @param list
	 * @return 线程安全(thread-safe)的 ArrayList 对象，性能不如 Vector
	 */
	List<?> synArrayList(ArrayList<?> list){
		//将 ArrayList 类标识为线程安全(thread-safe)的对象
		List<?> rlist = Collections.synchronizedList(list);
		return rlist;  
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final int N = 1000000;
		Object obj = new Object();
		
		//没有调用ensureCapacity() 方法初始化 ArrayList 对象
		List<Object> list = new ArrayList<Object>();
		long startTime = System.currentTimeMillis();
		for(int i=1;i<N;i++){
			list.add(obj);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("ArrayList添加对象没调用 ensureCapacity 方法用时:" + (endTime-startTime)+"ms");
		
		list = new ArrayList<Object>();
		startTime = System.currentTimeMillis();
		//调用 ensureCapacity() 方法初始化 ArrayList 对象
		((ArrayList<Object>) list).ensureCapacity(N);
		 for(int i=1;i<N;i++){
			 list.add(obj);
		 }
		endTime = System.currentTimeMillis();
		System.out.println("ArrayList添加对象调用ensureCapacity 方法用时:" + (endTime-startTime)+"ms");
		
		// 数组添加对象
		Object[] objs = new Object[N];
		startTime = System.currentTimeMillis();
		for(int i=1;i<N;i++){
			objs[i] = obj;
		}
		endTime = System.currentTimeMillis();
		System.out.println("数组添加对象用时:" + (endTime-startTime)+"ms");
		
		list = new LinkedList<Object>();
		startTime = System.currentTimeMillis();
		//调用 ensureCapacity() 方法初始化 ArrayList 对象
		 for(int i=1;i<N;i++){
			 list.add(obj);
		 }
		endTime = System.currentTimeMillis();
		System.out.println("LinkedList添加对象用时:" + (endTime-startTime)+"ms");
		
		/* 输出：
		 * ArrayList添加对象没调用 ensureCapacity 方法用时:63ms
		   ArrayList添加对象调用ensureCapacity 方法用时:31ms
		    数组添加对象用时:15ms
		   LinkedList添加对象用时:250ms
		 */
	}

}
