package com.base.oop;

/**
 * @author Administrator
 * @version 匿名内部类是为唯一对象而定义的类,类的定义与对象的创建被合并在一起
 * 匿名内部类可以实现接口或是继承别的类
 */
class Anony{
	public void hi(){
		System.out.println("hi?");
	}
	public void hello(){
		System.out.println("hello?");
	}
}
public class AnonymousClass {
	public static void main(String[] args){
		Anony aa = new Anony(){						//  继承Anony类的匿名类
			public void hi(){
				System.out.println("hi,you?");
		}
	};
	aa.hi();
	aa.hello();
	}												
}
