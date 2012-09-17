package com.base.common;

public class DoWhile {
	public static void main(String[] args){
		int i = 0,j = 9;
		do{
			lable1:if(j<4){
				break lable1;
			}else if(j--<7){
				continue;
			}
			i++;
		}
		while(i++<7);
		System.out.println(i+" "+j);
		System.out.println("*******第二个DoWhile例子*******");
		int s = 1;
		do{
			System.out.println(s);
			s++;
		}while(s<=3);													//  如果为 s < 1,则输出1
																										
	}
}
