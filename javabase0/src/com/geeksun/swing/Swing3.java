package com.geeksun.swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Random;

import javax.swing.JFrame;

/**
 * @author ��־ǿ
 * Swing �¼�����ί�д������, ����Ϊ����ƶ��¼�������껭ͼ��
 * 2009��4��25
 */
public class Swing3 extends JFrame {
	int ox, oy;
	Random rnd = new Random();
	
	Swing3(String title){
		super(title);
		//�����ڹرգ�����ֹ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getContentPane().setBackground(Color.white);	//����ɫ
		
		//ע������¼�����
		addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent me){
				ox = me.getX();
				oy = me.getY();
			}
		});
		
		//ע������ƶ��¼�
		addMouseMotionListener(new MouseMotionAdapter(){
			public void mouseDragged(MouseEvent me){
				int x = me.getX();
				int y = me.getY();
				Graphics g = getGraphics();
				g.setColor(new Color(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
				g.drawLine(ox, oy, x, y);
				ox = x;
				oy = y;
			}
		});
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f = new Swing3("Swing");
		f.setSize(300, 300);
		f.setVisible(true);
	}

}
