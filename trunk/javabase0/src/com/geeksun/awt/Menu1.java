package com.geeksun.awt;

import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;

/**
 * performance������
 * @author ��־ǿ
 * �˵������������һ���˵������������һ�������˵��Ĳ˵�����
 * @component: MenuBar: ��ʾ�˵��Ĳ˵���; Menu�����ɲ˵����ĸ�����������ļ��˵����༭�˵���;MenuItem:���˵��ָÿ���˵�
 * 					��Menu�������е��²�˵������½����򿪣�����ȡ�
 */
public class Menu1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Frame f = new Frame("Menu");
		MenuBar mb = new MenuBar();		//�����˵���
		Menu m_file = new Menu("�ļ�");	//�ļ��˵�
		Menu m_edit = new Menu("�༭");
		Menu m_view = new Menu("�鿴");
		
		mb.add(m_file);	//��˵�������ļ��˵�
		mb.add(m_edit);
		mb.add(m_view);
		
		f.setMenuBar(mb);	//���˵��������Frame��
		f.setSize(200, 200);
		f.setVisible(true);
		
	}

}
