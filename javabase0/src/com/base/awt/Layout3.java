package com.base.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;

public class Layout3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Frame f = new Frame("ʹ�� Panel �������");
		
		Button b = new Button("NORTH");
		
		//��f �ı��������У�����Ӱ�ť
		Button be = new Button("EAST");
		Button bw = new Button("WEST");
		Button bs = new Button("SOUTH");
		Button bc = new Button("CENTER");
		
		f.add(b,BorderLayout.NORTH);	//����ťb�����ڱ���
		f.add(be,BorderLayout.EAST);
		f.add(bw,BorderLayout.WEST);
		f.add(bs,BorderLayout.SOUTH);
		f.add(bc,BorderLayout.CENTER);
		
		//������岢��������� 3����ť
		Panel p = new Panel();
		p.add(new Button("��"));
		p.add(new Button("7��"));
		p.add(new Button("��ť"));
		
		//�����p ����ڴ���f ���ϲ�����
		f.add(p, BorderLayout.SOUTH);
		
		f.pack();
		f.setVisible(true);
	}

}
