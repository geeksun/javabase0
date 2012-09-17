package com.geeksun.util;

/**
 * @author Administrator
 * @category 冒泡排序
 */
public class PaiXu {
	/**
	 * @param int[] a
	 * @return 一个经过 sort 后的数组或是 void 方法
	 */
	public static void sort(int[] a){
		for(int i=0;i<a.length;i++){
			for(int j=i+1;j<a.length;j++){
				if(a[i]<a[j]){
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		/*return a;*/
	}
	public static void main(String[] args){
		int[] a = {12,3,32,5,14,5};
		/*for(int i=0;i<a.length;i++)						// a.length 处原为 a.leng-1
		{
			for(int k=i+1;k<a.length;k++)
			{
				if(a[i]<a[k])
				{
					int m = a[i];				// 把第一个元素赋与变量 m
					a[i]=a[k];
					a[k]=m;
				}
			}
		}
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");*/
		sort(a);
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
	}
}
