package com.geeksun.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

/**
 * @author ��־ǿ
 * ���ֹ�����
 * Frame������Ĭ�ϲ����� BorderLayout���������ռ��Ϊ�����ϣ������������������
 */
public class Layout1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Frame f = new Frame("BorderLayout");
		Button b = new Button("NORTH");
		
		//����5����ť
		Button be = new Button("EAST");
		Button bw = new Button("WEST");
		Button bs = new Button("SOUTH");
		Button bc = new Button("CENTER");
		
		f.add(b,BorderLayout.NORTH);	//����ťb�����ڱ���
		f.add(be,BorderLayout.EAST);
		f.add(bw,BorderLayout.WEST);
		f.add(bs,BorderLayout.SOUTH);
		f.add(bc,BorderLayout.CENTER);
		
		f.setSize(170,150);
		f.setVisible(true);
	}

}
