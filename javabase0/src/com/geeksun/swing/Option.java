package com.geeksun.swing;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 * @author 姜志强
 * @comment: 选项卡
 * @create at 2009-4-22
 */
public class Option extends JFrame {
	
	public Option(){
		super("Option 选项卡");
		//super.setSize(1300, 1200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel mainSettings = new JPanel();
		JPanel privacySettings = new JPanel();
		JPanel advancedSettings = new JPanel();
		JPanel emailSettings = new JPanel();
		JPanel securitySettings = new JPanel();
		JTabbedPane tabs = new JTabbedPane();
		tabs.addTab("Main", mainSettings);
		tabs.addTab("Advanced", advancedSettings);
		tabs.addTab("Privacy", privacySettings);
		tabs.addTab("Email", emailSettings);
		tabs.addTab("Security", securitySettings);
		
		setContentPane(tabs);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Option op = new Option();
		op.pack();
		op.setVisible(true);
	}

}
