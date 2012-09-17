package com.geeksun.awt.event;

import java.awt.Menu;
import java.awt.Frame;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author 姜志强
 * @annotation: 记事本程序的辅助类，Bar菜单条类，实现了便于插入菜单的功能。
 * @create at 2009-4-6
 */
class MyMenuBar extends MenuBar{
	private static final long serialVersionUID = -6509201141315415912L;
	
	public MyMenuBar(Frame parent){
		parent.setMenuBar(this);			//向parent添加自身
	}
	
	public void addMenus(String[] menus){
		for(int i=0;i<menus.length;i++){	//循环0 ～ menus.length-1次
			add(new Menu(menus[i]));		//添加以menus[i]为标题的菜单
		}
	}
	
	public void addMenuItems(int menuNumber, String[] items){
		for(int i=0;i<items.length;i++){
			//若字符为null，则添加Separator,否则，添加菜单项
			if(items[i] != null)
				getMenu(menuNumber).add(new MenuItem(items[i]));
			else
				getMenu(menuNumber).addSeparator();
		}
	}
	
	public void addActionListener(ActionListener al){
		//循环得到菜单的个数
		for(int i=0;i<getMenuCount();i++){
			//循环到第i菜单的个数
			for(int j=0;j<getMenu(i).getItemCount();j++){
				//向第i菜单的第j个项目注册动作事件监听器
				getMenu(i).getItem(j).addActionListener(al);
			}
		}
	}
}


public class MyMenuBarTest implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());	//output menu item title（caption）
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Frame f = new Frame("MyMenuBar Test");
		MyMenuBar mb = new MyMenuBar(f);			//创建 mb 对象，并添加至Frame 中
		
		mb.addMenus(new String[]{"文件","查找"});		//添加菜单
		
		//添加菜单项
		mb.addMenuItems(0, new String[]{"新建","打开","保存",null,"退出"});
		mb.addMenuItems(1, new String[]{"查找",null,"查找替换"});
		
		mb.addActionListener(new MyMenuBarTest());	//注册 ActionListener
		
		f.setSize(300, 300);
		f.setVisible(true);
	}

}
