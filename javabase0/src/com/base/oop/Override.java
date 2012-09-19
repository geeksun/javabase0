package com.base.oop;

/**
 * @author Administrator
 * @version 子类拥有与父类相同成员的情况称为覆盖(override),目的是通过在子类中重新定义扩展父类的功能
 */

public class Override extends ParentTest{
	int a;
	int b;
	void f(int a){
		System.out.print(a +"***");
	}
	public int g(int a,int b){
		return a+b;
	}
}
class Parent{
	int a;
	void f(int a){
		System.out.print(a);
	}
	/**@version private 只限于在类的内部访问
	 * @param a
	 * @param b
	 * @return
	 */
	private int g(int a,int b){
		System.out.println(a+" "+b);
		return a+b;
	}
}