package com.base.algorithms;

/**
 * 数组类: 希尔排序
 */
class ArraySh {
	private long[] theArray;
	private int nElems; // 记录数组的容量大小

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
	 * 希尔排序:缩小增量排序法，基于插入排序实现的
	 */
	public void shellSort() {
		int inner, outer;
		long temp;

		int h = 1; 	// find initial value of h
		while (h <= nElems / 3) {
			h = h * 3 + 1;		// 最大间隔值 Max interval
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
			// decrease h,减少 h 的值
			h = (h - 1) / 3;
		}
	}
}

/**
 * 希尔排序:基于插入排序实现的,在插入排序的开始部分,在合适的地方把 h 赋值为 1,并且添加生成间隔序列的公式.
 * 又称缩小增量排序法
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
