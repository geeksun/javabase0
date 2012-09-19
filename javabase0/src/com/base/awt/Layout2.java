package com.base.awt;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;

/**
 * @author 姜志强
 *  Panel容器的缺省布局是FlowLayout,将组件按照加入的顺序从左到右排列
 */
public class Layout2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Frame f = new Frame("FlowLayout");
		Panel p = new Panel();
		
		//向面板添加5个按钮
		p.add(new Button("1"));
		p.add(new Button("2"));
		p.add(new Button("3"));
		p.add(new Button("4"));
		p.add(new Button("5"));
		
		f.add(p);	//将面板添加到框架窗口f中
		
		f.pack();	//x1 自动调整Frame的大小,使其可以显示其中所有的组件
		f.setVisible(true);
	}

}
