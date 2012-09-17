package com.geeksun.oop;
class Super{
	int a;
	Super(){
		a = 1;
	}
	Super(int a){
		this.a = a;
	}
}
/**
 * @author geeksun
 * @version 通过extends,子类会拥有父类的全部成员
 */
public class Extends extends Super{
	int b;
	Extends(int a,int b){
		super(a);												// 不加此方法时,a被赋值1
		this.b = b;
	}
	public static void main(String[] args){
		Extends ee = new Extends(21,44);
		System.out.println(ee.a + " " + ee.b);
	}
}
