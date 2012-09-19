package com.base.swing;

import javax.swing.JWindow;

/**
 * @author ��־ǿ
 * @annotation: �򵥴���,��������һ�����ڣ��������д�������ʾǰ 10000 ���Ǹ�������Ȼ��رոô��ڡ�
 * @create at 2009-4-20
 */
public class SimpleWindow extends JWindow {
	
	public SimpleWindow(){
		super();
		//�趨λ��
		setBounds(250, 225, 300, 150);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SimpleWindow sw = new SimpleWindow();
		sw.setVisible(true);
		for(int i=0;i<10000;i++){
			System.out.print(i + " ");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		sw.setVisible(false);
		System.exit(0);
	}
	
}
