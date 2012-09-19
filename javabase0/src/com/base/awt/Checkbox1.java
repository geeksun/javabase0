package com.base.awt;

import java.awt.Checkbox;
import java.awt.FlowLayout;
import java.awt.Frame;

/**
 * @author 姜志强
 *  复选框
 */
public class Checkbox1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Frame f = new Frame("Checkbox");
		
		Checkbox cb1 = new Checkbox("直线", true);	//初始状态为true
		Checkbox cb2 = new Checkbox("曲线", false);	//初始状态为false
		Checkbox cb3 = new Checkbox("下划线", true);
		
		f.add(cb1);
		f.add(cb2);
		f.add(cb3);
		
		f.setLayout(new FlowLayout());	//左右排列的布局管理器
		
		f.setSize(200, 70);
		f.setVisible(true);
	}

}
