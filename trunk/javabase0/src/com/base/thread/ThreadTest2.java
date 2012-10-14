package com.base.thread;

/**
 * Description 接口Runnable比实现Thread类更适用于统计情景
 * @author Administrator
 * 2012-9-17
 */
public class ThreadTest2 {
	
	class Thread0 extends Thread{
		
		public int x = 0;
		
		public void run(){
			System.out.println(++x);
		}
	}
	
	class Thread1 implements Runnable{
		private int x = 0;
		
		@Override
		public void run() {
			System.out.println(++x);
		}
	}

	/**
	 * @param args 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		ThreadTest2 tt = new ThreadTest2();
		for(int i=0;i<10;i++){
			Thread t = tt.new Thread0();
			t.start();
		}
		
		Thread.sleep(1000);
		Thread1 t1 = tt.new Thread1();
		for(int i=0;i<10;i++){
			Thread t11 = new Thread(t1);
			t11.start();
		}
		
	}

}
