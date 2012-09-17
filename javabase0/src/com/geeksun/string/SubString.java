package com.geeksun.string;

public class SubString {
	public static void main(String[] args){
		String s = "acckdkd";
		String t = "  kdkd  ";
		String ss = s.substring(3);			// return index 3以后的子字符串
		String sa = s.substring(0,3);     	// return index 0-(3-2)处的子字符串
		int a = s.indexOf("k");
		char aa = s.charAt(3);
		String sc = s.concat("dd");
		System.out.println(ss+" "+sa+" "+a+"****"+t.trim()+t+aa);
		System.out.println(sc+" "+sc.endsWith("d")+" "+sc.length());
		System.out.println(sc.replace('a','*')); 
	}
}
