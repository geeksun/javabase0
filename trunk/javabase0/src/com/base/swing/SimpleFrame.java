package com.base.swing;

import javax.swing.JFrame;

/**
 * @author 姜志强
 * @annotation: Swing 是ADT（Abstract Windowing Tookit）的扩展
 */
public class SimpleFrame extends JFrame {
	
	public SimpleFrame(){
		super("Frame Title");
		//unit为：px
		setSize(300, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//框架被关闭时退出程序
		setVisible(true);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SimpleFrame sf = new SimpleFrame();
	}

}
