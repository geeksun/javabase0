package com.geeksun.awt.event;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author ��־ǿ
 * @annotation: KeyEvent�����¼�����������йص��¼����̳��������¼��ࣨInputEvent��.
 * @create at 2009-4-6
 */
public class KeyEvent1 extends Frame {
	Label keyChar;		//��ʾkeyChar�ı�ǩ
	Label keyCode;		//��ʾkeyCode�ı�ǩ
	Label keyText;		//��ʾkeyText�ı�ǩ
	Label actionKey;	//��ʾ�Ƿ�Ϊ actionKey �ı�ǩ
	TextField tf;		//keyEvent���¼�Դ
	
	public KeyEvent1(String title){
		super(title);
		setLayout(new GridLayout(5,1));
		
		keyChar = new Label("keyChar:");	//��ʼ����ǩ���ı���
		keyCode = new Label("keyCode:");
		keyText = new Label("keyText:");
		actionKey = new Label("actionKey:");
		tf = new TextField();
		
		add(keyChar);
		add(keyCode);
		add(keyText);
		add(actionKey);
		add(tf);
		
		tf.addKeyListener(new KeyHandler());	//ע������߶��� 
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KeyEvent1 ke = new KeyEvent1("Key�¼�����");
		ke.setSize(200, 200);
		ke.setVisible(true);
	}

	/**
	 * @author ��־ǿ
	 * @annotation: ��������¼�������
	 */
	class KeyHandler implements KeyListener{

		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			keyCode.setText("keyCode:"+e.getKeyCode());
			keyText.setText("keyText:"+e.getKeyText(e.getKeyCode()));
			actionKey.setText("actionKey:"+e.isActionKey());
			
		}

		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			keyChar.setText("keyChar:"+e.getKeyChar());
		}
		
	}
}
