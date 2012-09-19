package com.base.gc;

/**
 * @author 姜志强
 *  测试 finalize() 的运行情形：在设计类时尽可能避免在类的默认构造器中创建、初始化大量的对象，防止在调用其自类的构造器
 *  时造成不必要的内存资源浪费。
 *  2009-4-30
 */
public class TestC {
	C c = null;
	public TestC(){
		c = new C();
	}
	
	protected void destroy(){
		if(c!=null){
			c.destroy();
		}else{
			System.out.println("c 对象已被释放");
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestC tc = new TestC();
		tc.destroy();
		
	}

}
