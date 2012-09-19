package com.base.algorithms;

/**
 *  归并排序：数组类
 */
class DArray {
	private long[] theArray;
	private int nElems;

	public DArray(int max) {
		theArray = new long[max];
		nElems = 0;
	}

	public void insert(long value) {
		theArray[nElems] = value;
		nElems++;
	}

	public void display() {
		for (int j = 0; j < nElems; j++) {
			System.out.print(theArray[j] + " ");
		}
		System.out.println("");
	}

	/**
	 *  类用户可看到的方法,执行1:创建数组;2:调用递归的程序recMergeSort()来执行排序
	 */
	public void mergeSort() {
		long[] workSpace = new long[nElems];
		recMergeSort(workSpace, 0, nElems - 1);
	}

	/**
	 * @param workSpace
	 * @param lowerBound
	 * @param upperBound
	 *  归并排序:算法的核心是归并两个已经有序的数组.
	 *  归并两个数组A和B,就生成了第三个数组C,数组C包含数组A和B的所有数据项,并且使它们有序地排列在数组C中. 
	 *  归并排序的思想是把一个数组分成两半,排序每一半,然后把数组的两半归并成一个有序的数组
	 */
	public void recMergeSort(long[] workSpace, int lowerBound, int upperBound) {
		if (lowerBound == upperBound) //  if range is 1
			return; //  no use sorting
		else {
			int mid = (lowerBound + upperBound) / 2; //  find midpoint
			recMergeSort(workSpace, lowerBound, mid); //  sort low half
			recMergeSort(workSpace, mid + 1, upperBound); //  sort high half

			merge(workSpace, lowerBound, mid + 1, upperBound); //  merge them
		}
	}

	/**
	 * @param workSpace
	 * @param lowPtr:前半部分的子数组的开始位置
	 * @param highPtr:后半部分的子数组的开始位置
	 * @param upperBound:后半部分子数组的上界
	 *  归并算法核心是归并两个已经有序的数组:merge A and B into C.
	 *  对A和B的数据项进行比较,较小的数据项被复制到C中, 
	 */
	private void merge(long[] workSpace, int lowPtr, int highPtr, int upperBound) {
		int j = 0;
		int lowerBound = lowPtr;
		int mid = highPtr - 1;
		int n = upperBound - lowerBound + 1;

		while (lowPtr <= mid && highPtr <= upperBound)
			if (theArray[lowPtr] < theArray[highPtr])
				workSpace[j++] = theArray[lowPtr++];
			else
				workSpace[j++] = theArray[highPtr++];

		while (lowPtr <= mid)
			workSpace[j++] = theArray[lowPtr++];

		while (highPtr <= upperBound)
			workSpace[j++] = theArray[highPtr++];

		for (j = 0; j < n; j++)
			theArray[lowerBound + j] = workSpace[j];
	}
}

/**
 *  归并排序:速度上比简单排序快得多
 *  使用递归实现的排序
 */
public class MergeSortApp {
	public static void main(String[] args) {
		int maxSize = 100;
		DArray arr;
		arr = new DArray(maxSize);

		arr.insert(82);
		arr.insert(81);
		arr.insert(18);
		arr.insert(91);
		arr.insert(19);
		arr.insert(28);
		arr.insert(30);
		arr.insert(68);
		arr.insert(97);
		arr.insert(83);
		arr.insert(27);

		arr.display();

		arr.mergeSort();

		arr.display();
	}
}
