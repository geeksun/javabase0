package com.base.awt;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

public class Layout4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Frame f = new Frame("�ı� Layout");
		
		//������f �����趨Ϊ FlowLayout ����
		f.setLayout(new FlowLayout());
		
		f.add(new Button("ʹ��"));
		f.add(new Button("setLayout()"));
		f.add(new Button("�ı�"));
		f.add(new Button("���ڲ���"));
		
		f.pack();
		f.setVisible(true);
		
	}

}
