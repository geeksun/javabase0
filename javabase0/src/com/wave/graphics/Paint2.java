package com.wave.graphics;

import java.awt.Frame;
import java.awt.Graphics;

public class Paint2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Frame f = new Frame("paint");
		f.setSize(200, 100);
		f.setVisible(true);		//��ʾ Frame
		
		Graphics g = f.getGraphics();	//��ȡ Frame �� Graphics ����
		g.drawLine(10, 30, 50, 50);
		g.drawRect(60, 30, 50, 50);
		g.drawString("Hello", 120, 50);
		
		
		
	}

}
