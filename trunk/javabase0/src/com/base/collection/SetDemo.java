package com.base.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Description Set集合类的各种Demo
 * @author Administrator
 * 2012-9-21
 */
public class SetDemo {

	/**
	 * @param args 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set set = new HashSet();
		set.add(2);
		set.add(3);
		set.add(4);
		boolean flag = set.add(2);
		if(flag == false){
			System.out.println("Set add element fail------>" + flag);
		}
		
		for(Iterator it = set.iterator();it.hasNext();){
			System.out.println(it.next());
		}
	}

}
