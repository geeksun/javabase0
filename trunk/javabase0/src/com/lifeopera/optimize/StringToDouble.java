package com.lifeopera.optimize;

/**
 * @author 姜志强
 *  将字符串转化为数字非常耗时，性能消耗比较大，与将数字转化为数字对象的计算性能为 --> 281：15
 *  2009-5-9
 */
public class StringToDouble {

	public static void main(String[] args) {
		final int N = 1000000;
		Double d;
		
		//从一个字符串构造 Double 对象
		long startTime = System.currentTimeMillis();
		for(int i=1;i<=N;i++){
			d = new Double("2.83");
		}
		long endTime = System.currentTimeMillis();
		System.out.println("将字符串转化为数字：" + (endTime-startTime));
		
		//从数字构造 Double 对象
		startTime = System.currentTimeMillis();
		for(int i=1;i<=N;i++){
			d = new Double(2.83);
		}
		endTime = System.currentTimeMillis();
		System.out.println("将数字转化为 Double 类型的数字：" + (endTime-startTime));
	}

}
