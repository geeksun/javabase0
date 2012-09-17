package com.geeksun.math;

import java.util.HashMap;

public class HashMapTest {

	/**
	 * @param args
	 * AM
	   AK
	   {H=HK}
	   H
	 */
	public static void main(String[] args) {
		HashMap a = new HashMap();
		HashMap b = new HashMap();
		HashMap c = new HashMap();
		HashMap d = new HashMap();
		
		d.put("H", "AK");
		a.put("A", "AM");
		a.put("H", d);
		
		b = (HashMap) a.clone();
		c = a;
		a.put("A", "AK");
		((HashMap)a.get("H")).put("H", "HK");
		a.put("H", "H");
		a = null;
		
		System.out.println(b.get("A"));
		System.out.println(c.get("A"));
		System.out.println(b.get("H"));
		System.out.println(c.get("H"));
	}

}
