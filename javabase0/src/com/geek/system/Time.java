package com.geek.system;

public class Time {
	/**
	 *  �����Ժ���Ƶĵ�ǰϵͳʱ�䣬Ϊ��1970��1��1��0ʱ֮��Ĳ�
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
