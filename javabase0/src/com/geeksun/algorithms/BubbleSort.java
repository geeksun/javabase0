package com.geeksun.algorithms;

/**
 * BubbleSort:冒泡排序法,算法执行的时候,最大的数据项总是"冒泡"到数组的顶端 
 * 规则：1.比较两个数据;  2.如果左边的数据大,就交换位置;
 *      3.向右移动一个位置,比较下面两个数据;  4.当碰到第1个排定位置的数据后,返回到数组的第1个元素开始下一次排序.  
 * author:geeksun
 * 2008-4-10
 */
public class BubbleSort {
	private long[] a;
	private int nElems;

	public BubbleSort(int max) {
		a = new long[max];
		nElems = 0;
	}

	/**
	 * @param searchKey,搜索关健值
	 */
	public boolean find(long searchKey) {
		int j;
		for (j = 0; j < nElems; j++)
			if (a[j] == searchKey)
				break;
		if (j == nElems) // can't find searchKey
			return false;
		else
			return true;
	}

	/**
	 * @param value,向数组插入一个数据
	 */
	public void insert(long value) {
		a[nElems] = value;
		nElems++;
	}

	/**
	 * @param value,删除数组中的指定值
	 * @return boolean 数值
	 */
	public boolean delete(long value) {
		int j;
		for (j = 0; j < nElems; j++)
			if (a[j] == value)
				break;
		if (j == nElems)
			return false;
		else {
			for (int k = j; k < nElems; k++)
				a[k] = a[k + 1];
			nElems--;
			return true;
		}
	}

	/**
	 * 冒泡排序算法:第一次排序都会把最大的数排到最右边位置，第二次把剩余数中最大的数排到N-1位置。
	 */
	public void bubbleSort() {
		int out, in;
		for (out = nElems - 1; out > 0; out--)
			// 从最外层开始比较,必须进行nElems-1次比较才能把所有数据项都排序
			for (in = 0; in < out; in++)
				if (a[in] > a[in + 1]) {
					long temp = a[in];
					a[in] = a[in + 1];
					a[in + 1] = temp;
				}
		// for(out=0;out<nElems-1;out++)
		// for(in=out+1;in<nElems;in++)
		/*
		 * { if(a[out]>a[in]) //swap(in,in+1); // 最好将交换操作的代码写在这里,可以提高一些速度 { long
		 * temp = a[in]; a[in] = a[out]; a[out] = temp; } }
		 */
	}

	public static void maopao3(int[] a) {
		for (int i = a.length - 1; i > 0; i--)
			for (int j = 0; j < i; j++)
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
	}

	/**
	 * @param one
	 * @param two
	 *  交换两元素的值
	 */
	public void swap(int one, int two) {
		long temp = a[one];
		a[one] = a[two];
		a[two] = temp;
	}

	/**
	 * 显示数组内容
	 */
	public void display() {
		for (int j = 0; j < nElems; j++)
			System.out.print(a[j] + "  ");
		System.out.println();
	}

	public static void main(String[] args) {
		int maxSize = 100;
		BubbleSort bs = new BubbleSort(maxSize);

		bs.insert(93);
		bs.insert(29);
		bs.insert(91);
		bs.insert(10);

		bs.display();

		bs.bubbleSort();
		bs.display();
		/*int [] a = {93,29,91,10};
		maopao3(a);*/
	}
}
