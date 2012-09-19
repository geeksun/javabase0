package com.base.awt.event;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author ��־ǿ
 * @annotation: MouseEvent���û�ʹ�������ĳ������Ͻ���ĳ�ֶ���ʱ�������¼���
 * @create at 2009-4-6
 */ 
public class MouseEvent1 extends Frame {

	Label mouseInfo;	//��ʾ�¼���Ϣ�ı�ǩ
	
	public MouseEvent1(String title){
		super(title);
		mouseInfo = new Label("");	
		mouseInfo.setBackground(Color.YELLOW);	//��ǩ����ɫ
		add(mouseInfo, "North");		//������ӱ�ǩ
		
		//���ܣ�this��ע������¼�����������
		this.addMouseListener(new MouseHandler());
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MouseEvent1 me = new MouseEvent1("Mouse�¼�����");
		me.setSize(200, 200);
		me.setVisible(true);
	}

	class MouseHandler implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			mouseInfo.setText(mouseInfo.getText() + " ���");
		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			mouseInfo.setText("����");
		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			mouseInfo.setText("�뿪");
		}

		public void mousePressed(MouseEvent e) {
			if(e.getButton() == e.BUTTON1) { 
				mouseInfo.setText("������");
			} else if(e.getButton() == e.BUTTON2) {
				mouseInfo.setText("����м�");
			} else if(e.getButton() == e.BUTTON3) {
				mouseInfo.setText("����Ҽ�");
			}
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			mouseInfo.setText("�ͷ�");
		}	
		
	}
}
