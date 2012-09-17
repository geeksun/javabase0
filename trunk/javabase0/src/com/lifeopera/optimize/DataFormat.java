package com.lifeopera.optimize;

import java.text.MessageFormat;

/**
 * @author 姜志强
 * 数据格式化与性能优化: 使用操作符格式化数据与通过预编译格式化数据的比是： 63：157
 * 2009-5-17
 */
public class DataFormat {

	final static int N = 25000;
	
	/**
	 *  采用操作符格式化数据
	 */
	public static void operatorFormat(){
		String s;
		
		long startTime = System.currentTimeMillis();
		for(int i=1;i<=N;i++){
			s = "The square of " + i + " is " + (i*i);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("采用操作符格式化数据:"+(endTime-startTime)+"ms");
	}
	
	/**
	 *  采用预编译的方式格式化数据
	 */
	public static void precompileFormat(){
		Object argvec[] = new Object[2];
		MessageFormat f = new MessageFormat("The square of {0,number,#} is {1,number,#}");
		
		long startTime = System.currentTimeMillis();
		for(int i=1;i<=N;i++){
			argvec[0] = new Integer(i);
			argvec[1] = new Integer(i*i);
			String s = f.format(argvec);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("采用预编译的方式格式化数据:"+(endTime-startTime)+"ms");
	}
	
	/**
	 *  采用操作符格式化数据
	 */
	/*public static void operatorFormat(){
		String s;
		
		long startTime = System.currentTimeMillis();
		for(int i=1;i<=N;i++){
			s = "The square of " + i + " is " + (i*i);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("采用操作符格式化数据:"+(endTime-startTime)+"ms");
	}*/
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		operatorFormat();
		precompileFormat();
		
	}

}
