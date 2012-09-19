package com.base.swing;

import javax.swing.JWindow;

/**
 * @author 姜志强
 * @annotation: 简单窗口,创建并打开一个窗口，在命令行窗口中显示前 10000 个非负整数，然后关闭该窗口。
 * @create at 2009-4-20
 */
public class SimpleWindow extends JWindow {
	
	public SimpleWindow(){
		super();
		//设定位置
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
