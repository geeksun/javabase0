package com.geeksun.awt;

import java.awt.Color;
import java.awt.Frame;

public class Awt3 {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		Frame f = new Frame("����ı���ɫ");
		f.setSize(200, 100);
		f.setVisible(true);
		for(int i=0;i<255;i++){
			f.setBackground(new Color(i,0,0));//��ɫ������ɫ
			Thread.sleep(10);
			
		}
		for(int i=0;i<=255;i++){
			f.setBackground(new Color(255,i,0));//��ɫ������ɫ
			Thread.sleep(10);
		}
	}

}
