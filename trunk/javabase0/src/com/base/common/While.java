package com.base.common;

public class While {
	public static void main(String[] args){
		int i = 0;
		while(i<=3){
			System.out.println(i);
			i++;
		}
		System.out.println("******¾Å¾Å³Ë·¨±í*******");
		int a=2,b;
		while(a<=9){
			b=1;
			while(b<=9){
				System.out.print(" "+a+"*"+b+"="+a*b);
				b++;
			}
			System.out.println();
			a++;
		}
	}
}
