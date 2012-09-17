package com.geeksun.awt;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.ScrollPane;

/**
 * @author 姜志强
 * @annotation: 滚动面板，兼有 Panel 与 Scrollbar 的功能
 */
public class ScrollPane1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Frame f = new Frame("ScrollPan");
		ScrollPane sp = new ScrollPane(1);	//总是显示滚动条
		Panel p = new Panel();	//要包含在sp 中的面板
		
		p.setLayout(new GridLayout(10, 2));
		p.setBackground(Color.BLUE);	
		p.setForeground(Color.white);	//前景色
		sp.setBounds(10, 30, 180, 160);	//sp 的位置
		f.setLayout(null);	//无布局
		f.setSize(200, 100);
		
		for(int i=1;i<=10;i++){		//创建10个按钮与标签，并添加至面板中
			p.add(new Label("第"+i+"个标签"));
			p.add(new Button("第"+i+"个按钮"));
			
		}
		
		sp.add(p);	//将面板添加至 ScrollPane 中
		f.add(sp);	//将ScrollPane 添加至窗口中
		
		f.setVisible(true);
	}

}
