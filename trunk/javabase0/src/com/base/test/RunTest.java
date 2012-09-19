package com.base.test;

public class RunTest implements Run {
	int i = 2;
	public void run() {
		// TODO Auto-generated method stub
		++i;
		System.out.println("-------"+i);
	}
	public static void main(String[] args){
		boolean a = true;
		boolean b = true;
		boolean c = false;
		System.out.println(a==c);
	}
}
