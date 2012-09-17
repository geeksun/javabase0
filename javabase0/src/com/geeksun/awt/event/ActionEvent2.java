package com.geeksun.awt.event;

import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class ActionEvent2 extends Frame implements ActionListener {
	TextField tf ;

	public ActionEvent2(String title){
		super(title);	//��ӿ�ܴ��ڱ���
		tf = new TextField(20);
		
		//this ��һ�� Frame��Ҳ�Ƕ����¼������߶���
		tf.addActionListener(this);
		
		add(tf);	//������Ӱ�ť
	}
	public void actionPerformed(ActionEvent e) {	//override
		//���¼�Դ����Ϊ TextField ����
		if(e.getSource() instanceof TextField){
			TextField  tx = (TextField) e.getSource();	//��ȡ�¼�Դ����
			System.out.println(tx.getText());			//��� tx �е��ַ���
			tx.setText("");				//��� tx �е�����
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ActionEvent2 ae = new ActionEvent2("�����¼�����");
		//Frame aw = new ActionEvent2("�����¼�����2");
		ae.pack();
		
		ae.setVisible(true);
	}

}
