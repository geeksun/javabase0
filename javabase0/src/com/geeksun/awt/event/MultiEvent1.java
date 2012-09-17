package com.geeksun.awt.event;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

/**
 * @author 姜志强
 * @annotation: 多事件处理
 * @create at 2009-4-6
 */
public class MultiEvent1 extends Frame implements ActionListener, TextListener {
	Label action = new Label();			//处理动作事件时使用的标签
	Label text = new Label();			//处理事件时使用的标签
	TextField tf = new TextField(20);	//产生多事件的单行文本框
	
	public MultiEvent1(String title){
		super(title);
		action.setBackground(Color.GREEN);
		text.setBackground(Color.PINK);

		add(action, "North");
		add(text, "Center");
		add(tf, "South");
		
		tf.addActionListener(this);		//向tf注册动作事件监听对象
		tf.addTextListener(this);		//向tf 注册文本事件监听对象
	}
	
	/**
	 * @annotation: press Enter Key touch actionEvent(动作事件)
	 */
	public void actionPerformed(ActionEvent e) {	//实现ActionListener接口
		action.setText(tf.getText());
	}

	public void textValueChanged(TextEvent e) {		//实现TextListener接口
		text.setText(tf.getText());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Frame f = new MultiEvent1("多事件处理");
		f.pack();
		f.setVisible(true);
	}

}
