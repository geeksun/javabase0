package com.base.awt;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Frame;
import java.awt.GridLayout;

public class Checkbox3 {

	/**
	 * @param args
	 * @throws InterruptedException 
	 *  ��Ȥ�ĳ�����ƣ������Ĺ��
	 */
	public static void main(String[] args) throws InterruptedException {
		Frame f = new Frame("��Ȥ�ĳ������");
		f.setLayout(new GridLayout(10, 10));	//GridLayout ���֣� 10�С�10��
		
		CheckboxGroup cbg = new CheckboxGroup();	//��ѡ����
		Checkbox[] cb = new Checkbox[100];		//cb.leng == 100
		
		for(int i=0;i<cb.length;i++){
			cb[i] = new Checkbox("", false, cbg);	//������ѡ�� cb[0]~cb[99]
			f.add(cb[i]);						//��ӵ� frame ��
		}
		
		f.pack();
		f.setVisible(true);						//��ʾ frame
		
		int a = 0;
		while(true){
			cb[a].setState(true);				//�� cb[a] ״̬�趨Ϊ true, a��0��99֮��
			Thread.sleep(50); 
			a++;								//�� a ��1
			if(a>=cb.length)	a = 0;			//�� a ����100�� ��a ��0
		}
	}

}
