package com.base.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

/**
 * @author jzq
 *  HashMap performance: 遍历效率PK
 *  2010.1.20
 */
public class HashMapTest {
	
	/**
	 *  这个循环效率不如第2个
	 */
	void run1(){
		Map<String, String[]> paraMap = new HashMap<String, String[]>();
		//第一个循环
		Set<String> appFieldDefIds = paraMap.keySet();
		for (String appFieldDefId : appFieldDefIds) {
			String[] values = paraMap.get(appFieldDefId);
			
		}
	}
	
	/**
	 *  
	 */
	void run2(){
		Map<String, String[]> paraMap = new HashMap<String, String[]>();
		//第二个循环
		for(Entry<String, String[]> entry : paraMap.entrySet()){
			String appFieldDefId = entry.getKey();
			String[] values = entry.getValue();
			//.......
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
	}

}
