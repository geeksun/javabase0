package com.base.inner;

/**
 * @category 说明如下： 
 * 一.静态内部类可以有静态成员，而非静态内部类则不能有静态成员。 故 A、B 错 
 * 二.静态内部类的非静态成员可以访问外部类的静态变量，而不可访问外部类的非静态变量；return d1 出错。 故 D 错 
 * 三.非静态内部类的非静态成员可以访问外部类的非静态变量。 故 C 正确 
 * 四.答案为C、E 
 */
public class Outer {
	private static double d1 = 1.0; 
	/*class InnerOne{ 
		public static double methoda() 
		{
			return d1;
		} */
		/*public class InnerOne{ 
			static double methoda() {return d1;} 
			} */
	/*private class InnerOne{ 
		double methoda() {return d1;} 
	} */
	static class InnerOne{ 
		protected double methoda() {
			return d1;
		} 
	}
	
	abstract class InnerTwo{ 
		public abstract double methoda(); 
	} 
}
