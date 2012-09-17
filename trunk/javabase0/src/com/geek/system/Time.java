package com.geek.system;

public class Time {
	/**
	 *  返回以毫秒计的当前系统时间，为与1970年1月1日0时之间的差
	 */
	public static void getTime()
	{
		long time = System.currentTimeMillis();
		System.out.println(time);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getTime();
	}

}
