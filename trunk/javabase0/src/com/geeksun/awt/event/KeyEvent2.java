package com.geeksun.awt.event;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author ��־ǿ
 * @annotation: KeyEvent�����¼�����������йص��¼����̳��������¼��ࣨInputEvent��.
 * 				KeyListenter�ӿڵ����������� KeyAdpter.
 * @create at 2009-4-6
 */
public class KeyEvent2 extends Frame {
	Label info;
	TextField tf;
	
	public KeyEvent2(String title){
		super(title);
		setLayout(new GridLayout(2,1));
		
		info = new Label("key����Ϣ��");	//��ʾKey��Ϣ�ı�ǩ
		tf = new TextField();		//keyEvent�¼�ԴTextField
		
		add(info);
		add(tf);
		
		tf.addKeyListener(new KeyHandler());	//ע���������
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KeyEvent2 ke = new KeyEvent2("Key�¼�����");
		ke.setSize(200, 200);
		ke.setVisible(true);
	}

	class KeyHandler extends KeyAdapter{	//�̳� KeyAdapter ��
		public void keyPressed(KeyEvent e){
			String k = "";					//��¼Key��Ϣ�ı���
			if(e.isShiftDown())	k = "Shift + ";
			if(e.isAltDown())	k = "Alt + ";
			if(e.isControlDown())	k = "Ctrl + ";
			k += e.getKeyText(e.getKeyCode());
			info.setText("Key����Ϣ��" + k);
		}
	}
}
