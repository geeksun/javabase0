package com.lifeopera.optimize;

/**
 * @author 姜志强
 *  final 的用法：内联函数？final方法可以提升系统性能, 加快处理速度（运行）
 *  2009-5-1
 */
public final class FinalDemo {		//将类声明为final, 也可起来内联作用, 加快应用速度, 提高系统性能.
	//类的常量
	public static final String USER_NAME = "root";
	
	/**
	 *  方法的常量参数，为防止参数被方法体中的语句更改。
	 *  对变量起保护作用，防止变量被无意赋值。
	 */
	public void showMessage(final String userName){
		//userName = "test";  can not operate
		System.out.println("userName: " + userName);
	}
	
	/**
	 *  不可被覆盖（override）的方法, 而且还可以加快应用的运行速度、提高系统性能。类似于 c++ 里的内联函数。
	 *  内联函数就是当你编译程序时就可以确定该函数的代码，并且可以将函数的代码展开插入到调用者代码处。
	 */
	public final void showPrivacyMessage(){
		System.out.println("showPrivacyMessage: Toms address is ...");
	}
	
	/**
	 *  final 方法运行效果类似于内联函数(inline), 当你编译程序时就可以确定该函数的代码，
	 *  并且可以将函数的代码展开插入到调用者代码处, 因此提高了应用的运行速度, 提高了系统效率。
	 */
	public final static int inline(int a, int b){
		return (a > b ? a: b);
	}
	
	/**
	 *  返回最大值
	 */
	public static int max(int a, int b){
		return (a > b ? a : b);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final int N = 10000000;
		int a = 5;
		int b = 17;
		int c;
		
		
		//使用与 max 方法相同的内联代码
		long start = System.currentTimeMillis();
		for(int i=1;i<N;i++){
			c = (a > b ? a : b);
		}
		long end = System.currentTimeMillis();
		// run result: 32、31 
		System.err.print("\n使用内联代码：" + (end - start));
		
		//调用普通方法： 方法在运行时编译
		long startTime = System.currentTimeMillis();
		for(int i=1;i<N;i++){
			c = max(a, b);
		}
		long endTime = System.currentTimeMillis();
		// run result: 32、31 or 47
		System.err.print("\n调用普通方法: " + (endTime-startTime));
		
		//使用与 inline 方法
		long begin = System.currentTimeMillis();
		for(int i=1;i<N;i++){
			c = inline(a, b);
		}
		long last = System.currentTimeMillis();
		//32、31
		System.err.print("\n使用内联方法：" + (last - begin));
	}

}
