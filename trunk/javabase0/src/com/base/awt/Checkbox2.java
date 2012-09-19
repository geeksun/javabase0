package com.base.awt;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.Frame;

/**
 * @author 姜志强
 *  单选按钮
 */
public class Checkbox2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Frame f = new Frame("CheckboxGroup");
		CheckboxGroup cbg = new CheckboxGroup();	//复选框组
		
		//cb1,cb2,cb3 属于复选框组 cbg
		Checkbox cb1 = new Checkbox("红色", true, cbg);	//将某个 Checkbox 放入某个组中
		Checkbox cb2 = new Checkbox("黄色", false, cbg);
		Checkbox cb3 = new Checkbox("蓝色", false, cbg);
		
		f.add(cb1);
		f.add(cb2);
		f.add(cb3);
		
		f.setLayout(new FlowLayout());
		
		f.setSize(200, 70);
		f.setVisible(true);
		
		System.err.println(cb1.getState());	//获取选取状态 ，还有 setState(boolean state)可以设置状态
	}

}
