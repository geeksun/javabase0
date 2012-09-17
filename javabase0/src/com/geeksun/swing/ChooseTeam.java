package com.geeksun.swing;

import javax.swing.ButtonGroup;
import javax.swing.JFrame; 
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * @author 姜志强
 * @annotation: 复选框和单选按钮
 * @create at 2009-4-21
 */
public class ChooseTeam extends JFrame {
	JRadioButton[] teams = new JRadioButton[4];
	
	public ChooseTeam(){
		super("Choose Team");
		setSize(140, 190);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		teams[0] = new JRadioButton("Colorado");
		teams[1] = new JRadioButton("Dallas", true);
		teams[2] = new JRadioButton("New Jersey", true);
		teams[3] = new JRadioButton("Philadephia");
		JPanel pane = new JPanel();
		ButtonGroup group = new ButtonGroup();
		for(int i=0;i<teams.length;i++){
			group.add(teams[i]);
			pane.add(teams[i]);
		}
		setContentPane(pane);
		setVisible(true);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ChooseTeam choose = new ChooseTeam();
		
	}

}
