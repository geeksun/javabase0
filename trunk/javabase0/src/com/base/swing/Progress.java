package com.base.swing;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

/**
 * @author ��־ǿ
 * @comment: ������
 * @create at 2009-4-22
 */
public class Progress extends JFrame {
	JProgressBar current;
	JTextArea out;
	JButton find;
	Thread runner;
	int num = 0;
	
	public Progress(){
		super("Progress ������");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel pane = new JPanel();
		pane.setLayout(new FlowLayout());
		//ָ������Сֵ�����ֵ�Ľ�����
		current = new JProgressBar(0, 2000);
		current.setValue(0);
		current.setStringPainted(true);
		pane.add(current);
		setContentPane(pane);
	}
	
	public void iterate(){
		while(num<2000){
			//���½�������ֵ
			current.setValue(num);
			try{
				Thread.sleep(1000);
				
			}catch(Exception e){
				e.printStackTrace();
			}
			num += 95;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Progress frame = new Progress();
		frame.pack();
		frame.setVisible(true);
		frame.iterate();
	}

}
