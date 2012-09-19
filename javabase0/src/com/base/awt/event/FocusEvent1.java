package com.base.awt.event;

import java.awt.Button;
import java.awt.Frame;
import java.awt.List;
import java.awt.TextField;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * @author 姜志强
 * @annotation: 焦点事件：
 * @create at 2009-4-6
 */
public class FocusEvent1 extends Frame implements FocusListener {
	List fInfo = new List(10);					//显示焦点变化的列表
	TextField tf = new TextField("");			//FocusEvent事件源
	Button button = new Button("确认");			//无用的按钮
	
	public FocusEvent1(String title){
		super(title);
		add(fInfo, "North");
		add(tf, "Center");
		add(button, "South");
		tf.addFocusListener(this);				//向 tf 注册焦点事件监听器
	}
	
	/**
	 * @annotation: 获得焦点时被调用
	 */
	public void focusGained(FocusEvent e) {
		if(e.isTemporary())	fInfo.add("暂时性获得");
		else	fInfo.add("长久性获得");
	}

	/**
	 * @annotation: 失去焦点时被调用
	 */
	public void focusLost(FocusEvent e) {
		if(e.isTemporary()) fInfo.add("暂时性失去");
		else	fInfo.add("长久性失去");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FocusEvent1 fe = new FocusEvent1("FocusEvent 事件处理");
		fe.pack();				//自动调整显示区的大小
		fe.setVisible(true);
	}

}
