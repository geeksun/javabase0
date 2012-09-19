package com.base.awt;

import java.awt.Adjustable;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.ScrollPane;

/**
 * @author 姜志强
 * @annotation: 滚动面板
 */
public class ScroolPane2 {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		Frame f = new Frame("ScrollPane");
		ScrollPane sp = new ScrollPane(0);	//sp 自动决定滚动条的有无
		Panel p = new Panel();
		
		p.setLayout(new GridLayout(0, 1));	//GridLayout 布局
		sp.setBounds(10,30,180,160);
		f.setLayout(null);
		f.setSize(200, 200);
		
		for(int i=0;i<=100;i++){	//向p添加100个标签
			p.add(new Label("第"+i+"个标签"));
			//System.out.println("i:"+i);
		}
		
		sp.add(p);
		f.add(sp);
		f.setVisible(true);
		
		//获取对vAdjustable对象的引用
		Adjustable adj = sp.getVAdjustable();
		//System.out.println(adj.getValue());  init 为 0
		
		while(true){
			//使vAdjustable的value每次增1
			adj.setValue(adj.getValue()+1);
			Thread.sleep(5);	//休眠0.1 秒 
			System.out.println(adj.getValue());
			//为何为1000？
			if(adj.getValue()>=1000){
				adj.setValue(0);
			}
		}
	}

}
