package com.geeksun.awt;

import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Scrollbar;

public class Scrollbar1 {

	/**
	 * @throws InterruptedException 
	 * @see ������
	 */
	public static void main(String[] args) throws InterruptedException {
		Frame f = new Frame("������ɫ");
		Panel p = new Panel();	//��ʾ��ɫ�����
		Label l = new Label("0,0,0");	//��ʾ��ɫ��RGBֵ
		
		p.setBackground(new Color(0,0,0));	//��������ɫ��Ϊ��ɫ
		
		//Red, Green, Blue������
		//����ˮƽ��value=0,������=1,��Сֵ=0
		//���ֵ=256
		Scrollbar sRed = new Scrollbar(Scrollbar.HORIZONTAL,0,1,0,256);	//ˮƽ������
		Scrollbar sGreen = new Scrollbar(Scrollbar.HORIZONTAL,0,1,0,256);
		Scrollbar sBlue = new Scrollbar(Scrollbar.HORIZONTAL,0,1,0,256);
	
		f.setLayout(new GridLayout(5, 1));
		
		f.add(p);	//������
		f.add(l);
		f.add(sRed); 
		f.add(sGreen);
		f.add(sBlue);
		
		f.pack();
		f.setVisible(true);
		
		Color col;
		int nRed, nGreen, nBlue;
		
		//ÿ�� 0.1 �룬�� Scrollbar ��valueָ��Ϊ panel ����ɫ
		while(true){
			nRed = sRed.getValue();	//��ȡ���洢��Ӧ�Ĺ�����ֵ
			nGreen = sGreen.getValue();
			nBlue = sBlue.getValue();
			
			//ʹ�� RGB ֵ������ɫ col
			col = new Color(nRed, nGreen, nBlue);
			
			p.setBackground(col);	//����ɫ col ��Ϊp �ı���ɫ
			
			//�ڱ�ǩ l ����ʾRGBֵ
			l.setText(nRed+","+nGreen+","+nBlue);
			
			Thread.sleep(100);
		}
		
	}

}
