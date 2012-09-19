package com.base.awt;

import java.awt.Frame;

/**
 * @author 姜志强
 * awt：abstract window toolkit,抽象窗口工具集
 */
public class Awt1 {
	public static void main(String[] args) {
		//Frame f = new Frame();		//创建框架窗口
		Frame f = new Frame("Thinking in java");		//创建框架窗口
		f.setSize(200, 100);		//设定框架窗口的大小
		f.setVisible(true);			//显示框架窗口
	}

}
