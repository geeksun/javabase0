package com.geeksun.awt;

import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;

/**
 * performance：性能
 * @author 姜志强
 * 菜单组件：创建了一个菜单，并向框架添加一个包含菜单的菜单条。
 * @component: MenuBar: 显示菜单的菜单行; Menu：构成菜单条的各种组件，像文件菜单，编辑菜单等;MenuItem:（菜单项）指每个菜单
 * 					（Menu）所具有的下层菜单，如新建，打开，保存等。
 */
public class Menu1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Frame f = new Frame("Menu");
		MenuBar mb = new MenuBar();		//创建菜单条
		Menu m_file = new Menu("文件");	//文件菜单
		Menu m_edit = new Menu("编辑");
		Menu m_view = new Menu("查看");
		
		mb.add(m_file);	//向菜单条添加文件菜单
		mb.add(m_edit);
		mb.add(m_view);
		
		f.setMenuBar(mb);	//将菜单条添加至Frame中
		f.setSize(200, 200);
		f.setVisible(true);
		
	}

}
