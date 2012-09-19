package com.base.swing;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author 姜志强
 * @comment: 选项事件,组件的选项被选中时激发的事件。
 * @create at 2009-4-24
 */
public class SelectItem extends JFrame implements ItemListener {
	BorderLayout bord = new BorderLayout();
	JTextField result = new JTextField(27);
	JComboBox pick = new JComboBox();
	
	public SelectItem(){
		super("Select Item");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pick.addItemListener(this);
		pick.addItem("Navigator");
		pick.addItem("Internet Explorer");
		pick.addItem("Opera");
		pick.setEditable(false);
		JPanel pane = new JPanel();
		pane.setLayout(bord);
		pane.add(result, "South");
		pane.add(pick, "Center");
		setContentPane(pane);
		pack();
		setVisible(true);		
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new SelectItem();
	}


	public void itemStateChanged(ItemEvent e) {
		Object source = e.getSource();
		if(source == pick){
			Object newPick = e.getItem();
			result.setText(newPick.toString() + " is the selection.");
		}
	}

}
