package com.geeks.thread;

/**
 * @author ��־ǿ
 * �����̵߳���һ�ַ����Ǽ̳�Thread��,Thread�౾��ʵ����Runnable�ӿ�
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
