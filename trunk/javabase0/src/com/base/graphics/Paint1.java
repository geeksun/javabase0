package com.base.graphics;

import java.awt.Frame;
import java.awt.Graphics;

/**
 * @author 姜志强
 * @annotation: Java图形
 * @create at 2009-4-9
 */
public class Paint1 extends Frame {

	public Paint1(String title){
		super(title);
	}
	
	/**
	 * @see 组件绘制自身时调用的方法，当组件需要绘制自身时，此方法被自动调用。
	 */
	public void paint(Graphics g){	//g：图形上下文（graphics context）
		g.drawLine(10, 30, 50, 50);			//画线
		g.drawRect(60, 30, 50, 50);			//画四边形
		g.drawString("Hello", 120, 50);		//绘制字符串
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Paint1 p = new Paint1("paint");
		p.setSize(200, 100);
		p.setVisible(true);			//显示Frame时，paint()方法将会被调用
		
	}

}
