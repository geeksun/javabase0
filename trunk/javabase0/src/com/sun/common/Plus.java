package com.sun.common;

public class Plus {
	static int a = 5;
	int b = 3;
	public Plus(){
		a++;
		b++;
	}
	public static void main(String[] args){
		Plus s = new Plus();
		// System.out.println(a+" "+b);             b不能被直接引用reference，因为b不是静态变量
		System.out.println(a+" "+s.b);
		Plus t = new Plus();
		System.out.println(a+" "+t.b);
	}
	
}
