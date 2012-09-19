package com.base.awt;

import java.awt.Frame;
import java.awt.MenuItem;
import java.awt.PopupMenu;

/**
 * @author ��־ǿ
 * @component: MenuBar: ��ʾ�˵��Ĳ˵���; Menu�����ɲ˵����ĸ�����������ļ��˵����༭�˵���;MenuItem:���˵��ָÿ���˵�
 * 					��Menu�������е��²�˵������½����򿪣�����ȡ�
 * @annotation: ����ʽ�˵�������Ҽ�ʱ�����Ĳ˵���
 */
public class PopupMenu1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Frame f = new Frame();
		PopupMenu pm = new PopupMenu("�༭");
		
		//Ϊ����ʽ�˵������˵���
		MenuItem cut = new MenuItem("����");
		MenuItem copy = new MenuItem("����");
		MenuItem paste = new MenuItem("ճ��");
		
		//���˵������������ʽ�˵���
		pm.add(cut);
		pm.add(copy);
		pm.add(paste);
		
		f.add(pm);		//������ʽ�˵��������ܴ�����
		
		f.setSize(200, 200);
		f.setVisible(true);		//����
		
		pm.show(f, 50, 60);		//�ڿ�ܴ��ڵ�(50, 60)����ʾ����ʽ�˵�
	}

}
