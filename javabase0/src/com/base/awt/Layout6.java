package com.base.awt;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;

public class Layout6 {

	/**
	 * GridLayout 把容器空间分为网格区域
	 * @param args
	 */
	public static void main(String[] args) {
		Frame f = new Frame("GridLayout");
		f.setLayout(new GridLayout(3, 2));
		
		//添加按钮
		f.add(new Button("[1, 1]"));
		f.add(new Button("[1, 2]"));
		f.add(new Button("[2, 1]"));
		f.add(new Button("[2, 2]"));
		f.add(new Button("[3, 1]"));
		f.add(new Button("[3, 2]"));
		
		f.setSize(200, 160);
		f.setVisible(true);
	}

}
