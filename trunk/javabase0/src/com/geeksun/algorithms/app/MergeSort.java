package com.geeksun.algorithms.app;

import java.util.Arrays;

/**
 * �鲢��������A������B�����ź���������Ч�ʵİ취����ϲ���Ϊ����C��Ҫ���ǵ��ظ������ֽ���ȥ��
 * @author ��־ǿ
 * 2010-9-14
 */
public class MergeSort {
	
	/**
	 * �鲢����
	 */
	public static void mergeSort(){
		int[] a = {1,3,5,9};
		int[] b = {2,3,5,7};
		int[] c = new int[a.length+b.length];
		
		// ������������
		for(int i=0;i<a.length;i++){
			c[i] = a[i];
		}
		for(int k=0;k<b.length;k++){
			c[k+a.length] = b[k];
		}
		int len = c.length;
		
		// ����ð�������˼·
		for(int i=len-1;i>0;i--){
			int temp = c[i];
			for(int k=0;k<i;k++){
				if(temp==c[k]){
					for(int j=k;j<len-1;j++){
						c[j] = c[j+1];
					}
					len--;
					break;
				}
			}
		}
		
		int[] result = new int[len];
		for(int i=0;i<len;i++){
			result[i] = c[i];
		}
		
		System.err.println(Arrays.toString(result));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		mergeSort();
		long end = System.currentTimeMillis();
		System.out.println(end-start);
	}

}
