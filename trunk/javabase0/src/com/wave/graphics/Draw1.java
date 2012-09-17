package com.wave.graphics;

import java.awt.Frame;
import java.awt.Graphics;

/**
 * @author 姜志强
 * @annotation: 绘制各种图形
 * @create at 2009-4-10
 */
public class Draw1 extends Frame {
	
	public Draw1(String title){
		super(title);
	}
	
	public void paint(Graphics g){
		g.drawLine(10, 30, 50, 50);			//画直线
		g.drawRect(60, 30, 50, 50);			//画矩形
		g.drawRoundRect(120, 30, 50, 50, 20, 20);	//画圆角矩形
		g.drawOval(10, 100, 70, 50);				//画椭圆
		g.drawArc(100, 100, 50, 50, 90, 100);		//画孤
		
		int[] x = new int[]{200, 240, 200, 220, 240};
		int[] y = new int[]{80, 80, 120, 60, 120};
		g.drawPolygon(x, y, 5);			//画多边形
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Frame f = new Draw1("画图形");
		f.setSize(300, 200);
		f.setVisible(true);
		
	}

}
