package com.base.awt.event;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * @author ��־ǿ
 * @annotation: �����¼��Ĵ�����CloseFrameDialog ��Ӧ���ڿ�ܴ����С�
 * @create at 2009-4-4
 */
public class WindowEvent2 extends Frame implements WindowListener {
	public WindowEvent2(){
		setTitle("���ڹر��¼��Ĵ���");		//
		addWindowListener(this);
	}
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * @see �رմ���ʱ�����ø÷���
	 */
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		//�Ի��������ߣ�this,���⣽���رա�����Ϣ����ȷʵҪ�ر��𣿡���
		CloseFrameDialog cf = new CloseFrameDialog(this, "�ر�", "ȷʵҪ�ر���");
		
		cf.setSize(200, 100);
		cf.setVisible(true);
	}

	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WindowEvent2 we = new WindowEvent2();
		we.setSize(200, 200);
		we.setVisible(true);
	}

}
