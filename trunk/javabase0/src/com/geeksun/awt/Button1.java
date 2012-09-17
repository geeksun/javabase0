package com.geeksun.awt;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button1 implements ActionListener{		//处理ActionEvent
	int count = 0;				//record button click count
	Button button = new Button("增加");		//button object
	Label label = new Label("0");	//show click count
	Frame frame = new Frame("Button");
	
	public Button1(){
		button.addActionListener(this);	//注册动作事件监听器
		frame.add(button, "Center");
		frame.add(label, "South");
		frame.pack();
		
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {		//点击按钮时被调用
		count++;
		label.setText(String.valueOf(count));
	}
	
	/**
	 *  Button 用来响应用户的 click 动作，当用户点击时，系统自动执行与该按钮相联系的程序，从而完成预先指定的功能。
	 * @param args
	 */
	public static void main(String[] args) {
		Button1 but = new Button1();
		
	}


}
