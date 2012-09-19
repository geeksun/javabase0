package com.base.awt.event;

import java.awt.Button;
import java.awt.Frame;
import java.awt.List;
import java.awt.TextField;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * @author ��־ǿ
 * @annotation: �����¼���
 * @create at 2009-4-6
 */
public class FocusEvent1 extends Frame implements FocusListener {
	List fInfo = new List(10);					//��ʾ����仯���б�
	TextField tf = new TextField("");			//FocusEvent�¼�Դ
	Button button = new Button("ȷ��");			//���õİ�ť
	
	public FocusEvent1(String title){
		super(title);
		add(fInfo, "North");
		add(tf, "Center");
		add(button, "South");
		tf.addFocusListener(this);				//�� tf ע�ό���¼�������
	}
	
	/**
	 * @annotation: ��ý���ʱ������
	 */
	public void focusGained(FocusEvent e) {
		if(e.isTemporary())	fInfo.add("��ʱ�Ի��");
		else	fInfo.add("�����Ի��");
	}

	/**
	 * @annotation: ʧȥ����ʱ������
	 */
	public void focusLost(FocusEvent e) {
		if(e.isTemporary()) fInfo.add("��ʱ��ʧȥ");
		else	fInfo.add("������ʧȥ");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FocusEvent1 fe = new FocusEvent1("FocusEvent �¼�����");
		fe.pack();				//�Զ�������ʾ���Ĵ�С
		fe.setVisible(true);
	}

}
