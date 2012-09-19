package com.base.awt.event;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author 姜志强
 * @annotation: MouseEvent是用户使用鼠标在某个组件上进行某种动作时发生的事件。
 * @create at 2009-4-6
 */ 
public class MouseEvent1 extends Frame {

	Label mouseInfo;	//显示事件信息的标签
	
	public MouseEvent1(String title){
		super(title);
		mouseInfo = new Label("");	
		mouseInfo.setBackground(Color.YELLOW);	//标签背景色
		add(mouseInfo, "North");		//向框架添加标签
		
		//向框架（this）注册鼠标事件，监听对象
		this.addMouseListener(new MouseHandler());
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MouseEvent1 me = new MouseEvent1("Mouse事件处理");
		me.setSize(200, 200);
		me.setVisible(true);
	}

	class MouseHandler implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			mouseInfo.setText(mouseInfo.getText() + " 点击");
		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			mouseInfo.setText("进入");
		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			mouseInfo.setText("离开");
		}

		public void mousePressed(MouseEvent e) {
			if(e.getButton() == e.BUTTON1) { 
				mouseInfo.setText("点击左键");
			} else if(e.getButton() == e.BUTTON2) {
				mouseInfo.setText("点击中键");
			} else if(e.getButton() == e.BUTTON3) {
				mouseInfo.setText("点击右键");
			}
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			mouseInfo.setText("释放");
		}	
		
	}
}
