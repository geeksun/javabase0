package com.geeks.thread;
/**
 *  �̵߳Ĳ���
 *  2009-5-12
 */
public class ThreadTest implements Runnable {
	public void run() {
		System.out.println("ok");
	}
	public void start(){
		for(int i=0;i<10;i++)
		{
			System.out.println("i:"+i);
		}
	}
	public static void main(String [] args)
	{	
		ThreadTest t = new ThreadTest();
		//  �����̶߳���
		Thread tt = new Thread(t);
		//  tt.run();
		tt.start();
	}
}
