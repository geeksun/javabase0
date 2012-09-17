package com.geeksun.awt.event;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author 姜志强
 * @annotation: KeyEvent键盘事件，是与键盘有关的事件。继承了输入事件类（InputEvent）.
 * 				KeyListenter接口的适配器类是 KeyAdpter.
 * @create at 2009-4-6
 */
public class KeyEvent2 extends Frame {
	Label info;
	TextField tf;
	
	public KeyEvent2(String title){
		super(title);
		setLayout(new GridLayout(2,1));
		
		info = new Label("key键信息：");	//显示Key信息的标签
		tf = new TextField();		//keyEvent事件源TextField
		
		add(info);
		add(tf);
		
		tf.addKeyListener(new KeyHandler());	//注册监听对象
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KeyEvent2 ke = new KeyEvent2("Key事件处理");
		ke.setSize(200, 200);
		ke.setVisible(true);
	}

	class KeyHandler extends KeyAdapter{	//继承 KeyAdapter 类
		public void keyPressed(KeyEvent e){
			String k = "";					//记录Key信息的变量
			if(e.isShiftDown())	k = "Shift + ";
			if(e.isAltDown())	k = "Alt + ";
			if(e.isControlDown())	k = "Ctrl + ";
			k += e.getKeyText(e.getKeyCode());
			info.setText("Key键信息：" + k);
		}
	}
}
