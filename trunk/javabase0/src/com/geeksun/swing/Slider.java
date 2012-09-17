package com.geeksun.swing;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;

/**
 * @author 姜志强
 * @serial 滑块：WellAdjusted.java 为滚动条
 * @create at 2009-4-22
 */
public class Slider extends JFrame {
	
	public Slider(){
		super("Slider 滑块");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//水平，最小值，最大值，和初始值的滑块
		JSlider pickNum = new JSlider(JSlider.HORIZONTAL, 0, 30, 5);
		pickNum.setMajorTickSpacing(10);	//主刻度线
		pickNum.setMinorTickSpacing(1);		//次刻度线
		pickNum.setPaintTicks(true);		//是否显示刻度线
		pickNum.setPaintLabels(true);		//是否显示数字标签
		JPanel pane = new JPanel();
		pane.add(pickNum);
		
		setContentPane(pane);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Slider frame = new Slider();
		frame.pack();
		frame.setVisible(true);
	}

}
