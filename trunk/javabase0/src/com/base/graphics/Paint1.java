package com.base.graphics;

import java.awt.Frame;
import java.awt.Graphics;

/**
 * @author ��־ǿ
 * @annotation: Javaͼ��
 * @create at 2009-4-9
 */
public class Paint1 extends Frame {

	public Paint1(String title){
		super(title);
	}
	
	/**
	 * @see �����������ʱ���õķ������������Ҫ��������ʱ���˷������Զ����á�
	 */
	public void paint(Graphics g){	//g��ͼ�������ģ�graphics context��
		g.drawLine(10, 30, 50, 50);			//����
		g.drawRect(60, 30, 50, 50);			//���ı���
		g.drawString("Hello", 120, 50);		//�����ַ���
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Paint1 p = new Paint1("paint");
		p.setSize(200, 100);
		p.setVisible(true);			//��ʾFrameʱ��paint()�������ᱻ����
		
	}

}
