package com.base.test;

/**
 * @author jzq
 * static test
 * 2009-5-7
 */
class StaticByName {

	static {		//�෽��, ֻ���������ʱ�����һ�Σ���
		System.out.println("static");
	}

	static int a = 42;

	static int b = 99;

	static void callme() {
		System.out.println("a = " + a);
	}
}

public class  StaticDemo{
	public static void main(String args[]) {
		StaticByName.callme();
		System.out.println("b = " + StaticByName.b);
	}

}
