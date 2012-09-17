package com.lifeopera.optimize;

/**
 * @author ��־ǿ
 * String�� length()�����������Ż�: ������ѭ���е��÷���������ʱ��ȣ�62:47
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
		//ͨ������ length() ����
		int cnt = 0;
		long startTime = System.currentTimeMillis();
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='x'){
				cnt++;
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println("ͨ������ length����������" + (endTime-startTime) + "ms");
		
		//ͨ����ǰ�����ַ����ĳ���
		cnt = 0;
		startTime = System.currentTimeMillis();
		int len = s.length();
		for(int i=0;i<len;i++){
			if(s.charAt(i)=='x'){
				cnt++;
			}
		}
		endTime = System.currentTimeMillis();
		System.out.print("ͨ����ǰ�����ַ����ĳ���:" + (endTime-startTime)+"ms");
		
	}

}
