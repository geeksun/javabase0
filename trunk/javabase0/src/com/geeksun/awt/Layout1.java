package com.geeksun.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

/**
 * @author 姜志强
 * 布局管理器
 * Frame容器的默认布局是 BorderLayout，将容器空间分为东，南，西，北，中五个区域
 */
public class Layout1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Frame f = new Frame("BorderLayout");
		Button b = new Button("NORTH");
		
		//创建5个按钮
		Button be = new Button("EAST");
		Button bw = new Button("WEST");
		Button bs = new Button("SOUTH");
		Button bc = new Button("CENTER");
		
		f.add(b,BorderLayout.NORTH);	//将按钮b放置在北区
		f.add(be,BorderLayout.EAST);
		f.add(bw,BorderLayout.WEST);
		f.add(bs,BorderLayout.SOUTH);
		f.add(bc,BorderLayout.CENTER);
		
		f.setSize(170,150);
		f.setVisible(true);
	}

}
