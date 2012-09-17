package com.geeksun.awt;

import java.awt.Button;
import java.awt.Frame;

public class Awt4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame f = new Frame("容器");//创建Frame
		Button b = new Button("点击");//创建按钮
		
		f.add(b);	//将按钮b添加至框架窗口中
		
		f.setSize(200, 100);
		f.setVisible(true);
	}

}
