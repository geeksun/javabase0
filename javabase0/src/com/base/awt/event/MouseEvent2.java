package com.base.awt.event;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * @author ��־ǿ
 * @annotation: MouseEvent���û�ʹ�������ĳ������Ͻ���ĳ�ֶ���ʱ�������¼���
 * 				MouseMotionListener���ڴ���������ƶ���ص��¼���������ʾ����ƶ�����걻��קʱ�����ꡣ
 * @create at 2009-4-6
 */
public class MouseEvent2 extends Frame {
	Label mouseInfo;
	public MouseEvent2(String title){
		super(title);
		mouseInfo = new Label("");
		mouseInfo.setBackground(Color.yellow);
		add(mouseInfo, "North");
		
		//���ܣ�this��ע������ƶ��¼���������
		this.addMouseMotionListener(new MouseMotionHandler());
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MouseEvent2 me = new MouseEvent2("Mouse�ƶ�����");
		me.setSize(200, 200);
		me.setVisible(true);
	}

	class MouseMotionHandler implements MouseMotionListener{

		//��걻����ʱ���ƶ����ʱ���õķ���
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			mouseInfo.setText("drag -> x: " + e.getX() + " y:" + e.getY());
		}

		//���δ������ʱ���ƶ����ʱ���õķ���
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			mouseInfo.setText("move -> x: " + e.getX() + " y:" + e.getY());
		}
		
	}
}
