package com.geeksun.util2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/**
 * @author Administrator
 * @category : ʵ�� Map �ӿڵ���������,HashMap,TreeMap,Hashtable
 * �����ڵ�Ԫ���й̶��� Key ֵ;Key ֵ�������ظ�
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
