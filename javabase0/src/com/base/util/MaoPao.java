package com.base.util;

/**
 * @author geeksun
 * @version √∞≈›≈≈–Ú∑®:…˝–Ú
 * 2008-4-10
 */
public class MaoPao {
	
	public static void bubbleSort(int[] a) {
		int temp;
		for (int i = a.length - 1; i > 0; i--)
			for (int k = 0; k < i; k++)
				if (a[k] > a[k + 1]) {
					temp = a[k];
					a[k] = a[k + 1];
					a[k + 1] = temp;
				}
	}
	
	/**
	 * @param j,√∞≈›≈≈–Ú
	 */
	public static void maopao(int[] j) {
		for (int i = 0; i < j.length - 1; i++)
			for (int k = 0; k < j.length-i-1; k++) {
				if (j[k] > j[k+1]) {
					int temp = j[k];
					j[k] = j[k+1];
					j[k+1] = temp;
				}
			}
	}

	public static void main(String[] args) {
		int[] i = { 93, 29, 91, 10 };

		bubbleSort(i);
		for (int t = 0; t < i.length; t++) {
			System.out.println(i[t]);
		}
	}
}
