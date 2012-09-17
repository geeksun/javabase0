package com.geeks.thread;

/**
 * @author 姜志强
 * 创建线程的另一种方法是继承Thread类,Thread类本身实现了Runnable接口
 */
public class Thread2 extends Thread{
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 * override run()
	 */
	public void run()
	{
		for(int i=1;i<10;i++)
		{
			System.out.println(super.getName()+i);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread2 tr = new Thread2();
		tr.run();
	}

}
