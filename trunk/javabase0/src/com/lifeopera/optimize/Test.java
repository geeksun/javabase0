package com.lifeopera.optimize;

/**
 * ���ñȽ���������ж� int �͵�a��b�����Ĵ�С,�����������.
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
	 * �Ƚ�2������(int)�Ĵ�С��
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static int compare(int a, int b) {
		return (int) (((long) a - (long) b) >>> 63);
	}
	
	
}
