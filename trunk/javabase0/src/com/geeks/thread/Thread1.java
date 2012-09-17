package com.geeks.thread;

/**
 * @author ��־ǿ
 * �߳�Ҳ��һ�ֶ���,�����κζ����ܳ�Ϊ�߳�,ֻ��ʵ����Runnable�ӿڵ���Ķ�����ܳ�Ϊ�̣߳�
 * ��ʵ��Runnable�ӿ��Ƕ���ת��Ϊ�̵߳�һ����Ҫ����
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
		//  �����߳�,thΪʵ����Runnable�ӿڵ���Ķ���
		Thread tr = new Thread(th);
		//  �����߳�,��Ҫ����Thread��start()������
		tr.start();
		//  �����ڵȴ��߳�����
		tr.join(); 
		System.out.println("join...");
		tr.run();
		System.out.println("join...");
	}
	
}
