package com.base.awt.event;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

/**
 * @author 姜志强
 * @annotation: 文本事件是文本组件如TextArea或TextField发生改变时产生的事件。
 * @create at 2009-4-5
 */
public class TextEvent1 extends Frame {
	private static final long serialVersionUID = -249356272557230328L;
	Label text;
	Label length;
	TextField tf;
	
	public TextEvent1(String title){
		super(title);
		setLayout(new GridLayout(3, 1));
		
		//创建所需组件
		text = new Label("字符串");
		length = new Label("字符个数：0");
		tf = new TextField();
		
		//向框架添加组件
		add(text);
		add(length);
		add(tf);
		
		tf.addTextListener(new TextHandler());	//注册监听接口对象
	}
	
	public static void main(String[] args){
		TextEvent1 te = new TextEvent1("文本事件处理");
		te.setSize(200, 200);
		te.setVisible(true);
	}
	
	class TextHandler implements TextListener{
		//显示文本框文本发生改变时调用
		public void textValueChanged(TextEvent e) {	//处理文本事件的类
			//显示输入的字符串
			text.setText("字符串："+tf.getText());
			
			//显示输入的字符串的长度
			length.setText("字符数:"+tf.getText().length());
		}	
		
	}
	
}
