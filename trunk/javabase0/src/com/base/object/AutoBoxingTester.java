package com.base.object;

/**
 * @author ��־ǿ
 * �Զ�װ�����
 */
public class AutoBoxingTester {
	public static void judgeEqual(Integer i, Integer j) {
		if (i == j) {
			System.out.println("Equal!");
		} else {
			System.out.println("Not Equal!");
		}
	}

	public static void main(String[] args) {
		Integer i = 100;
		Integer j = 100;
		judgeEqual(i, j);
		Integer a = 255;
		Integer b = 255;
		judgeEqual(a, b);
	}

}
