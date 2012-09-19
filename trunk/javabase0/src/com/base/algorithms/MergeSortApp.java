package com.base.algorithms;

/**
 *  �鲢����������
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
	 *  ���û��ɿ����ķ���,ִ��1:��������;2:���õݹ�ĳ���recMergeSort()��ִ������
	 */
	public void mergeSort() {
		long[] workSpace = new long[nElems];
		recMergeSort(workSpace, 0, nElems - 1);
	}

	/**
	 * @param workSpace
	 * @param lowerBound
	 * @param upperBound
	 *  �鲢����:�㷨�ĺ����ǹ鲢�����Ѿ����������.
	 *  �鲢��������A��B,�������˵���������C,����C��������A��B������������,����ʹ�������������������C��. 
	 *  �鲢�����˼���ǰ�һ������ֳ�����,����ÿһ��,Ȼ������������鲢��һ�����������
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
	 * @param lowPtr:ǰ�벿�ֵ�������Ŀ�ʼλ��
	 * @param highPtr:��벿�ֵ�������Ŀ�ʼλ��
	 * @param upperBound:��벿����������Ͻ�
	 *  �鲢�㷨�����ǹ鲢�����Ѿ����������:merge A and B into C.
	 *  ��A��B����������бȽ�,��С����������Ƶ�C��, 
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
 *  �鲢����:�ٶ��ϱȼ������ö�
 *  ʹ�õݹ�ʵ�ֵ�����
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
