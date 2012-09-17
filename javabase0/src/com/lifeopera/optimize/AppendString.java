package com.lifeopera.optimize;

/**
 * @author 姜志强
 *  字符串联性能比较: 使用 StringBuffer 与 操作符串联效率比较
 *  2009-5-8
 */
public class AppendString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final int N = 5000;
		//用操作符串联两个字符串
		long startTime = System.currentTimeMillis();
		String s1 = "";
		for(int i=0;i<=N;i++){
			s1 = s1 + "*";
		}
		long endTime = System.currentTimeMillis();
		System.out.println("用操作符串联两个字符串:" + (endTime-startTime)+"ms");
		//通过 StringBuffer 串联两个字符串
		startTime = System.currentTimeMillis();
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<=N;i++){
			sb.append("*");
		}
		String s2 = sb.toString();
		endTime = System.currentTimeMillis();
		System.out.println("通过StringBuffer串联两个字符串" + (endTime-startTime)+"ms");
	}

}
