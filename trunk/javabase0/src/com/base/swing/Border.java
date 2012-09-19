package com.base.swing;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author 姜志强
 * @comment: 边框布局
 * @create at 2009-4-23
 */
public class Border extends JFrame {
	JButton a = new JButton("North");
	JButton b = new JButton("South");
	JButton c = new JButton("East");
	JButton d = new JButton("West");
	JButton e = new JButton("Center");
	
	Border(){
		super("Border");
		setSize(240, 280);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		pane.add("North",a);
		pane.add("South",b);
		pane.add("East",c);
		pane.add("West",d);
		//将组件加入到面板中
		pane.add("Center",e);
		
		setContentPane(pane);
		setVisible(true);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new Border();
		
	}

}
