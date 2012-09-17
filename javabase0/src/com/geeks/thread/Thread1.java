package com.geeks.thread;

/**
 * @author 姜志强
 * 线程也是一种对象,并非任何对象都能成为线程,只有实现了Runnable接口的类的对象才能成为线程：
 * 即实现Runnable接口是对象转变为线程的一个必要条件
 */
public class Thread1 implements Runnable {
	String name;
	Thread1(String name)
	{
		this.name = name;
	}
	public void run() {
		for(int i=1;i<=10;i++)
		{
			System.out.println("name: "+i);
		}
	}
	public void start()
	{
		System.out.println("strat");
	}
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		Thread1 th = new Thread1("sun");
		//  创建线程,th为实现了Runnable接口的类的对象
		Thread tr = new Thread(th);
		//  运行线程,需要调用Thread的start()来启动
		tr.start();
		//  无限期等待线程死亡
		tr.join(); 
		System.out.println("join...");
		tr.run();
		System.out.println("join...");
	}
	
}
