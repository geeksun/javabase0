package com.base.awt;

import java.awt.Frame;
import java.awt.Label;

public class Label1 {

	/**
	 * 标签，提供了显示某段文本的功能
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame f = new Frame("Label");
		Label l1 = new 	Label("Label 1");	// 创建标签，文本默认为左对齐
		Label l2 = new Label("Label 2", Label.RIGHT);	// 文本设定为右对齐
		
		//创建空标签（为其设定文本时，文本居中）
		Label l3 = new Label("", Label.CENTER);
		
		l3.setText(l1.getText() + l2.getText());	//将l3 的text -> " Label 1 Label 2"
		
		f.add(l1, "North");		//添加标签
		f.add(l2, "Center");
		f.add(l3, "South");
		
		f.setSize(200, 100);
		f.setVisible(true);
		
		
		
	}

}
