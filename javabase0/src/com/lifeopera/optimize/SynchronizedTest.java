package com.lifeopera.optimize;

/**
 * @author ��־ǿ
 *  ͬ�������������������̻߳����µĹ�����Դ
 *  ��Java �����У�������Ϊͬ��(Synchronized)�ķ�������������ݣ����κ�һ��ʱ��ֻ�ܱ�һ���̷߳��ʡ�����һ������ͬ���顣
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
	 *  �����̷߳���
	 */
	private void startThread(){
		//ͬʱ����3���߳�
		for(int j=0;j<3;j++){
			new Thread(new ThreadWorker()).start();
		}
	}
	
	/**
	 * @author ��־ǿ
	 *  �ڲ��߳���
	 */
	class ThreadWorker implements Runnable{
		public void run(){
			showMessage();
		}
	}
	
	/**
	 *  ͬ��������һ��ֻ�ܱ�һ���̷߳���
	 */
	private synchronized void showMessage(){
		Thread currentThread = Thread.currentThread();
		System.out.println("��ǰ�߳�Ϊ��" + currentThread.getName());
		++i;
	}
	
}
