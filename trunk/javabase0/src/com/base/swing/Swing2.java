package com.base.swing;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * @author 姜志强
 * Swing 组件大全
 * 2009-4-25
 */
public class Swing2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Swing");
		//若窗口关闭，则终止程序
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//获取对 contentPane 的引用
		Container cp = frame.getContentPane();	//获取contentPane对象
		cp.setLayout(new FlowLayout());		//设定 Layout
		
		cp.add(new JButton("按钮"));
		
		//添加带图片的按钮
		ImageIcon saveIcon = new ImageIcon("E:/gif/kiss.gif");
		cp.add(new JButton(saveIcon));
		
		//添加JTextField
		JTextField tf = new JTextField("Hi~~~~~");
		tf.setBorder(new TitledBorder("内容"));
		cp.add(tf);
		
		cp.add(new JSlider());		//添加 JSlider 组件
		
		//添加 JProgressBar 组件
		JProgressBar pb = new JProgressBar(JProgressBar.HORIZONTAL);
		pb.setStringPainted(true);
		pb.setValue(50);
		cp.add(pb);
		
		//添加 List
		JList list = new JList(new String[]{"Java", "C++"});
		cp.add(list);
		
		//添加 JcomboBox
		JComboBox combo = new JComboBox(new String[]{"Thinking", "Java"});
		cp.add(combo);
		
		frame.setSize(200, 200);
		frame.setVisible(true);
		
	  
		
	}

}
