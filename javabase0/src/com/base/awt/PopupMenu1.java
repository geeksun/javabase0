package com.base.awt;

import java.awt.Frame;
import java.awt.MenuItem;
import java.awt.PopupMenu;

/**
 * @author 姜志强
 * @component: MenuBar: 显示菜单的菜单行; Menu：构成菜单条的各种组件，像文件菜单，编辑菜单等;MenuItem:（菜单项）指每个菜单
 * 					（Menu）所具有的下层菜单，如新建，打开，保存等。
 * @annotation: 弹出式菜单，点击右键时弹出的菜单。
 */
public class PopupMenu1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Frame f = new Frame();
		PopupMenu pm = new PopupMenu("编辑");
		
		//为弹出式菜单创建菜单项
		MenuItem cut = new MenuItem("剪切");
		MenuItem copy = new MenuItem("复制");
		MenuItem paste = new MenuItem("粘贴");
		
		//将菜单项添加至弹出式菜单中
		pm.add(cut);
		pm.add(copy);
		pm.add(paste);
		
		f.add(pm);		//将弹出式菜单添加至框架窗口中
		
		f.setSize(200, 200);
		f.setVisible(true);		//可视
		
		pm.show(f, 50, 60);		//在框架窗口的(50, 60)处显示弹出式菜单
	}

}
