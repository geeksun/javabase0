package com.geeksun.awt.event;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author ��־ǿ
 * @annotation: awt���¼�����:�����¼�ActionEvent
 * @create at 2009-4-2
 */

public class ActionEvent1 extends Frame {	//�̳п����
	private static final long serialVersionUID = 7584707070432946494L;
	Button button;
	public ActionEvent1(String title){
		super(title);		//���๹�캯������ӿ�ܴ��ڱ���
		button = new Button("ȷ��");	//��ť
		add(button);		//������Ӱ�ť
		
		//�����¼������߶���
		ActionListener lis = new ActionHandler(); 
		
		//register->>ע���¼������߶���
		button.addActionListener(lis);
	}
	
	public static void main(String[] args) {
		ActionEvent1 am = new ActionEvent1("�����¼�����");
		am.pack();
		am.setVisible(true);
		
	}
	
	/**
	 * @mark: �ڲ��࣬ʵ���¼������ӿڵ��ೣ��������ڲ��࣬���ַ�����ʹ�á�
	 */
	class ActionHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {	//ActionEvent ����
			//��Ӵ����¼��Ĵ���
			System.err.println(e.getActionCommand());	//�����ť�ı�
		}
		
	}
}
