package com.base.awt;

import java.awt.Frame;
import java.awt.Label;

public class Label1 {

	/**
	 * ��ǩ���ṩ����ʾĳ���ı��Ĺ���
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame f = new Frame("Label");
		Label l1 = new 	Label("Label 1");	// ������ǩ���ı�Ĭ��Ϊ�����
		Label l2 = new Label("Label 2", Label.RIGHT);	// �ı��趨Ϊ�Ҷ���
		
		//�����ձ�ǩ��Ϊ���趨�ı�ʱ���ı����У�
		Label l3 = new Label("", Label.CENTER);
		
		l3.setText(l1.getText() + l2.getText());	//��l3 ��text -> " Label 1 Label 2"
		
		f.add(l1, "North");		//��ӱ�ǩ
		f.add(l2, "Center");
		f.add(l3, "South");
		
		f.setSize(200, 100);
		f.setVisible(true);
		
		
		
	}

}
