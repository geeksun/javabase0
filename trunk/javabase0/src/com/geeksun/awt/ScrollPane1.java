package com.geeksun.awt;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.ScrollPane;

/**
 * @author ��־ǿ
 * @annotation: ������壬���� Panel �� Scrollbar �Ĺ���
 */
public class ScrollPane1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Frame f = new Frame("ScrollPan");
		ScrollPane sp = new ScrollPane(1);	//������ʾ������
		Panel p = new Panel();	//Ҫ������sp �е����
		
		p.setLayout(new GridLayout(10, 2));
		p.setBackground(Color.BLUE);	
		p.setForeground(Color.white);	//ǰ��ɫ
		sp.setBounds(10, 30, 180, 160);	//sp ��λ��
		f.setLayout(null);	//�޲���
		f.setSize(200, 100);
		
		for(int i=1;i<=10;i++){		//����10����ť���ǩ��������������
			p.add(new Label("��"+i+"����ǩ"));
			p.add(new Button("��"+i+"����ť"));
			
		}
		
		sp.add(p);	//���������� ScrollPane ��
		f.add(sp);	//��ScrollPane �����������
		
		f.setVisible(true);
	}

}
