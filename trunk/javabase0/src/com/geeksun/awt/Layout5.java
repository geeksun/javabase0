package com.geeksun.awt;

import java.awt.Button;
import java.awt.Frame;

public class Layout5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Frame f = new Frame("�ı� Layout");
		
		//��Ӧ���κβ���
		f.setLayout(null);
		
		Button ba = new Button("δʹ��");
		Button bb = new Button("�κβ���");
		
		//���������趨����Ĵ�С��λ��
		ba.setBounds(20, 50, 100, 40);
		bb.setBounds(50, 100, 100, 40);
		
		f.add(ba);
		f.add(bb);
		
		f.setSize(200, 160);
		f.setVisible(true);
		
	}

}
