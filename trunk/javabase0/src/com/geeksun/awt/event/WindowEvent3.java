package com.geeksun.awt.event;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * @author ��־ǿ
 * @annotation: �󲿷ּ����ӿڶ�������Ӧ���������࣬ÿ���������඼ʵ������Ӧ�ļ����ӿڡ�
 * 					   ���ǣ��������еķ����ķ����嶼�ǿ�ʵ�֡�������ʹ��WindowAdapter.
 * @create at 2009-4-5
 */
public class WindowEvent3 extends Frame {
	
	public WindowEvent3(){
		setTitle("�رմ����¼��Ĵ���");		//ָ������
	
		//ʹ���������������¼��������� WindowListener ����
		WindowListener winHandler = new WindowAdapter(){
		public void windowClosing(WindowEvent e){
			//thisָWindowEvent3�Ķ��󣬼���ܶ���
			CloseFrameDialog d = new CloseFrameDialog(WindowEvent3.this, "�ر�", "ȷʵҪ�ر���");
			
			d.setSize(200, 100);
			d.setVisible(true);
			}
		};

		addWindowListener(winHandler);		//ע���¼�������
	 }
	
	public static void main(String []args){
		WindowEvent3 we = new WindowEvent3();
		we.setSize(200, 200);
		we.setVisible(true);
		
	}
	
}
