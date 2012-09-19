package com.base.awt.event;

import java.awt.Frame;
import java.awt.List;
import java.awt.TextField;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * @author ��־ǿ
 * @annotation: ItemEven��Ŀ�¼����ھ���ĳ����Ŀ���ܵ�����Ϸ�����happen�����¼�����ѡ���б��������б�����Ŀ��ı临ѡ���״̬ʱ��
 * 				ItemEven�¼�����ʵ����ItemSelectable �ӿڵ����Ϸ������¼����б�������б�򣬸�ѡ��ʵ���� ItemSelectable �ӿڡ�
 * @create at 2009-4-6
 */
public class ItemEvent1 extends Frame implements ItemListener{
	List good = new List(7);	//ItemEven���¼�Դ
	TextField tf = new TextField();		//��ʾ�б��ѡ�е���Ŀ�ĵ����ı���
	
	public ItemEvent1(String title){
		super(title);
		good.add("С��");				//���б�������Ŀ
		good.add("text");
		good.add("geeksun");
		good.add("gogo");
		good.add("google");
		good.add("music");
		good.add("run");
		good.addItemListener(this);		//���б��ע����Ŀ�¼�������
		
		add(good, "North");				//��������б�����ı���
		add(tf, "Center");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ItemEvent1 ie = new ItemEvent1("������Ŀ�¼�");
		ie.pack();
		ie.setVisible(true);
	}

	public void itemStateChanged(ItemEvent e) {		//����ItemEven�¼�
		// TODO Auto-generated method stub
		if(e.getSource() == good)					//���¼�ԴΪ good ���б���б�ѡ�е���Ŀ��ʾ�� TextField ��
			tf.setText(good.getSelectedItem());
		
		//����¼�Դ�б�ѡ�е���Ŀ����Ŀ��ţ�
		System.out.println(e.getItem());
	}

	
}
