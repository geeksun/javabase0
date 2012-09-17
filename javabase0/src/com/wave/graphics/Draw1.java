package com.wave.graphics;

import java.awt.Frame;
import java.awt.Graphics;

/**
 * @author ��־ǿ
 * @annotation: ���Ƹ���ͼ��
 * @create at 2009-4-10
 */
public class Draw1 extends Frame {
	
	public Draw1(String title){
		super(title);
	}
	
	public void paint(Graphics g){
		g.drawLine(10, 30, 50, 50);			//��ֱ��
		g.drawRect(60, 30, 50, 50);			//������
		g.drawRoundRect(120, 30, 50, 50, 20, 20);	//��Բ�Ǿ���
		g.drawOval(10, 100, 70, 50);				//����Բ
		g.drawArc(100, 100, 50, 50, 90, 100);		//����
		
		int[] x = new int[]{200, 240, 200, 220, 240};
		int[] y = new int[]{80, 80, 120, 60, 120};
		g.drawPolygon(x, y, 5);			//�������
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Frame f = new Draw1("��ͼ��");
		f.setSize(300, 200);
		f.setVisible(true);
		
	}

}
