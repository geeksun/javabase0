package com.geeksun.awt;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;

/**
 * @author 姜志强
 * Window类与Panel类都继承了Container类，区别在于：
 * Window：可以独立运行的容器
 * Panel：只能被包含于其他容器而使用的容器，也是一种容器
 * Frame继承了Window类，可以独立运行
 */
public class Awt5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame f = new Frame("Panel 与 Window");
		
		//创建2个按钮
		Button b1 = new Button("确认");
		Button b2 = new Button("取消");
		
		Panel p = new Panel();	//创建面板
		p.setBackground(new Color(200,200,0));//设定面板的p的背景色为黄色
		
		p.add(b1);	//向面板p中添加按钮b1
		p.add(b2);	//向面板p中添加按钮b2
		f.add(p);	//向f中添加面板p
		
		f.setSize(200, 100);
		f.setVisible(true);
	}

}
