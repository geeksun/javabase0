package com.geeksun.util2;

import java.util.Arrays;

/**
 * @category Arrays类提供了数组整理、比较及检索功能,所有方法都是静态方法
 * @author geeksun
 * 2010-4-20
 */
public class Arrays1 {
	
	/**
	 * Arrays二分查找算法代码: 用二分查找法找出数组int a[]中是否存在key数值(int 型)
	 * @param a
	 * @param key
	 * @return
	 * @see #sort(int[] a)
	 */
	public static int binarySearch(int[] a, int key) {
		Arrays.sort(a);
		int low = 0;
		int high = a.length - 1;

		while (low <= high) {
			int mid = (low + high) >> 1;
			int midVal = a[mid];

			if (midVal < key)
				low = mid + 1;
			else if (midVal > key)
				high = mid - 1;
			else
				return mid; // key found
		}
		return -(low + 1); // key not found.
	}
	
	/**
	 * 用二分查找法找出数组int a[]中是否存在key数值(int 型)
	 * @param a
	 * @param value
	 * @return value 的索引位置，无则返回负数
	 */
	public static int binarySearch3(int[] a, int value){
		Arrays.sort(a);		//	必须先排序，否则无法有效搜索
		int low = 0;	//	低位坐标
		int high = a.length - 1;	// 数组的最大元素的下标位置，高位坐标
		
		while(low<=high){
			int mid = (low + high)>>1;
			int midVal = a[mid];	//	数组中间元素的下标位置
			if(value>midVal){	
				low = mid + 1;	//	低位下标上移一位，包抄，贴近目标Value
			}else if(value<midVal){
				low = mid - 1;
			}else{
				return mid;
			}
		}
		return -(low + 1);	// 没找到value,low找的下标位置
	}
	
	public static void main(String [] args){
		int[] a = new int[]{22,82,19,98,11,12,27};
		Arrays.sort(a);
		
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]+" ");
		}
		// binary search
		binarySearch(a,27);
		System.out.println("27 place:"+Arrays.binarySearch(a,27));
	}
	
}
