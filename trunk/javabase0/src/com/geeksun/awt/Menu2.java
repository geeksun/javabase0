package com.geeksun.awt;

import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.event.KeyEvent;

/**
 * @author ��־ǿ
 * @annotation: �˵�: ���ļ������ӡ��½��������򿪡��������桱�����˳��������˵�(�˵���)��
 * @component: MenuBar: ��ʾ�˵��Ĳ˵���; Menu�����ɲ˵����ĸ�����������ļ��˵����༭�˵���;MenuItem:���˵��ָÿ���˵�
 * 					��Menu�������е��²�˵������½����򿪣�����ȡ�
 * @create at 2009-4-1
 */
public class Menu2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Frame f = new Frame("Menu");
		MenuBar mb = new MenuBar();
		
		//�����˵�
		Menu m_file = new Menu("�ļ�");
		Menu m_edit = new Menu("�༭");
		Menu m_view = new Menu("�鿴");
		
		//Ϊ�ļ��˵������˵��MenuShortcut������˵��Ŀ�ݼ�;KeyEvent����������¼���
		MenuItem mi_new = new MenuItem("�½�", new MenuShortcut(KeyEvent.VK_N));
		MenuItem mi_open = new MenuItem("��", new MenuShortcut(KeyEvent.VK_O));
		MenuItem mi_save = new MenuItem("����", new MenuShortcut(KeyEvent.VK_S));
		MenuItem mi_exit = new MenuItem("�˳�", new MenuShortcut(KeyEvent.VK_X));
		
		//�������Ĳ˵���������ļ��˵���
		m_file.add(mi_new);
		m_file.add(mi_open);
		m_file.add(mi_save);
		m_file.addSeparator();	//��ӷָ���
		m_file.add(mi_exit);
		
		//��˵�����Ӳ˵�
		mb.add(m_file);
		mb.add(m_edit);
		mb.add(m_view);

		f.setMenuBar(mb);		//���˵����������ܴ�����
		f.setSize(200, 200);
		f.setVisible(true);
		
	}

}
