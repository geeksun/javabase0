package com.geeksun.test;

/**
 * @author jzq
 * 顾名思义：对String的特性进行测试
 * 2009-4-28
 */
public class TestString {

	/**
	 * @param String a
	 * @param String b
	 * 测试字符串a 是否包含字符串b
	 */
	static final boolean testContain(String a, String b){
		boolean flag = false;
		int len1 = a.length();
		int len2 = b.length();
		int interval = len1 - len2;				//字符串的长度间隔差，如 8-3=5
		//int limit = len1 - interval;			//限制长度, 8-5=3;  mistake
		
		for(int i=0;i<=interval;i++){
			//System.out.print("\nsubstring:"+a.substring(i, i+len2));
			if(a.substring(i, i+len2).equals(b)){
				flag = true;
			}
		}
		
		return flag;
	}
	
	/**
	 * @param String a
	 * @param String b
	 * 测试字符串a 是否包含字符串b, 使用String的indexOf()判断
	 */
	static final boolean testContain2(String a, String b){
		boolean flag = false;
		int value = a.indexOf(b);
		if(value!=-1)flag = true;
		return flag;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.print("\n contain:" + testContain("12345566", "5566"));
		System.out.print("\n contain:" + "12345566".contains("5566"));
		System.out.print("\n contain:" + testContain2("12345566", "5566"));
		
		
	}

}
