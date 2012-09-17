package com.lifeopera.optimize;

/**
 * 不用比较运算符，判断 int 型的a，b两数的大小,考虑溢出问题.
 * 2009-5-1
 */
public class Test {
	private static final String[] buf = { "a>=b", "a < b" };

	public static void main(String[] args) {
		System.out.println(compare(1, 2)); // 1 <
		System.out.println(compare(2, 2)); // 0 >=
		System.out.println(compare(2, 1)); // 0 >=
		System.out.println(compare(Integer.MIN_VALUE, Integer.MAX_VALUE)); // 1 <
		System.out.println(compare(Integer.MAX_VALUE, Integer.MIN_VALUE)); // 0 >=
	}

	/**
	 * 比较2个整数(int)的大小。
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static int compare(int a, int b) {
		return (int) (((long) a - (long) b) >>> 63);
	}
	
	
}
