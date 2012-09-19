package com.base.db;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for(int i=0;i<10000;i++){
			String s = "A";
			s += i;
			System.out.println(s);
		}
	}
}
