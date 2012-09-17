package com.lifeopera.optimize;

/**
 * @author ��־ǿ
 *  �ַ��������ܱȽ�: ʹ�� StringBuffer �� ����������Ч�ʱȽ�
 *  2009-5-8
 */
public class AppendString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final int N = 5000;
		//�ò��������������ַ���
		long startTime = System.currentTimeMillis();
		String s1 = "";
		for(int i=0;i<=N;i++){
			s1 = s1 + "*";
		}
		long endTime = System.currentTimeMillis();
		System.out.println("�ò��������������ַ���:" + (endTime-startTime)+"ms");
		//ͨ�� StringBuffer ���������ַ���
		startTime = System.currentTimeMillis();
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<=N;i++){
			sb.append("*");
		}
		String s2 = sb.toString();
		endTime = System.currentTimeMillis();
		System.out.println("ͨ��StringBuffer���������ַ���" + (endTime-startTime)+"ms");
	}

}
