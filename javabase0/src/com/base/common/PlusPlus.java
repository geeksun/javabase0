package com.base.common;

/**
 * @author geeksun
 * @version ++的用法
 */
public class PlusPlus {
	public static void main(String[] args){
		int a = 0;
		int b = 0;
		System.out.println(a++>0);
		System.out.println(b++>0);
		System.out.println(a);
		if(a++>0 && b++>0){				//  此条件为 false
			b++;
		}
		/*System.out.println(a++>0);
		System.out.println(b++>0);
		System.out.println(a);*/
		System.out.println(b);
		if(a==1&&b++==0){
			b++;
		}
		System.out.println(b);
		
		// ++ 前置会先运算，后处理(先已后人)；后置则相反,为先处理，后运算。
		int x = 3,y = 3;
	    int c = ++x;
	    int d = y++;
	    System.out.println(c + "  " +d);
	}
}
