package com.base.awt;

import java.awt.Checkbox;
import java.awt.FlowLayout;
import java.awt.Frame;

/**
 * @author ��־ǿ
 *  ��ѡ��
 */
public class Checkbox1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Frame f = new Frame("Checkbox");
		
		Checkbox cb1 = new Checkbox("ֱ��", true);	//��ʼ״̬Ϊtrue
		Checkbox cb2 = new Checkbox("����", false);	//��ʼ״̬Ϊfalse
		Checkbox cb3 = new Checkbox("�»���", true);
		
		f.add(cb1);
		f.add(cb2);
		f.add(cb3);
		
		f.setLayout(new FlowLayout());	//�������еĲ��ֹ�����
		
		f.setSize(200, 70);
		f.setVisible(true);
	}

}
