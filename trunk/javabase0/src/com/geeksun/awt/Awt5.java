package com.geeksun.awt;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;

/**
 * @author ��־ǿ
 * Window����Panel�඼�̳���Container�࣬�������ڣ�
 * Window�����Զ������е�����
 * Panel��ֻ�ܱ�����������������ʹ�õ�������Ҳ��һ������
 * Frame�̳���Window�࣬���Զ�������
 */
public class Awt5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame f = new Frame("Panel �� Window");
		
		//����2����ť
		Button b1 = new Button("ȷ��");
		Button b2 = new Button("ȡ��");
		
		Panel p = new Panel();	//�������
		p.setBackground(new Color(200,200,0));//�趨����p�ı���ɫΪ��ɫ
		
		p.add(b1);	//�����p����Ӱ�ťb1
		p.add(b2);	//�����p����Ӱ�ťb2
		f.add(p);	//��f��������p
		
		f.setSize(200, 100);
		f.setVisible(true);
	}

}
