package com.geeksun.util2;

import java.util.Enumeration;
import java.util.Hashtable;

/**
 * @author Administrator
 * @category : 实现 Map 接口的类有三个,HashMap,TreeMap,Hashtable
 * 集合内的元素有固定的 Key 值;Key 值不允许重复
 */
public class HashTable1 {
	public static void main(String[] args) {
		Hashtable ht = new Hashtable();
		ht.put("22","adsf");
		ht.put("23","iei");
		
		System.out.println("Element size:"+ht.size());
		System.out.println("<catalog>");
		for(Enumeration e = ht.elements();e.hasMoreElements();){
			System.out.println(e.nextElement());
		}
	}
}
