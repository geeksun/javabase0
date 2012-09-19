package com.base.gc;

/**
 * @author 姜志强
 *  测试静态变量的使用（static variable）: 程序运行期间内存空间对所有该类的对象实例是共享的。可以节省系统开销，共享资源。
 *  2009-4-30
 */
public class WeekA {
	
	/**
	 * 静态内部类
	 */
	static class Data{
		private int week;
		private String name;
		Data(int i, String s){
			week = i;
			name = s;
		}
	}
	
	//static Data weels[] = {
	Data weels[] = {
			new Data(1, "Monday"), 
			new Data(2, "Tuesday"), 
			new Data(3, "Wednesday"), 
			new Data(4, "Thursday"), 
			new Data(5, "Friday"), 
			new Data(6, "Saturday"), 
			new Data(7, "Sunday"), 
			
	};
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final int N = 20000;
		WeekA weekinstance;
		long begin = System.currentTimeMillis();
		for(int i=1;i<=N;i++){
			weekinstance = new WeekA();
		}
		long end = System.currentTimeMillis();
		System.err.print("\nTime:" + (end-begin));
		
	}

}
