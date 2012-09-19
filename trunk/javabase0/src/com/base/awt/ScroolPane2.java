package com.base.awt;

import java.awt.Adjustable;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.ScrollPane;

/**
 * @author ��־ǿ
 * @annotation: �������
 */
public class ScroolPane2 {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		Frame f = new Frame("ScrollPane");
		ScrollPane sp = new ScrollPane(0);	//sp �Զ�����������������
		Panel p = new Panel();
		
		p.setLayout(new GridLayout(0, 1));	//GridLayout ����
		sp.setBounds(10,30,180,160);
		f.setLayout(null);
		f.setSize(200, 200);
		
		for(int i=0;i<=100;i++){	//��p���100����ǩ
			p.add(new Label("��"+i+"����ǩ"));
			//System.out.println("i:"+i);
		}
		
		sp.add(p);
		f.add(sp);
		f.setVisible(true);
		
		//��ȡ��vAdjustable���������
		Adjustable adj = sp.getVAdjustable();
		//System.out.println(adj.getValue());  init Ϊ 0
		
		while(true){
			//ʹvAdjustable��valueÿ����1
			adj.setValue(adj.getValue()+1);
			Thread.sleep(5);	//����0.1 �� 
			System.out.println(adj.getValue());
			//Ϊ��Ϊ1000��
			if(adj.getValue()>=1000){
				adj.setValue(0);
			}
		}
	}

}
