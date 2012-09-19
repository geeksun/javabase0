package com.base.awt;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

public class Layout4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Frame f = new Frame("改变 Layout");
		
		//将窗口f 布局设定为 FlowLayout 布局
		f.setLayout(new FlowLayout());
		
		f.add(new Button("使用"));
		f.add(new Button("setLayout()"));
		f.add(new Button("改变"));
		f.add(new Button("窗口布局"));
		
		f.pack();
		f.setVisible(true);
		
	}

}
