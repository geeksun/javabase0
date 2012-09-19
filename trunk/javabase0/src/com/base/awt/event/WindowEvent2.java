package com.base.awt.event;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * @author 姜志强
 * @annotation: 窗口事件的处理，将CloseFrameDialog 类应用于框架窗口中。
 * @create at 2009-4-4
 */
public class WindowEvent2 extends Frame implements WindowListener {
	public WindowEvent2(){
		setTitle("窗口关闭事件的处理");		//
		addWindowListener(this);
	}
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * @see 关闭窗口时，调用该方法
	 */
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		//对话框（所有者＝this,标题＝“关闭”，消息＝“确实要关闭吗？“）
		CloseFrameDialog cf = new CloseFrameDialog(this, "关闭", "确实要关闭吗");
		
		cf.setSize(200, 100);
		cf.setVisible(true);
	}

	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WindowEvent2 we = new WindowEvent2();
		we.setSize(200, 200);
		we.setVisible(true);
	}

}
