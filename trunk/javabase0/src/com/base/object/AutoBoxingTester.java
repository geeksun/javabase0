package com.base.object;

/**
 * @author 姜志强
 * 自动装箱测试
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
