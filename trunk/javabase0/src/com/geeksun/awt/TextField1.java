package com.geeksun.awt;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;

/**
 * @since jdk 1.5
 * @author 姜志强
 * @create at 2009-3-26
 * @define 单行文本框
 */
public class TextField1 {
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Frame frame = new Frame("登录对话框");	//创建 Frame
		TextField id = new TextField(10);	//创建一个单行文本框，用于接受用户 ID 输入
		TextField pw= new TextField(10);	
		Button login = new Button("登录");	//登录按钮
		Button cancel = new Button("取消");
		
		pw.setEchoChar('*');	//指定密码显示字符为 '*'
		
		frame.setLayout(new GridLayout(3, 2));	//指定布局管理器
		
		//向 frame 顺序添加组件
		frame.add(new Label("ID:", Label.CENTER));
		frame.add(id);
		frame.add(new Label("密码：", Label.CENTER));
		frame.add(pw);
		frame.add(login);
		frame.add(cancel);
		
		frame.pack();
		frame.setVisible(true);
	}

}
