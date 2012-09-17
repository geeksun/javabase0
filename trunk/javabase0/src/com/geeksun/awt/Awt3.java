package com.geeksun.awt;

import java.awt.Color;
import java.awt.Frame;

public class Awt3 {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		Frame f = new Frame("组件的背景色");
		f.setSize(200, 100);
		f.setVisible(true);
		for(int i=0;i<255;i++){
			f.setBackground(new Color(i,0,0));//黑色－》红色
			Thread.sleep(10);
			
		}
		for(int i=0;i<=255;i++){
			f.setBackground(new Color(255,i,0));//红色－》黄色
			Thread.sleep(10);
		}
	}

}
