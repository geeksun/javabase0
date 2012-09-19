package com.base.awt;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.Frame;

/**
 * @author ��־ǿ
 *  ��ѡ��ť
 */
public class Checkbox2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Frame f = new Frame("CheckboxGroup");
		CheckboxGroup cbg = new CheckboxGroup();	//��ѡ����
		
		//cb1,cb2,cb3 ���ڸ�ѡ���� cbg
		Checkbox cb1 = new Checkbox("��ɫ", true, cbg);	//��ĳ�� Checkbox ����ĳ������
		Checkbox cb2 = new Checkbox("��ɫ", false, cbg);
		Checkbox cb3 = new Checkbox("��ɫ", false, cbg);
		
		f.add(cb1);
		f.add(cb2);
		f.add(cb3);
		
		f.setLayout(new FlowLayout());
		
		f.setSize(200, 70);
		f.setVisible(true);
		
		System.err.println(cb1.getState());	//��ȡѡȡ״̬ ������ setState(boolean state)��������״̬
	}

}
