package com.lifeopera.optimize;

/**
 * @author ��־ǿ
 *  λ�������Demo���ƶ�����λ
 *  2009-5-1
 */
public class ShiftDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// a<<b :����������� ������λ����1λ���Ҷ˿�λȫ����0��ÿ����һλ������ֵ������1����
		// a<<1�൱��a*2�� a<<2�൱��a*4
		int a = 5<<2;
		//a>>b :�������������ʾ����1λ�����ƶ�������Ϊ�������������0����Ϊ���������������1.ÿ����1λ����ֵ�ͼ��롣
		int b = 8>>3;
		int c = -89>>3;
		//a>>>b :��ʾ����1λ�����۱��Ƶ������������Ǹ���������˾���0������ֻ������������
		int d = 29>>>3;
		int e = -38>>>63;
		int f = 893>>>63;
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);
	}

}
