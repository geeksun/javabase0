package com.base.awt.event;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * @author ��־ǿ
 * @annotation: �����¼��Ĵ���
 * @create at 2009-4-3
 */
@SuppressWarnings("serial")
public class WindowEvent1 extends Frame implements WindowListener {
	
	public WindowEvent1(){
		setTitle("�����¼�����");		//��ܴ����趨����
		addWindowListener(this);	//ע�ᴰ���¼���������
	}
	
	public void windowActivated(WindowEvent e) {

	}

	public void windowClosed(WindowEvent e) {
		
	}

	/**
	 * @see �رմ���ʱ�����ø÷���
	 */
	public void windowClosing(WindowEvent e) {	
		Dialog d = new Dialog(this, "ȷ���˳�", true);
		
		//������壬��������ӡ��ǡ�������������ť
		Panel p = new Panel();
		p.setLayout(new GridLayout());
		p.add(new Button("��"));
		p.add(new Button("��"));
		
		//��Ի�����ӱ�ǩ�����
		d.add(new Label("��Ҫ�˳���", Label.CENTER),"Center");
		d.add(p, "South");
		
		//show dialog
		d.setSize(200, 100);
		d.setVisible(true);
	}

	public void windowDeactivated(WindowEvent e) {

	}

	public void windowDeiconified(WindowEvent e) {

	}

	public void windowIconified(WindowEvent e) {

	}

	public void windowOpened(WindowEvent e) {
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WindowEvent1 we = new WindowEvent1();
		we.setSize(200, 100);
		we.setVisible(true);
		
	} 


}
