package com.base.swing;

import javax.swing.JFrame;

/**
 * @author ��־ǿ
 * @annotation: Swing ��ADT��Abstract Windowing Tookit������չ
 */
public class SimpleFrame extends JFrame {
	
	public SimpleFrame(){
		super("Frame Title");
		//unitΪ��px
		setSize(300, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//��ܱ��ر�ʱ�˳�����
		setVisible(true);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SimpleFrame sf = new SimpleFrame();
	}

}
