package com.base.oop;

/**
 * @author Administrator
 * @version ����ӵ���븸����ͬ��Ա�������Ϊ����(override),Ŀ����ͨ�������������¶�����չ����Ĺ���
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
	/**@version private ֻ����������ڲ�����
	 * @param a
	 * @param b
	 * @return
	 */
	private int g(int a,int b){
		System.out.println(a+" "+b);
		return a+b;
	}
}