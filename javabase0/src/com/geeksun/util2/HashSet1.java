package com.geeksun.util2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Administrator
 * @category : 实现 Set 接口的类有两个,HashSet,TreeSet
 * 集合内的元素不允许重复;集合内的数据没有顺序  
 */
public class HashSet1 {
	public static void main(String[] args){
		Set<String> hs = new HashSet<String>();
		System.out.println("添加三个元素"); 
		hs.add("你好");
		hs.add("Hello");
		hs.add("glad");
		hs.add("你好");								//   Set中不允许有重复的元素存在,此次添加无效
		System.out.println("元素个数:"+hs.size());
		
		Iterator it = hs.iterator();
		while(it.hasNext()){							// 遍历 Set 中的元素
			String s = (String) it.next();
			System.out.println(s);
		}

		System.out.println("删除一个元素");
		System.out.println("Set中是否包含'你好':"+hs.contains("你好"));
		hs.remove("你好");
		System.out.println("元素个数："+hs.size());
	}
}
