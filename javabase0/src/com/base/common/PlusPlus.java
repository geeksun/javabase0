package com.base.common;

/**
 * @author geeksun
 * @version ++���÷�
 */
public class PlusPlus {
	public static void main(String[] args){
		int a = 0;
		int b = 0;
		System.out.println(a++>0);
		System.out.println(b++>0);
		System.out.println(a);
		if(a++>0 && b++>0){				//  ������Ϊ false
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
		
		// ++ ǰ�û������㣬����(���Ѻ���)���������෴,Ϊ�ȴ��������㡣
		int x = 3,y = 3;
	    int c = ++x;
	    int d = y++;
	    System.out.println(c + "  " +d);
	}
}
