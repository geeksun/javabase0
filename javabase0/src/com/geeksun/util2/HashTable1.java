package com.geeksun.util2;

import java.util.Enumeration;
import java.util.Hashtable;

/**
 * @author Administrator
 * @category : ʵ�� Map �ӿڵ���������,HashMap,TreeMap,Hashtable
 * �����ڵ�Ԫ���й̶��� Key ֵ;Key ֵ�������ظ�
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
