package com.base.gc;

public class C extends B {
	Object c = null;
	public C(){
		c = new Object();
		System.out.println("创建 c 对象");
	}
	
	protected void destroy(){
		c = null;
		//释放自身的资源
		System.out.println("释放 c 对象");
		//释放父类占用的资源
		super.destroy();
	}
	
	protected void finalize() throws java.lang.Throwable{
		destroy();
		//递归调用父类的 finalize()
		super.finalize();
	}
}
