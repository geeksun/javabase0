package com.geeksun.algorithms;

/**
 * 选择排序：把所有的元素扫描一遍,从中选择出最小的数据放在数组的第一个元素,次最小的放在第二位
 * author:geeksun
 * 2008-4-10
 */
public class SelectSort {
	private long[] a;
	private int nElems;

	public SelectSort(int max) {
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

	public void display() {
		for (int j = 0; j < nElems; j++) {
			System.out.print(a[j] + " ");
		}
		System.out.println();
	}

	/**
	 * 选择排序算法:找出数组里的最小值,放在数组的左面,按从小到大的顺序排列
	 */
	public void selectSort() {
		int out, in, min;
		for (out = 0; out < nElems - 1; out++) {
			min = out; // 从数组的第一个元素开始找最小项
			for (in = out + 1; in < nElems; in++)
				if (a[in] < a[min])
					min = in;
			
			// swap(out,min);
			long temp = a[out];
			a[out] = a[min];
			a[min] = temp;
		}
	}

	public void swap(int out, int in) {
		long temp = a[out];
		a[out] = a[in];
		a[in] = temp;
	}

	public static void main(String[] args) {
		SelectSort ss = new SelectSort(100);

		ss.insert(29);
		ss.insert(92);
		ss.insert(38);
		ss.insert(893);

		ss.display();
		ss.selectSort();
		ss.display();
	}
}
