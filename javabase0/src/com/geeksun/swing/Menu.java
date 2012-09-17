package com.geeksun.swing;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * @author 姜志强
 * @comment: 菜单
 * @create at 2009-4-22
 */
public class Menu extends JFrame {
	
	public Menu(){
		super("Menu 菜单");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuItem j1 = new JMenuItem("Open");
		JMenuItem j2 = new JMenuItem("Save");
		JMenuItem j3 = new JMenuItem("Save as Template");
		JMenuItem j4 = new JMenuItem("Page Setup");
		JMenuItem j5 = new JMenuItem("Print");
		JMenuItem j6 = new JMenuItem("Use as Default Message Style");
		JMenuItem j7 = new JMenuItem("Close");
		JMenu m1 = new JMenu("File");
		m1.add(j1);
		m1.add(j2);
		m1.add(j3);
		m1.addSeparator();		
		m1.add(j4);
		m1.add(j5);
		m1.addSeparator();
		m1.add(j6);
		m1.addSeparator();	
		m1.add(j7);
		
		JMenuBar bar = new JMenuBar();
		bar.add(m1);
		
		/*JTextArea edit = new JTextArea(8, 40);
		JScrollPane scroll = new JScrollPane(edit);
		JPanel pane = new JPanel();
		BorderLayout bord = new BorderLayout();
		pane.setLayout(bord);
		pane.add("North", bar);
		pane.add("Center", scroll);*/
		setContentPane(bar);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Menu frame = new Menu();
		frame.pack();
		frame.setVisible(true);
	}

}
