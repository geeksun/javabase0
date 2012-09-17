package com.geeksun.swing;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

/**
 * @author 姜志强
 * @annotation: 使用监听 
 * @create at 2009-4-20
 */
public class ExitFrame extends JFrame {
	
	public ExitFrame(){
		super("Frame Title");
		setSize(300, 100);
		ExitWindow exit = new ExitWindow();
		addWindowListener(exit);
		setVisible(true);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExitFrame ef = new ExitFrame();
		
	}

}
class ExitWindow extends WindowAdapter{
	public void windowClosing(WindowEvent e){
			System.exit(0);
	}
}