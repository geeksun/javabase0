package com.base.optimize;

/**
 * @author 姜志强
 * String convert Char Array: charAt() 计算性能优于 toCharArray()->32:47
 * 2009-5-9
 */
public class StringToCharArray {

	public static void main(String[] args) {
		final int N = 5000000;
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<N;i++){
			sb.append("*");
		}
		
		String s = sb.toString();
		//通过 charAt() 获得字符
		int cnt = 0;
		long startTime = System.currentTimeMillis();
		for(int i=0,len=s.length();i<len;i++){
			if(s.charAt(i)=='x'){
				cnt++;
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println("通过 charAt() 方法获取字符：" + (endTime-startTime));
		
		// 通过 toCharArray 方法获取字符
		startTime = System.currentTimeMillis();
		cnt = 0;
		char ss[] = s.toCharArray();
		/*for(char c:ss){
			if(c=='x'){*/
		for(int i=0;i<ss.length;i++){
			if(ss[i]=='x'){
				cnt++;
			}
		}
		endTime = System.currentTimeMillis();
		System.out.println("通过 toCharArray() 方法获取字符：" + (endTime-startTime));
	}

}
