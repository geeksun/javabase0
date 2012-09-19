package com.base.awt.event;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * @author 姜志强
 * @annotation: MouseEvent是用户使用鼠标在某个组件上进行某种动作时发生的事件。
 * 				MouseMotionListener用于处理与鼠标移动相关的事件。本例显示鼠标移动与鼠标被拖拽时的坐标。
 * @create at 2009-4-6
 */
public class MouseEvent2 extends Frame {
	Label mouseInfo;
	public MouseEvent2(String title){
		super(title);
		mouseInfo = new Label("");
		mouseInfo.setBackground(Color.yellow);
		add(mouseInfo, "North");
		
		//向框架（this）注册鼠标移动事件监听对象
		this.addMouseMotionListener(new MouseMotionHandler());
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MouseEvent2 me = new MouseEvent2("Mouse移动处理");
		me.setSize(200, 200);
		me.setVisible(true);
	}

	class MouseMotionHandler implements MouseMotionListener{

		//鼠标被按下时，移动鼠标时调用的方法
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			mouseInfo.setText("drag -> x: " + e.getX() + " y:" + e.getY());
		}

		//鼠标未被按下时，移动鼠标时调用的方法
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			mouseInfo.setText("move -> x: " + e.getX() + " y:" + e.getY());
		}
		
	}
}
