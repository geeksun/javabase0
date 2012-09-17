package com.geeksun.awt;

import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.event.KeyEvent;

/**
 * @author 姜志强
 * @annotation: 菜单: 在文件下增加“新建”，“打开”，“保存”，“退出”下拉菜单(菜单项)。
 * @component: MenuBar: 显示菜单的菜单行; Menu：构成菜单条的各种组件，像文件菜单，编辑菜单等;MenuItem:（菜单项）指每个菜单
 * 					（Menu）所具有的下层菜单，如新建，打开，保存等。
 * @create at 2009-4-1
 */
public class Menu2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Frame f = new Frame("Menu");
		MenuBar mb = new MenuBar();
		
		//创建菜单
		Menu m_file = new Menu("文件");
		Menu m_edit = new Menu("编辑");
		Menu m_view = new Menu("查看");
		
		//为文件菜单创建菜单项，MenuShortcut：管理菜单的快捷键;KeyEvent：负责键盘事件。
		MenuItem mi_new = new MenuItem("新建", new MenuShortcut(KeyEvent.VK_N));
		MenuItem mi_open = new MenuItem("打开", new MenuShortcut(KeyEvent.VK_O));
		MenuItem mi_save = new MenuItem("保存", new MenuShortcut(KeyEvent.VK_S));
		MenuItem mi_exit = new MenuItem("退出", new MenuShortcut(KeyEvent.VK_X));
		
		//将创建的菜单项添加至文件菜单中
		m_file.add(mi_new);
		m_file.add(mi_open);
		m_file.add(mi_save);
		m_file.addSeparator();	//添加分隔符
		m_file.add(mi_exit);
		
		//向菜单条添加菜单
		mb.add(m_file);
		mb.add(m_edit);
		mb.add(m_view);

		f.setMenuBar(mb);		//将菜单条添加至框架窗口中
		f.setSize(200, 200);
		f.setVisible(true);
		
	}

}
