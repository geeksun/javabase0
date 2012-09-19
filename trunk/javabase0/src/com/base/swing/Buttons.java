package com.base.swing;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author 姜志强
 * @annotation: 将容器组件加入到容器中
 * @create at 2009-4-21
 */
public class Buttons extends JFrame {
	JButton abort = new JButton("Abort");
	JButton retry = new JButton("Retry");
	JButton fail = new JButton("Fail");
	
	public Buttons(){
		super("Buttons");
		setSize(180, 140);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//框架被关闭时退出程序
		JPanel pane = new JPanel();		//Swing容器：面板类
		pane.add(abort);
		pane.add(retry);
		pane.add(fail);
		setContentPane(pane);		//将面板作为内容传给框架
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Buttons rb = new Buttons();
		rb.setVisible(true);		//显示
	}

}
