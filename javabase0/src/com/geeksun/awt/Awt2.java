package com.geeksun.awt;

import java.awt.Frame;

public class Awt2 {

	/**
	 * @param args  
	 * @throws InterruptedException    
	 */
	public static void main(String[] args) throws InterruptedException {
		Frame f = new Frame("����Ĵ�С��λ��");		//����Frame����
		f.setVisible(true);					//��ʾFrame����
		for(int i=1;i<=5;i++){				//ѭ��5��
			f.setSize(i*100, i*100);		//�ı�f�Ĵ�С
			f.setLocation(i*10, i*10);		//�ı�f��λ�ã�move
			System.out.println("���= " + f.getWidth());		//���f�Ŀ��
			Thread.sleep(1000);			//����1����
		}
	}

}
