package com.geeksun.algorithms;

/**
 * 第3种快速排序(改进版)
 */
class ArrayInt {
	private long[] theArray;
	private int nElems;		// 数组的长度

	public ArrayInt(int max) {
		theArray = new long[max];
		nElems = 0;
	}

	public void insert(long value) {
		theArray[nElems] = value;
		nElems++;
	}

	public void display() {
		System.out.print("Array=");
		for (int j = 0; j < nElems; j++) {
			System.out.print(theArray[j] + " ");
		}
		System.out.println();
	}

	/**
	 * 对数组进行快速排序
	 */
	public void quickSort() {
		recQuickSort(0, nElems - 1);
		// insertionSort(0,nElems-1); //
		// 另一种操作,使用此操作时,应该从recQuickSort()删除对insertionSort()的调用(专家提倡)
	}

	/**
	 * @param left
	 * @param right
	 *  三数据项取中:找到数组里第一个,最后一个和中间位置数据项的居中数据项值,设此数据项为枢纽
	 *  对有序数据排序时执行得更快,无序数据并没有执行得更快
	 */
	public void recQuickSort(int left, int right) {
		int size = right - left + 1;
		// 当数组不大时进行插入排序,10为切割点 cutoff (也可以为20,30),推荐为 9
		if (size < 10)
			insertionSort(left, right);
		else {
			long median = medianOf3(left, right);
			int partition = partitionIt(left, right, median);
			recQuickSort(left, partition - 1);
			recQuickSort(partition + 1, right);
		}
	}

	/**
	 * @param left
	 * @param right
	 * @return 返回中间值
	 */
	public long medianOf3(int left, int right) {
		int center = (left + right) / 2;

		if (theArray[left] > theArray[center]) // order left & center
			swap(left, center);

		if (theArray[left] > theArray[right])
			swap(left, right);

		if (theArray[center] > theArray[right])
			swap(center, right);

		swap(center, right - 1);
		return theArray[right - 1];
	}

	/**
	 * @param left
	 * @param right
	 *  对小划分使用插入排序
	 */
	public void insertionSort(int left, int right) {
		int in, out;

		for (out = left + 1; out <= right; out++) {
			long temp = theArray[out];
			in = out;

			while (in > left && theArray[in - 1] >= temp) {
				theArray[in] = theArray[in - 1];
				--in;
			}
			theArray[in] = temp;
		}
	}

	/**
	 * @param left
	 * @param right
	 * @param pivot
	 * @return pivot的位置:枢轴
	 */
	public int partitionIt(int left, int right, long pivot) {
		int leftPtr = left;
		int rightPtr = right - 1;
		while (true) {
			while (theArray[++leftPtr] < pivot)
				;
			while (theArray[--rightPtr] > pivot)
				;
			if (leftPtr >= rightPtr)
				break;
			else
				swap(leftPtr, rightPtr);
		}
		swap(leftPtr, right - 1);
		return leftPtr;
	}

	/**
	 * @param dex1
	 * @param dex2
	 *  交换数据
	 */
	public void swap(int dex1, int dex2) {
		long temp = theArray[dex1];
		theArray[dex1] = theArray[dex2];
		theArray[dex2] = temp;
	}
}

/**
 * 对小于10个数据项的子数组进行了小划分处理
 * 2010-9-21
 */
public class QuickSort3 {
	public static void main(String[] args) {
		int maxSize = 16;
		ArrayInt arr;
		arr = new ArrayInt(maxSize);

		for (int j = 0; j < maxSize; j++) {
			long n = (int) (java.lang.Math.random() * 99);
			arr.insert(n);
		}
		arr.display();
		arr.quickSort();
		arr.display();
	}
}
