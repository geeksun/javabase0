package com.base.algorithms;

/**
 * ������: ϣ������
 */
class ArraySh {
	private long[] theArray;
	private int nElems; // ��¼�����������С

	public ArraySh(int max) {
		theArray = new long[max];
		nElems = 0;
	}

	public void insert(long value) {
		theArray[nElems] = value;
		nElems++; // increment size
	}

	/**
	 * display array contents
	 */
	public void display() {
		System.out.print("A=");
		for (int j = 0; j < nElems; j++) {
			System.out.print(theArray[j] + " ");
		}
		System.out.println();
	}

	/**
	 * ϣ������:��С�������򷨣����ڲ�������ʵ�ֵ�
	 */
	public void shellSort() {
		int inner, outer;
		long temp;

		int h = 1; 	// find initial value of h
		while (h <= nElems / 3) {
			h = h * 3 + 1;		// �����ֵ Max interval
			System.out.println("h----"+h);
		}

		// decreasing h,until h=1
		while (h > 0) {
			for (outer = h; outer < nElems; outer++) {
				temp = theArray[outer];
				inner = outer;

				while (inner > h - 1 && theArray[inner - h] >= temp) {
					theArray[inner] = theArray[inner - h];
					inner -= h;
				}
				theArray[inner] = temp;
			}
			// decrease h,���� h ��ֵ
			h = (h - 1) / 3;
		}
	}
}

/**
 * ϣ������:���ڲ�������ʵ�ֵ�,�ڲ�������Ŀ�ʼ����,�ں��ʵĵط��� h ��ֵΪ 1,����������ɼ�����еĹ�ʽ.
 * �ֳ���С��������
 * 2010-9-20
 */
public class ShellSort {
	public static void main(String[] args) {
		int maxSize = 10;
		ArraySh arr;
		arr = new ArraySh(maxSize);

		for (int j = 0; j < maxSize; j++) {
			long n = (int) (java.lang.Math.random() * 99);
			arr.insert(n);
		}

		arr.display();
		
		arr.shellSort();

		arr.display();
	}
}
