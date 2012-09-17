package com.base.optimize;

/**
 * @author ��־ǿ
 * String convert Char Array: charAt() ������������ toCharArray()->32:47
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
		//ͨ�� charAt() ����ַ�
		int cnt = 0;
		long startTime = System.currentTimeMillis();
		for(int i=0,len=s.length();i<len;i++){
			if(s.charAt(i)=='x'){
				cnt++;
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println("ͨ�� charAt() ������ȡ�ַ���" + (endTime-startTime));
		
		// ͨ�� toCharArray ������ȡ�ַ�
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
		System.out.println("ͨ�� toCharArray() ������ȡ�ַ���" + (endTime-startTime));
	}

}
