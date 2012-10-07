package com.base.algorithms;

/**
 * Description 快速排序
 * @author Administrator
 * 2012-9-15
 */
public class QuickSort4 {
	
	/**
	 * @param data 要排序的数组
	 * @param left 左边数组下标
	 * @param right 右边数组下标
	 */
	static void quickSort(int[] data, int left, int right){
		if(left<right){
			// 一趟排序算法， 返回枢钮位置
			int pivot = partition(data, left, right);
			// 左边排序
			quickSort(data, left, pivot-1);
			// 右边排序
			quickSort(data, pivot+1, right);
		}
	}
	
	/**
	 * 一趟快速排序算法
	 * 将记录数组data分成两部分，left为起始下标，right为结束下标 
	 * @param data
	 * @param left
	 * @param rightt
	 * @return 枢钮位置
	 */
	static int partition(int[] data, int left, int right){
		int key = data[left];
		int temp;
		
		while(left < right){
			// 从右边开始，第一个小于Key的元素与Key交换位置
			while(left<right && data[right]>=key)
				right--;
			
			//交换元素位置
			temp = data[right];
			data[right] = data[left];
			data[left] = temp;
			
			// 从左边开始，第一个大于Key的元素与Key交换位置
			while(left<right && data[left]<=key)
				left++;
			
			//交换元素位置
			temp = data[right];
			data[right] = data[left];
			data[left] = temp;
		}
		
		return left;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int data[] = {44,22,2,32,54,22,88,77,99,11,3,98,101,23,834,11,23,53,18};
		quickSort(data, 0, data.length-1);
		for(int i=0;i<data.length;i++){
			System.out.print(" "+data[i]);
		}
	}

}
