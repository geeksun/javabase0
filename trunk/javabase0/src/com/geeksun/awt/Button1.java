package com.geeksun.awt;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button1 implements ActionListener{		//����ActionEvent
	int count = 0;				//record button click count
	Button button = new Button("����");		//button object
	Label label = new Label("0");	//show click count
	Frame frame = new Frame("Button");
	
	public Button1(){
		button.addActionListener(this);	//ע�ᶯ���¼�������
		frame.add(button, "Center");
		frame.add(label, "South");
		frame.pack();
		
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {		//�����ťʱ������
		count++;
		label.setText(String.valueOf(count));
	}
	
	/**
	 *  Button ������Ӧ�û��� click ���������û����ʱ��ϵͳ�Զ�ִ����ð�ť����ϵ�ĳ��򣬴Ӷ����Ԥ��ָ���Ĺ��ܡ�
	 * @param args
	 */
	public static void main(String[] args) {
		Button1 but = new Button1();
		
	}


}
