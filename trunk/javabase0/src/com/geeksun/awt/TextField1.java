package com.geeksun.awt;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;

/**
 * @since jdk 1.5
 * @author ��־ǿ
 * @create at 2009-3-26
 * @define �����ı���
 */
public class TextField1 {
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Frame frame = new Frame("��¼�Ի���");	//���� Frame
		TextField id = new TextField(10);	//����һ�������ı������ڽ����û� ID ����
		TextField pw= new TextField(10);	
		Button login = new Button("��¼");	//��¼��ť
		Button cancel = new Button("ȡ��");
		
		pw.setEchoChar('*');	//ָ��������ʾ�ַ�Ϊ '*'
		
		frame.setLayout(new GridLayout(3, 2));	//ָ�����ֹ�����
		
		//�� frame ˳��������
		frame.add(new Label("ID:", Label.CENTER));
		frame.add(id);
		frame.add(new Label("���룺", Label.CENTER));
		frame.add(pw);
		frame.add(login);
		frame.add(cancel);
		
		frame.pack();
		frame.setVisible(true);
	}

}
