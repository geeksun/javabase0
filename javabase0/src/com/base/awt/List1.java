package com.base.awt;

import java.awt.Frame;
import java.awt.List;
import java.awt.TextField;

/**
 * @author ��־ǿ
 *  List :�б��
 */
public class List1 {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		Frame frame = new Frame("List Test");
		List list = new List(7);
		
		//�ı��򣺵����ı���
		TextField ft = new TextField();
		list.add("��־ǿ");		//�� list �������Ŀ item
		list.add("���");
		list.add("bobo");
		list.add("Test");
		
		frame.add(list, "Center");	//�� frame ��� list
		frame.add(ft, "South");		//�� frame ��� ft
		
		frame.pack();		//�Զ�����Frame�Ĵ�С,ʹ�������ʾ�������е����
		frame.setVisible(true);
		
		for(int i=0;i<list.getItemCount();i++){
			ft.setText(list.getItem(i));	//��ȡ list �ĵ� i �� ������ʾ�� ft ��
			Thread.sleep(1000);				//���� 1 ����
		} 
		
	}

}
