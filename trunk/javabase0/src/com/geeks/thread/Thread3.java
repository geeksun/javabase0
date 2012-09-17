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
		//  �����߳�
		th.start();
		//  �����ڵȴ��߳�����,�߳�������,����ִ����һ���
		th.join();
		System.out.println(th.getSum());
		//  �鿴�߳��Ƿ񻹴�run()����ִ����֮��,�߳̾�������
		System.out.println(th.isAlive());
	}

}
