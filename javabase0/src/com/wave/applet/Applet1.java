package com.wave.applet;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

/**
 * @author ��־ǿ
 * @annotation: Web ��������е� java Ӧ��С����
 */
public class Applet1 extends Applet {
	
	public void paint(Graphics g){
		this.setBackground(Color.red);
		g.drawString("Applet������...", 20, 50);
		
	}

}
