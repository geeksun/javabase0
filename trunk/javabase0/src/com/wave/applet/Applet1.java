package com.wave.applet;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

/**
 * @author 姜志强
 * @annotation: Web 浏览器运行的 java 应用小程序。
 */
public class Applet1 extends Applet {
	
	public void paint(Graphics g){
		this.setBackground(Color.red);
		g.drawString("Applet的世界...", 20, 50);
		
	}

}
