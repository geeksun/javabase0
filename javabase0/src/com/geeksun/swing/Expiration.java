package com.geeksun.swing;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author 姜志强
 * @annotation: 下拉框
 * @create at 2009-4-21
 */
public class Expiration extends JFrame {
	JComboBox monthBox = new JComboBox();
	JComboBox yearBox = new JComboBox();
	
	public Expiration(){
		super("Expiration Date");
		setSize(220, 90);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel pane = new JPanel();
		JLabel lab = new JLabel("Expiration Date:");
		pane.add(lab);
		for(int i=1;i<13;i++){
			monthBox.addItem("" + i);
		}
		
		for(int i=2000;i<2010;i++){
			yearBox.addItem("" + i);
		}
		
		pane.add(monthBox);
		pane.add(yearBox);
		setContentPane(pane);
		setVisible(true);
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Expiration exp = new Expiration();
		
	}

}
