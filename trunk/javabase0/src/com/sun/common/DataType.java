package com.sun.common;

public class DataType {
	/**
	 * @param args
	 *  shift λ����������÷�,Ҫ����λ�Ƶ�����λ������������,�м��м�!
	 */
	public static void main(String[] args) {
		//  << ��λ�������,ÿ����һλ,����ֵ������1��. ������λ����1λ,�Ҷ˿�λȫ����0.
		System.out.println(8<<1);	// 8*4
		System.out.println(8<<2);	// 8*2   �� 8 �� n �η�
		System.out.println(8<<3);	// 8*8
		System.out.println("**************************");
		//  >> ��λ�������,ÿ����һλ,����ֵ�ͼ���1��; ������λ����1λ,���ƶ�������Ϊ����,�������0,��Ϊ����,���������1.
		System.out.println(27>>1);	// 27/2
		System.out.println(27>>2);	// 27/4
		System.out.println(27>>3);	// 27/8
		//  >>> ��λ�������,ÿ����һλ,����ֵ�ͼ���1��; ��ʾ������λ����1λ,���۱��Ƶ������������Ǹ���,����˾���0.
		System.out.println(29>>>1);		// 29/2
		//  ʹ�� >>> ���������������,���õ�������
		System.out.println(-28>>>1);	// �õ������� 2147483634
		System.out.println(2/5);
		
	}
}
