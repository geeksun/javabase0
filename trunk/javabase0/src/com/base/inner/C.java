package com.base.inner;

/**
 * @author 姜志强
 *  内部类用法：
 *  2009-5-17
 */
public class C {
	private String mainName = null;
	
	public void showMessage(){
		//主类中不能直接引用内部类中的任何成员, 下面代码不正确
		/*innerName = "";
		innerMethod1();
		innerMethod2();*/
	}
	
	public void mainMethod() {
		
	}
	
	/**
	 *	主类 C 中的内部类
	 */
	class InnerClass{
		private String innerName = null;
		
		public void innerMethod1(){
			//可以在内部类中引用主类的私有成员
			mainName = "";
			mainMethod();
		}
		
		private void innerMethod2(){
			;
		}
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
	

}
