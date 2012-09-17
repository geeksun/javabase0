package com.geeksun.awt.event;

import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class ActionEvent2 extends Frame implements ActionListener {
	TextField tf ;

	public ActionEvent2(String title){
		super(title);	//添加框架窗口标题
		tf = new TextField(20);
		
		//this 是一个 Frame，也是动作事件监听者对象
		tf.addActionListener(this);
		
		add(tf);	//向框架添加按钮
	}
	public void actionPerformed(ActionEvent e) {	//override
		//若事件源对象为 TextField 对象
		if(e.getSource() instanceof TextField){
			TextField  tx = (TextField) e.getSource();	//获取事件源对象
			System.out.println(tx.getText());			//输出 tx 中的字符串
			tx.setText("");				//清空 tx 中的内容
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ActionEvent2 ae = new ActionEvent2("动作事件处理");
		//Frame aw = new ActionEvent2("动作事件处理2");
		ae.pack();
		
		ae.setVisible(true);
	}

}
