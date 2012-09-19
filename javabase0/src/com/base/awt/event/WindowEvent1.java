package com.base.awt.event;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * @author 姜志强
 * @annotation: 窗口事件的处理
 * @create at 2009-4-3
 */
@SuppressWarnings("serial")
public class WindowEvent1 extends Frame implements WindowListener {
	
	public WindowEvent1(){
		setTitle("窗口事件处理");		//框架窗口设定标题
		addWindowListener(this);	//注册窗口事件监听对象
	}
	
	public void windowActivated(WindowEvent e) {

	}

	public void windowClosed(WindowEvent e) {
		
	}

	/**
	 * @see 关闭窗口时，调用该方法
	 */
	public void windowClosing(WindowEvent e) {	
		Dialog d = new Dialog(this, "确认退出", true);
		
		//创建面板，并向其添加“是”，“否”两个按钮
		Panel p = new Panel();
		p.setLayout(new GridLayout());
		p.add(new Button("是"));
		p.add(new Button("否"));
		
		//向对话框添加标签和面板
		d.add(new Label("想要退出吗？", Label.CENTER),"Center");
		d.add(p, "South");
		
		//show dialog
		d.setSize(200, 100);
		d.setVisible(true);
	}

	public void windowDeactivated(WindowEvent e) {

	}

	public void windowDeiconified(WindowEvent e) {

	}

	public void windowIconified(WindowEvent e) {

	}

	public void windowOpened(WindowEvent e) {
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WindowEvent1 we = new WindowEvent1();
		we.setSize(200, 100);
		we.setVisible(true);
		
	} 


}
