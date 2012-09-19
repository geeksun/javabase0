package com.base.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;

public class Layout3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Frame f = new Frame("使用 Panel 排列组件");
		
		Button b = new Button("NORTH");
		
		//向f 的北，西，中，东添加按钮
		Button be = new Button("EAST");
		Button bw = new Button("WEST");
		Button bs = new Button("SOUTH");
		Button bc = new Button("CENTER");
		
		f.add(b,BorderLayout.NORTH);	//将按钮b放置在北区
		f.add(be,BorderLayout.EAST);
		f.add(bw,BorderLayout.WEST);
		f.add(bs,BorderLayout.SOUTH);
		f.add(bc,BorderLayout.CENTER);
		
		//创建面板并向其中添加 3个按钮
		Panel p = new Panel();
		p.add(new Button("有"));
		p.add(new Button("7个"));
		p.add(new Button("按钮"));
		
		//将面板p 添加于窗口f 的南部区域
		f.add(p, BorderLayout.SOUTH);
		
		f.pack();
		f.setVisible(true);
	}

}
