package com.base.system;

/**
 * @author ��־ǿ
 *  ��ʽ�����: ʹ��printf()
 *  2009-12-12
 */
public class SimpleFormat {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int x = 5;
		double y = 5.332521;
		// The old way:
		System.out.println("Row 1: [" + x + " " + y + "]");
		// The new way:
		System.out.format("Row 1: [%d %f]\n", x, y);
		// or
		System.out.printf("Row 1: [%d %f]\n", x, y);
		

	}
	

}
