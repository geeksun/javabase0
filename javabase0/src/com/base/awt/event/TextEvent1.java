package com.base.awt.event;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

/**
 * @author ��־ǿ
 * @annotation: �ı��¼����ı������TextArea��TextField�����ı�ʱ�������¼���
 * @create at 2009-4-5
 */
public class TextEvent1 extends Frame {
	private static final long serialVersionUID = -249356272557230328L;
	Label text;
	Label length;
	TextField tf;
	
	public TextEvent1(String title){
		super(title);
		setLayout(new GridLayout(3, 1));
		
		//�����������
		text = new Label("�ַ���");
		length = new Label("�ַ�������0");
		tf = new TextField();
		
		//����������
		add(text);
		add(length);
		add(tf);
		
		tf.addTextListener(new TextHandler());	//ע������ӿڶ���
	}
	
	public static void main(String[] args){
		TextEvent1 te = new TextEvent1("�ı��¼�����");
		te.setSize(200, 200);
		te.setVisible(true);
	}
	
	class TextHandler implements TextListener{
		//��ʾ�ı����ı������ı�ʱ����
		public void textValueChanged(TextEvent e) {	//�����ı��¼�����
			//��ʾ������ַ���
			text.setText("�ַ�����"+tf.getText());
			
			//��ʾ������ַ����ĳ���
			length.setText("�ַ���:"+tf.getText().length());
		}	
		
	}
	
}
