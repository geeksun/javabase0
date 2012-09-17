package com.geeksun.string;

public class TestSize {
	//  字符串的长度为length();数组的长度为 length 属性。
	public static void main(String[] args) {
		String s1 = "13911284219_\u79FB\u7528;13911284219_\u79FB\u7528;";
		String s2 = "13911284219_\u79FB\u7528;13911284219_\u79FB\u7528";
		String[] t1 = s1.split(";");
		String[] t2 = s2.split(";");
		System.out.println(t1.length);
		//System.out.println(t2.length());
		//System.out.println(t2.size());   No
		int [] i = {1,2,3,5,9};
		System.out.print(i.length);
		System.out.println();
		
	}
	
}
