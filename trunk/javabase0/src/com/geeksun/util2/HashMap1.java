package com.geeksun.util2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/**
 * @author Administrator
 * @category : 实现 Map 接口的类有三个,HashMap,TreeMap,Hashtable
 * 集合内的元素有固定的 Key 值;Key 值不允许重复
 */
public class HashMap1 {
	public static void main(String[] args) {
		Map hm = new HashMap();
		hm.put("1","sun");
		hm.put("2","moon");
		hm.put("3","star");
		
		System.out.println("Element size:"+hm.size());
		System.out.println("catalog");
		
		Set set = hm.keySet();
		
	}
}
