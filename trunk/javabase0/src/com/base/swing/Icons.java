package com.base.swing;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author ��־ǿ
 * @annotation: ʹ��ͼ��
 * @create at 2009-4-21
 */
public class Icons extends JFrame {
	JButton[] buttons = new JButton[24];
	
	public Icons(){
		super("Icons");
		setSize(335, 318);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel pane = new JPanel();
		ImageIcon icon = new ImageIcon("E:/gif/kiss.gif");
		for(int i=0;i<24;i++){
			buttons[i] = new JButton(icon);
			pane.add(buttons[i]);
		}
		setContentPane(pane);		//�������Ϊ���ݴ������
		show();		//ͬ	setVisible(true);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Icons icon = new Icons();
		
	}

}
