package com.geeksun.awt.event;

import java.awt.Menu;
import java.awt.Frame;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author ��־ǿ
 * @annotation: ���±�����ĸ����࣬Bar�˵����࣬ʵ���˱��ڲ���˵��Ĺ��ܡ�
 * @create at 2009-4-6
 */
class MyMenuBar extends MenuBar{
	private static final long serialVersionUID = -6509201141315415912L;
	
	public MyMenuBar(Frame parent){
		parent.setMenuBar(this);			//��parent�������
	}
	
	public void addMenus(String[] menus){
		for(int i=0;i<menus.length;i++){	//ѭ��0 �� menus.length-1��
			add(new Menu(menus[i]));		//�����menus[i]Ϊ����Ĳ˵�
		}
	}
	
	public void addMenuItems(int menuNumber, String[] items){
		for(int i=0;i<items.length;i++){
			//���ַ�Ϊnull�������Separator,������Ӳ˵���
			if(items[i] != null)
				getMenu(menuNumber).add(new MenuItem(items[i]));
			else
				getMenu(menuNumber).addSeparator();
		}
	}
	
	public void addActionListener(ActionListener al){
		//ѭ���õ��˵��ĸ���
		for(int i=0;i<getMenuCount();i++){
			//ѭ������i�˵��ĸ���
			for(int j=0;j<getMenu(i).getItemCount();j++){
				//���i�˵��ĵ�j����Ŀע�ᶯ���¼�������
				getMenu(i).getItem(j).addActionListener(al);
			}
		}
	}
}


public class MyMenuBarTest implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());	//output menu item title��caption��
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Frame f = new Frame("MyMenuBar Test");
		MyMenuBar mb = new MyMenuBar(f);			//���� mb ���󣬲������Frame ��
		
		mb.addMenus(new String[]{"�ļ�","����"});		//��Ӳ˵�
		
		//��Ӳ˵���
		mb.addMenuItems(0, new String[]{"�½�","��","����",null,"�˳�"});
		mb.addMenuItems(1, new String[]{"����",null,"�����滻"});
		
		mb.addActionListener(new MyMenuBarTest());	//ע�� ActionListener
		
		f.setSize(300, 300);
		f.setVisible(true);
	}

}
