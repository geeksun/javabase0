package com.geeksun.awt;

import java.awt.Button;
import java.awt.Frame;

public class Awt4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame f = new Frame("����");//����Frame
		Button b = new Button("���");//������ť
		
		f.add(b);	//����ťb�������ܴ�����
		
		f.setSize(200, 100);
		f.setVisible(true);
	}

}
