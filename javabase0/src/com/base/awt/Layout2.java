package com.base.awt;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;

/**
 * @author ��־ǿ
 *  Panel������ȱʡ������FlowLayout,��������ռ����˳�����������
 */
public class Layout2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Frame f = new Frame("FlowLayout");
		Panel p = new Panel();
		
		//��������5����ť
		p.add(new Button("1"));
		p.add(new Button("2"));
		p.add(new Button("3"));
		p.add(new Button("4"));
		p.add(new Button("5"));
		
		f.add(p);	//�������ӵ���ܴ���f��
		
		f.pack();	//x1 �Զ�����Frame�Ĵ�С,ʹ�������ʾ�������е����
		f.setVisible(true);
	}

}
