package com.lifeopera.optimize;

/**
 * @author 姜志强
 * String的 length()方法与性能优化: 避免在循环中调用方法，计算时间比：62:47
 * 2009-5-8
 */
public class StringLength {

	public static void main(String[] args) {
		final int N = 10000000;
		StringBuffer sb = new StringBuffer();
		for(int i=1;i<=N;i++){
			sb.append("*");
		}
		
		String s = sb.toString();
		//通过调用 length() 方法
		int cnt = 0;
		long startTime = System.currentTimeMillis();
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='x'){
				cnt++;
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println("通过调用 length（）方法：" + (endTime-startTime) + "ms");
		
		//通过提前计算字符串的长度
		cnt = 0;
		startTime = System.currentTimeMillis();
		int len = s.length();
		for(int i=0;i<len;i++){
			if(s.charAt(i)=='x'){
				cnt++;
			}
		}
		endTime = System.currentTimeMillis();
		System.out.print("通过提前计算字符串的长度:" + (endTime-startTime)+"ms");
		
	}

}
