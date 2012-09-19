package com.base.oop;

/**
 * @author Administrator
 * @version 父类对子类的引用范围的测试
 * 父类型引用变量的引用范围=继承自父类的成员+子类中覆盖父类的成员
 */
public class ParentTest{
	public static void main(String[] args){
		Super2 ss = new Sub();
		ss.a = 22;
		ss.hi();															// 子类中覆盖父类的成员方法
	}
}
class Super2{
	int a = 10;
	void hi(){
		System.out.println("hii");
	}
}
class Sub extends Super2{ 
	int b = 20;
	void hi(){
		System.out.println("hi****");
	}
	void bye(){
		System.out.println("bye");																	
	}
}