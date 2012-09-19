package com.base.swing;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author 姜志强
 * @comment： 顺序布局:布局管理器
 * @create at 2009-4-23
 */
public class Alphabet extends JFrame {
	JButton a = new JButton("Alibi");
	JButton b = new JButton("Burglar");
	JButton c = new JButton("Corpse");
	JButton d = new JButton("Deadbeat");
	JButton e = new JButton("Evidence");
	JButton f = new JButton("Fugitive");
	
	public Alphabet(){
		super("Alphabet");
		setSize(360, 120);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel pane = new JPanel();
		FlowLayout lm = new FlowLayout(FlowLayout.LEFT);
		pane.setLayout(lm);
		pane.add(a);
		pane.add(b);
		pane.add(c);
		pane.add(d);
		pane.add(e);
		pane.add(f);
		
		
		setContentPane(pane);
		setVisible(true);
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new Alphabet();
		
	}

}
