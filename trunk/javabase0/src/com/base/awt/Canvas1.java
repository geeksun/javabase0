package com.base.awt;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.util.Random;

public class Canvas1 extends Canvas{

	/**
	 * @param args
	 * ���������ڻ���ͼ�λ�ͼƬ,����
	 */
	public void paint(Graphics g){
		Random rnd = new Random();
		for(int i=1;i<=100;i++){
			//����趨��ɫ��nextInt(256)������0��255֮��������
			g.setColor(new Color(rnd.nextInt(256),
			rnd.nextInt(256), rnd.nextInt(256)));
			
			//����ֱ�ߣ�λ�����
			g.drawLine(rnd.nextInt(200), rnd.nextInt(200), rnd.nextInt(200), rnd.nextInt(200));
			
		}
	}
	public static void main(String[] args) {
		Frame f = new Frame("Canvas");
		Canvas1 c = new Canvas1();	//��������
		f.add(c);	//�� frame ����ӻ���
		f.setSize(200, 200);
		f.setVisible(true);
	}

}
