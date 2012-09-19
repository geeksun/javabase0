package com.base.awt;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.util.Random;

public class Canvas1 extends Canvas{

	/**
	 * @param args
	 * 画布：用于绘制图形或图片,帆布
	 */
	public void paint(Graphics g){
		Random rnd = new Random();
		for(int i=1;i<=100;i++){
			//随机设定颜色，nextInt(256)将产生0～255之间的随机数
			g.setColor(new Color(rnd.nextInt(256),
			rnd.nextInt(256), rnd.nextInt(256)));
			
			//绘制直线，位置随机
			g.drawLine(rnd.nextInt(200), rnd.nextInt(200), rnd.nextInt(200), rnd.nextInt(200));
			
		}
	}
	public static void main(String[] args) {
		Frame f = new Frame("Canvas");
		Canvas1 c = new Canvas1();	//画布对象
		f.add(c);	//向 frame 中添加画布
		f.setSize(200, 200);
		f.setVisible(true);
	}

}
