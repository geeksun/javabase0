package com.geeksun.awt.event;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

/**
 * @author ��־ǿ
 * @annotation: ���¼�����
 * @create at 2009-4-6
 */
public class MultiEvent1 extends Frame implements ActionListener, TextListener {
	Label action = new Label();			//�������¼�ʱʹ�õı�ǩ
	Label text = new Label();			//�����¼�ʱʹ�õı�ǩ
	TextField tf = new TextField(20);	//�������¼��ĵ����ı���
	
	public MultiEvent1(String title){
		super(title);
		action.setBackground(Color.GREEN);
		text.setBackground(Color.PINK);

		add(action, "North");
		add(text, "Center");
		add(tf, "South");
		
		tf.addActionListener(this);		//��tfע�ᶯ���¼���������
		tf.addTextListener(this);		//��tf ע���ı��¼���������
	}
	
	/**
	 * @annotation: press Enter Key touch actionEvent(�����¼�)
	 */
	public void actionPerformed(ActionEvent e) {	//ʵ��ActionListener�ӿ�
		action.setText(tf.getText());
	}

	public void textValueChanged(TextEvent e) {		//ʵ��TextListener�ӿ�
		text.setText(tf.getText());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Frame f = new MultiEvent1("���¼�����");
		f.pack();
		f.setVisible(true);
	}

}
