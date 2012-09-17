package com.geeksun.awt;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

/**
 * @author 姜志强
 * 对话框：继承自windows类，与 Frame 类似，也是一个容器类
 */
public class Dialog1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Frame f = new Frame("Dialog示例");
		Dialog dlg = new Dialog(f, "对话框", true);		//模式对话框,可以将 true 改为 false,再运行 
		Panel p = new Panel();		//包含于对话框中的面板
		p.setLayout(new GridLayout(1, 2));	//GridLayout 布局， 1行2列
		
		p.add(new Button("是"));		//向面板中添加两个按钮，是/否
		p.add(new Button("否"));
		
		//向对话框添加标签
		dlg.add(new Label("您喜欢JAVA吗？"),"Center");
		
		dlg.add(p, "South");
		
		f.setBounds(100, 100, 200, 100);	//set 窗口与对话框的大小与位置
		dlg.setBounds(150, 200, 200, 100);
		f.setVisible(true);
		dlg.setVisible(true);	//显示对话框将使窗口失去活性
								//main thread is waiting status
		//下面的语句会运行吗？
		System.err.println("Hi");	//只有关闭模式对话框才会运行
		
	}

}
