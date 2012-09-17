package com.lifeopera.optimize;

/**
 * @author 姜志强
 *  同步方法：用来保护多线程环境下的共享资源
 *  在Java 程序中，被宣布为同步(Synchronized)的方法，对象或数据，在任何一个时刻只能被一个线程访问。还有一方法是同步块。
 *  2009-5-5
 */
public class SynchronizedTest {
	private int i = 0;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SynchronizedTest st = new SynchronizedTest();
		st.startThread();
		
	}

	/**
	 *  启动线程方法
	 */
	private void startThread(){
		//同时启动3个线程
		for(int j=0;j<3;j++){
			new Thread(new ThreadWorker()).start();
		}
	}
	
	/**
	 * @author 姜志强
	 *  内部线程类
	 */
	class ThreadWorker implements Runnable{
		public void run(){
			showMessage();
		}
	}
	
	/**
	 *  同步方法，一次只能被一个线程访问
	 */
	private synchronized void showMessage(){
		Thread currentThread = Thread.currentThread();
		System.out.println("当前线程为：" + currentThread.getName());
		++i;
	}
	
}
