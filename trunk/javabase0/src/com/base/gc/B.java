package com.base.gc;

public class B extends A {
	Object b = null;
	
	public B(){
		b = new Object();
		System.out.println("创建 b 对象");
	}
	
	/* 
	 *  释放系统资源
	 */
	protected void destroy(){
		//释放自身所占用的资源
		System.out.println("释放 b 对象");
		b = null;
		super.destroy();
	}
	
	protected void finalize() throws Throwable{
		destroy();
		super.finalize();		//递归调用超类中的 finalize()
	}
	
}
