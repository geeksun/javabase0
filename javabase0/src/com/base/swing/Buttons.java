package com.base.swing;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author ��־ǿ
 * @annotation: ������������뵽������
 * @create at 2009-4-21
 */
public class Buttons extends JFrame {
	JButton abort = new JButton("Abort");
	JButton retry = new JButton("Retry");
	JButton fail = new JButton("Fail");
	
	public Buttons(){
		super("Buttons");
		setSize(180, 140);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//��ܱ��ر�ʱ�˳�����
		JPanel pane = new JPanel();		//Swing�����������
		pane.add(abort);
		pane.add(retry);
		pane.add(fail);
		setContentPane(pane);		//�������Ϊ���ݴ������
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Buttons rb = new Buttons();
		rb.setVisible(true);		//��ʾ
	}

}
