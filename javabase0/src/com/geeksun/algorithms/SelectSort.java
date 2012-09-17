package com.geeksun.algorithms;

/**
 * ѡ�����򣺰����е�Ԫ��ɨ��һ��,����ѡ�����С�����ݷ�������ĵ�һ��Ԫ��,����С�ķ��ڵڶ�λ
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

	public void display() {
		for (int j = 0; j < nElems; j++) {
			System.out.print(a[j] + " ");
		}
		System.out.println();
	}

	/**
	 * ѡ�������㷨:�ҳ����������Сֵ,�������������,����С�����˳������
	 */
	public void selectSort() {
		int out, in, min;
		for (out = 0; out < nElems - 1; out++) {
			min = out; // ������ĵ�һ��Ԫ�ؿ�ʼ����С��
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
