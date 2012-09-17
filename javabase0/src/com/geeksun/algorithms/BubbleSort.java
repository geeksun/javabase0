package com.geeksun.algorithms;

/**
 * BubbleSort:ð������,�㷨ִ�е�ʱ��,��������������"ð��"������Ķ��� 
 * ����1.�Ƚ���������;  2.�����ߵ����ݴ�,�ͽ���λ��;
 *      3.�����ƶ�һ��λ��,�Ƚ�������������;  4.��������1���Ŷ�λ�õ����ݺ�,���ص�����ĵ�1��Ԫ�ؿ�ʼ��һ������.  
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
	 * @param searchKey,�����ؽ�ֵ
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
	 * @param value,���������һ������
	 */
	public void insert(long value) {
		a[nElems] = value;
		nElems++;
	}

	/**
	 * @param value,ɾ�������е�ָ��ֵ
	 * @return boolean ��ֵ
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
	 * ð�������㷨:��һ�����򶼻���������ŵ����ұ�λ�ã��ڶ��ΰ�ʣ�������������ŵ�N-1λ�á�
	 */
	public void bubbleSort() {
		int out, in;
		for (out = nElems - 1; out > 0; out--)
			// ������㿪ʼ�Ƚ�,�������nElems-1�αȽϲ��ܰ��������������
			for (in = 0; in < out; in++)
				if (a[in] > a[in + 1]) {
					long temp = a[in];
					a[in] = a[in + 1];
					a[in + 1] = temp;
				}
		// for(out=0;out<nElems-1;out++)
		// for(in=out+1;in<nElems;in++)
		/*
		 * { if(a[out]>a[in]) //swap(in,in+1); // ��ý����������Ĵ���д������,�������һЩ�ٶ� { long
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
	 *  ������Ԫ�ص�ֵ
	 */
	public void swap(int one, int two) {
		long temp = a[one];
		a[one] = a[two];
		a[two] = temp;
	}

	/**
	 * ��ʾ��������
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
