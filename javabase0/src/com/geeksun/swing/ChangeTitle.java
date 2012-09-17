package com.geeksun.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author ��־ǿ
 * @comment: Ҫ���û��¼�������Ӧ������ʵ�ִ�����¼��Ľӿڣ����¼���������
 *  ����Ϊ�ı���⡣Title
 * @create at 2009-4-24
 */
public class ChangeTitle extends JFrame implements ActionListener {
	JButton b1 = new JButton("Rosencrantz");
	JButton b2 = new JButton("Guildenstern");
	
	public ChangeTitle(){
		super("Title");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		JPanel pane = new JPanel();
		pane.add(b1);
		pane.add(b2);
		setContentPane(pane);
		pack();
		setVisible(true);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new ChangeTitle();
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		Object temp = e.getActionCommand();
		if(source == b1)
			setTitle("Rosencrantz");
		else if(source == b2)
			setTitle("Guildenstern");
		repaint();
	}

}
