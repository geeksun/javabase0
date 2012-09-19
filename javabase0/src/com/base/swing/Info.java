package com.base.swing;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * @author 姜志强
 * @annotation: 对话框应用,使用对话框从用户那里获取信息，然后将这些信息放置在应用程序主窗口的文本框中。
 * @create at 2009-4-21
 */
public class Info extends JFrame {
	private JLabel titleLabel = new JLabel("Title:",  SwingConstants.RIGHT);
	private JTextField title;
	private JLabel addressLabel = new JLabel("Address:",  SwingConstants.RIGHT);
	private JTextField address;
	private JLabel typeLabel = new JLabel("Type:",  SwingConstants.RIGHT);
	private JTextField type;
	
	public Info(){
		super("Site Information");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLookAndFeel();
		
		//Site name
		String responsel = JOptionPane.showInputDialog(null, "Enter the site title:");
		title = new JTextField(responsel, 20);
		
		//Site address
		String response2 = JOptionPane.showInputDialog(null, "Enter the site address:");
		address = new JTextField(response2, 20);
		
		//Site type
		String[] choices = {"Personal" ,"Commercial", "Unknown"};
		int response3 = JOptionPane.showOptionDialog
		(
				null, 
				"What type of site is it?", 
				"Site Type", 
				0, 
				JOptionPane.QUESTION_MESSAGE, 
				null, 
				choices, 
				choices[0]
		 );
		type = new JTextField(choices[response3], 20);
		
		JPanel pane = new JPanel();
		pane.setLayout(new GridLayout(3, 2));
		pane.add(titleLabel);
		pane.add(title);
		pane.add(addressLabel);
		pane.add(address);
		pane.add(typeLabel);
		pane.add(type);
		
		setContentPane(pane);
		pack();
		setLookAndFeel();
		setVisible(true);
		
	}
	
	/**
	 *  设置看和感觉:外观
	 */
	private void setLookAndFeel(){
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			SwingUtilities.updateComponentTreeUI(this);
		}catch(Exception e){
			System.out.println("Couldn't use the system look and feel:" + e);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Info frame = new Info();
	}

}
