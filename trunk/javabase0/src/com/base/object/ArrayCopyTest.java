package com.base.object;

/**
 * @author 姜志强
 *  数组拷贝操作
 *  2009-5-5
 */
public class ArrayCopyTest {

	public static void main(String[] args) {
		long startIndex, endIndex;
		int[] a = new int[2500000];
		int[] b = new int[2500000];
		for(int i=0;i<a.length;i++){
			a[i] = i;
		}
		startIndex = System.currentTimeMillis();
		for(int j=0;j<a.length;j++){
			b[j] = a[j];
		}
		endIndex = System.currentTimeMillis();
		System.out.println(endIndex-startIndex+" milli seconds for loop copy");
		int [] c = new int[2500000];
		startIndex = System.currentTimeMillis();
		System.arraycopy(a, 0, c, 0, c.length);
		endIndex = System.currentTimeMillis();
		System.out.println(endIndex-startIndex+" milli seconds for System.arraycopy()");
	}

}
