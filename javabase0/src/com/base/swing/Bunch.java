package com.base.swing;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author 姜志强
 * @comment： 网格布局:布局管理器
 * @create at 2009-4-23
 */
public class Bunch extends JFrame {
	JButton a = new JButton("Alibi");
	JButton b = new JButton("Burglar");
	JButton c = new JButton("Corpse");
	JButton d = new JButton("Deadbeat");
	JButton e = new JButton("Evidence");
	JButton f = new JButton("Fugitive");
	JButton g = new JButton("Gird");
	JButton h = new JButton("Hour");
	JButton j = new JButton("Jeep");
	
	Bunch(){
		super("Bunch");
		setSize(260, 260);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel pane = new JPanel();
		GridLayout lm = new GridLayout(3,3,10,10);
		pane.setLayout(lm);
		pane.add(a);
		pane.add(b);
		pane.add(c);
		pane.add(d);
		pane.add(e);
		pane.add(f);
		pane.add(g);
		pane.add(h);
		pane.add(j);
		
		setContentPane(pane);
		setVisible(true);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new Bunch();
		
	}

}
