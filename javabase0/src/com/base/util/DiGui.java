package com.base.util;

/**
 * @author geeksun
 * @version 递归调用:方法调用自身的现象 -- recursive call
 * 递归使用了堆栈技术，弹出时，按照"先进后出"的原则进行
 */
public class DiGui {
	void hi(int n){
		if(n<=0){
			return;
		}
		hi(n-1);								// recursive call
		System.out.println("你好 " + n);
	}
	/**
	 * @param n
	 * @return for 循环求阶乘
	 */
	long factorial(int n){
		long f = 1;
		for(int i=2;i<=n;i++){
			f *= i;
		}
		return f;
	}
	/**
	 * @param n
	 * @return 递归求阶乘
	 */
	long factorial2(int n){
		if(n<=1) return 1;
		return factorial2(n-1)*n;
	}
	/**@version 递归设置下限,for循环设置上限
	 * @param n
	 * @return 递归求1-n的和
	 */
	long sum(int n){
		if(n<=1) return 1;
		return sum(n-1)+n;															
	}
	public static void main(String[] args){
		DiGui dg = new DiGui();
		dg.hi(3);
		System.out.println(dg.factorial(3));
		System.out.println(dg.factorial2(3));
		System.out.println("sum(10)="+dg.sum(10));
	}
}
