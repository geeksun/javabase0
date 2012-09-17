package com.geeksun.awt;

import java.awt.Button;
import java.awt.Frame;

public class Layout5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Frame f = new Frame("改变 Layout");
		
		//不应用任何布局
		f.setLayout(null);
		
		Button ba = new Button("未使用");
		Button bb = new Button("任何布局");
		
		//必须自行设定组件的大小与位置
		ba.setBounds(20, 50, 100, 40);
		bb.setBounds(50, 100, 100, 40);
		
		f.add(ba);
		f.add(bb);
		
		f.setSize(200, 160);
		f.setVisible(true);
		
	}

}
