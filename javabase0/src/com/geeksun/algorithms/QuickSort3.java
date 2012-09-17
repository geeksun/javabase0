package com.geeksun.algorithms;

/**
 * ��3�ֿ�������(�Ľ���)
 */
class ArrayInt {
	private long[] theArray;
	private int nElems;		// ����ĳ���

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
	 * ��������п�������
	 */
	public void quickSort() {
		recQuickSort(0, nElems - 1);
		// insertionSort(0,nElems-1); //
		// ��һ�ֲ���,ʹ�ô˲���ʱ,Ӧ�ô�recQuickSort()ɾ����insertionSort()�ĵ���(ר���ᳫ)
	}

	/**
	 * @param left
	 * @param right
	 *  ��������ȡ��:�ҵ��������һ��,���һ�����м�λ��������ľ���������ֵ,���������Ϊ��Ŧ
	 *  ��������������ʱִ�еø���,�������ݲ�û��ִ�еø���
	 */
	public void recQuickSort(int left, int right) {
		int size = right - left + 1;
		// �����鲻��ʱ���в�������,10Ϊ�и�� cutoff (Ҳ����Ϊ20,30),�Ƽ�Ϊ 9
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
	 * @return �����м�ֵ
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
	 *  ��С����ʹ�ò�������
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
	 * @return pivot��λ��:����
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
	 *  ��������
	 */
	public void swap(int dex1, int dex2) {
		long temp = theArray[dex1];
		theArray[dex1] = theArray[dex2];
		theArray[dex2] = temp;
	}
}

/**
 * ��С��10��������������������С���ִ���
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
