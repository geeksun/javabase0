package com.base.applet;

import java.applet.Applet;
import java.awt.*;

public class InJava extends Applet{
	private static final long serialVersionUID = 6126206392745576459L;
	public void sayHello() {
		Graphics g = getGraphics();
		g.drawString("Hello from JAVA!", 10, 10);
    }
 }