package com.geeksun.oop;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class SunApplet extends Applet {
	public void paint(Graphics g)
	{
		this.setBackground(Color.red);
		g.drawString("Applet World",20,40);
	}
}	
