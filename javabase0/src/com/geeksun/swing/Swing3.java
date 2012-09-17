package com.geeksun.swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Random;

import javax.swing.JFrame;

/**
 * @author 姜志强
 * Swing 事件处理：委托处理机制, 此例为鼠标移动事件：用鼠标画图。
 * 2009－4－25
 */
public class Swing3 extends JFrame {
	int ox, oy;
	Random rnd = new Random();
	
	Swing3(String title){
		super(title);
		//若窗口关闭，则终止程序
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getContentPane().setBackground(Color.white);	//背景色
		
		//注册鼠标事件监听
		addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent me){
				ox = me.getX();
				oy = me.getY();
			}
		});
		
		//注册鼠标移动事件
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
