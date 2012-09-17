package com.geeksun.gc;

/**
 * @author 姜志强
 *  析构方法：finalize, 因为 finalize 方法没有自动实现递归调用，必须手动实现，如 super.finalize();
 *  通过这种方式，我们可以实现从下到上 finalize 的调用，即先释放用户类自身的资源，然后再释放父类的资源，通常可以在
 *  finalize 方法中释放一些不容易控制、并且非常重要的资源。如IO操作，数据的连接。
 *  2009-4-29
 */
public class A {
	Object a = null;
	
	public A(){
		a = new Object();
		System.out.println("创建 a 对象");
	}
	
	/* 
	 *  释放系统资源
	 */
	protected void destroy(){
		System.out.println("释放 a 对象\n");
		//释放自身所占用的资源
		a = null;
	}
	
	protected void finalize() throws Throwable{
		//双保险内存释放
		destroy();
		super.finalize();		//递归调用超类中的 finalize()
	}
	
}
