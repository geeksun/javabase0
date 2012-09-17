package com.geeksun.awt.event;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author 姜志强
 * @annotation: KeyEvent键盘事件，是与键盘有关的事件。继承了输入事件类（InputEvent）.
 * @create at 2009-4-6
 */
public class KeyEvent1 extends Frame {
	Label keyChar;		//显示keyChar的标签
	Label keyCode;		//显示keyCode的标签
	Label keyText;		//显示keyText的标签
	Label actionKey;	//显示是否为 actionKey 的标签
	TextField tf;		//keyEvent的事件源
	
	public KeyEvent1(String title){
		super(title);
		setLayout(new GridLayout(5,1));
		
		keyChar = new Label("keyChar:");	//初始化标签与文本框
		keyCode = new Label("keyCode:");
		keyText = new Label("keyText:");
		actionKey = new Label("actionKey:");
		tf = new TextField();
		
		add(keyChar);
		add(keyCode);
		add(keyText);
		add(actionKey);
		add(tf);
		
		tf.addKeyListener(new KeyHandler());	//注册监听者对象 
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KeyEvent1 ke = new KeyEvent1("Key事件处理");
		ke.setSize(200, 200);
		ke.setVisible(true);
	}

	/**
	 * @author 姜志强
	 * @annotation: 定义键盘事件处理类
	 */
	class KeyHandler implements KeyListener{

		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			keyCode.setText("keyCode:"+e.getKeyCode());
			keyText.setText("keyText:"+e.getKeyText(e.getKeyCode()));
			actionKey.setText("actionKey:"+e.isActionKey());
			
		}

		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			keyChar.setText("keyChar:"+e.getKeyChar());
		}
		
	}
}
