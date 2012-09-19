package com.base.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

/**
 * @author jzq
 *  HashMap performance: ����Ч��PK
 *  2010.1.20
 */
public class HashMapTest {
	
	/**
	 *  ���ѭ��Ч�ʲ����2��
	 */
	void run1(){
		Map<String, String[]> paraMap = new HashMap<String, String[]>();
		//��һ��ѭ��
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
		//�ڶ���ѭ��
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
