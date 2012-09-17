package com.geeksun.util2;

import java.util.Vector;

/**
 * @author Administrator
 * @category : 实现 List 接口的类有三个,ArrayList,Vector,LinkedList
 * 集合内的元素允许重复;集合内的数据有特定的顺序  
 * Vector 的方法是同步方法，是安全的
 */
public class Vector1 {
	public static void main(String[] args){
		Vector vec = new Vector();
		vec.addElement("Hi");
		vec.addElement(new Integer(8));
		vec.addElement(new StringBuffer("abc"));
		
		for(int i=0;i<vec.size();i++){
			System.out.println(vec.elementAt(i));
		}
		System.out.println(vec.size());
		System.out.println(vec.capacity());					// 容量
	}
}
