package com.base.awt;

import java.awt.Frame;

/**
 * @author ��־ǿ
 * awt��abstract window toolkit,���󴰿ڹ��߼�
 */
public class Awt1 {
	public static void main(String[] args) {
		//Frame f = new Frame();		//������ܴ���
		Frame f = new Frame("Thinking in java");		//������ܴ���
		f.setSize(200, 100);		//�趨��ܴ��ڵĴ�С
		f.setVisible(true);			//��ʾ��ܴ���
	}

}
