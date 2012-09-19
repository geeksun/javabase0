package com.base.algorithms;

/**
 * @author Administrator
 * @comment: 流程控制中 for 循环中的值和 for 循环外的值不一样
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
		//  j 的最后值为？ 10 ,因为当 j 的值为10 时条件式为假,退出循环,但此时 j 的值已经赋值为 10 
		System.out.println(" j last value " + j);
		int t = 5;
		System.out.println(t--);
		System.out.println(--t);
	}
}
