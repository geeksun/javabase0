package com.base.awt;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Frame;

/**
 * @author ��־ǿ
 * @define ������֧���û���Ŀ¼��Ŀ��ѡȡһ����ǣ�ֻ�б�ѡȡ��item�Żᱻ��ʾ������
 *         ����ʹ��������ռ��̫��ռ䡣��List��ȣ�����Ч�ʸ��ߡ�
 */
public class Choice1 {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		Frame f = new Frame("Choice Test");
		Choice ch = new Choice(); 	//����Choice����
		
		ch.add("ƻ��");
		ch.add("��");
		ch.add("��");
		ch.add("����");
		ch.add("����");
		ch.add("��");
		
		f.setLayout(null);		//��ʹ���κβ��ֹ�����
		f.setBackground(Color.BLUE);	//��frame�ı���ɫ��Ϊ��ɫ
		f.add(ch);		//�� frame ����� choice ����
		f.setSize(100, 100);		//�趨 frame �Ĵ�С
		ch.setLocation(30, 40);		//ָ���б���λ��
		
		f.setVisible(true);
		
		for(int i=0;i<ch.getItemCount();i++){	//ch.getItemCount() == 6
			ch.select(i);
			Thread.sleep(1000);				//���� 1 �� 
		}
	}

}
