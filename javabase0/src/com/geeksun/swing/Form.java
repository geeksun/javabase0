package com.geeksun.swing;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author 姜志强
 * @annotation: 一个完整的表单
 * @create at 2009-4-21
 */
public class Form extends JFrame {
	JTextField usrname = new JTextField(15);
	JPasswordField password = new JPasswordField(15);
	JTextArea comments = new JTextArea(4, 15);
	
	public Form(){
		super("Feedback Form");
		setSize(260, 160);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel pane = new JPanel();
		JLabel ulabel = new JLabel("username:");
		JLabel plabel = new JLabel("password:");
		JLabel clabel = new JLabel("comments:");
		comments.setLineWrap(true);				//自动换行
		comments.setWrapStyleWord(true);		//将当前单词换到下一行：如何换行
		pane.add(ulabel);
		pane.add(usrname);
		pane.add(plabel);
		pane.add(password);
		pane.add(clabel);
		pane.add(comments);
		setContentPane(pane);
		
		setVisible(true);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Form input = new Form();
		
	}

}
