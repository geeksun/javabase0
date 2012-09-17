package com.geeks.thread;

public class Thread3 extends Thread{
	int from,to;
	long sum;
	Thread3(int from,int to)
	{
		this.from = from;
		this.to = to;
	}
	long getSum()
	{
		return sum;
	}
	public void run()
	{
		for(int i=from;i<=to;i++)
		{
			sum += i;
		}
	}
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException { 
		Thread3 th = new Thread3(1,1000);
		//  启动线程
		th.start();
		//  无限期等待线程死亡,线程死亡后,接着执行下一语句
		th.join();
		System.out.println(th.getSum());
		//  查看线程是否还存活：run()方法执行完之后,线程就死亡了
		System.out.println(th.isAlive());
	}

}
