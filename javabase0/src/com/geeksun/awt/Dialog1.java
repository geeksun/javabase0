package com.geeksun.awt;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

/**
 * @author ��־ǿ
 * �Ի��򣺼̳���windows�࣬�� Frame ���ƣ�Ҳ��һ��������
 */
public class Dialog1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Frame f = new Frame("Dialogʾ��");
		Dialog dlg = new Dialog(f, "�Ի���", true);		//ģʽ�Ի���,���Խ� true ��Ϊ false,������ 
		Panel p = new Panel();		//�����ڶԻ����е����
		p.setLayout(new GridLayout(1, 2));	//GridLayout ���֣� 1��2��
		
		p.add(new Button("��"));		//����������������ť����/��
		p.add(new Button("��"));
		
		//��Ի�����ӱ�ǩ
		dlg.add(new Label("��ϲ��JAVA��"),"Center");
		
		dlg.add(p, "South");
		
		f.setBounds(100, 100, 200, 100);	//set ������Ի���Ĵ�С��λ��
		dlg.setBounds(150, 200, 200, 100);
		f.setVisible(true);
		dlg.setVisible(true);	//��ʾ�Ի���ʹ����ʧȥ����
								//main thread is waiting status
		//���������������
		System.err.println("Hi");	//ֻ�йر�ģʽ�Ի���Ż�����
		
	}

}
