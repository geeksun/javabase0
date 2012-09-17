package com.lifeopera.optimize;

/**
 * @author ��־ǿ
 *  ���ַ���ת��Ϊ���ַǳ���ʱ���������ıȽϴ��뽫����ת��Ϊ���ֶ���ļ�������Ϊ --> 281��15
 *  2009-5-9
 */
public class StringToDouble {

	public static void main(String[] args) {
		final int N = 1000000;
		Double d;
		
		//��һ���ַ������� Double ����
		long startTime = System.currentTimeMillis();
		for(int i=1;i<=N;i++){
			d = new Double("2.83");
		}
		long endTime = System.currentTimeMillis();
		System.out.println("���ַ���ת��Ϊ���֣�" + (endTime-startTime));
		
		//�����ֹ��� Double ����
		startTime = System.currentTimeMillis();
		for(int i=1;i<=N;i++){
			d = new Double(2.83);
		}
		endTime = System.currentTimeMillis();
		System.out.println("������ת��Ϊ Double ���͵����֣�" + (endTime-startTime));
	}

}
