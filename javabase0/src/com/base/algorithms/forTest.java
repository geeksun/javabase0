package com.base.algorithms;

/**
 * @author Administrator
 * @comment: ���̿����� for ѭ���е�ֵ�� for ѭ�����ֵ��һ��
 */
public class forTest {
	public static void main(String[] a)
	{
		int x = 10;
		int j;
		for(j=0;j<x;j++)
		{
			System.out.print(" j: " + j);
		}
		System.out.println("");
		//  j �����ֵΪ�� 10 ,��Ϊ�� j ��ֵΪ10 ʱ����ʽΪ��,�˳�ѭ��,����ʱ j ��ֵ�Ѿ���ֵΪ 10 
		System.out.println(" j last value " + j);
		int t = 5;
		System.out.println(t--);
		System.out.println(--t);
	}
}
