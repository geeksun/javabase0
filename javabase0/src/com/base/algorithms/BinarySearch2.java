package com.base.algorithms;

import java.util.Arrays;

/**
 * @author 姜志强
 * 数组的二分查找算法:binary search,用于较大数目记录的快速查找
 * 2010-4-20
 */
public class BinarySearch2 {

	/**
	 * Array 中二分查找算法源代码
	 * Searches the specified array of ints for the specified value using the
	 * binary search algorithm.  The array <strong>must</strong> be sorted (as
	 * by the <tt>sort</tt> method, above) prior to making this call.  If it
	 * is not sorted, the results are undefined.  If the array contains
	 * multiple elements with the specified value, there is no guarantee which
	 * one will be found.
	 *
	 * @param a the array to be searched.
	 * @param key the value to be searched for.
	 * @return index of the search key, if it is contained in the list;
	 *	       otherwise, <tt>(-(<i>insertion point</i>) - 1)</tt>.  The
	 *	       <i>insertion point</i> is defined as the point at which the
	 *	       key would be inserted into the list: the index of the first
	 *	       element greater than the key, or <tt>list.size()</tt>, if all
	 *	       elements in the list are less than the specified key.  Note
	 *	       that this guarantees that the return value will be &gt;= 0 if
	 *	       and only if the key is found.
	 * @see #sort(int[]) 先将数组排序（升序）
	 */
	public static int binarySearch(int[] a, int key) {
		Arrays.sort(a);
		int low = 0;
		int high = a.length - 1;

		while (low <= high) {
			int mid = (low + high) >> 1;
			int midVal = a[mid];

			if (midVal < key)
				low = mid + 1;
			else if (midVal > key)
				high = mid - 1;
			else
				return mid; // key found
		}
		return -(low + 1); // key not found.
	}

	public static int binarySearch2(int[] a, int key) {
		Arrays.sort(a);
		int low = 0;
		int high = a.length - 1;
		while (low <= high) {
			int mid = low + ((high - low) / 2);
			//int mid = (low + high) >>> 1;

			//int mid = (low + high) / 2;
			int midVal = a[mid];
			if (midVal < key)
				low = mid + 1;
			else if (midVal > key)
				high = mid - 1;
			else
				return mid; // key found
		}
		return -(low + 1); // key not found.
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] _t = {1,2,88,9,22,44,55,101,33,29,93,81,49,55};
		System.out.println(binarySearch(_t, 101));
		
	}

}
