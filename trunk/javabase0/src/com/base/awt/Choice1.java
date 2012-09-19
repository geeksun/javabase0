package com.base.awt;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Frame;

/**
 * @author 姜志强
 * @define 下拉框：支持用户从目录条目中选取一项，但是，只有被选取的item才会被显示出来，
 *         所以使用它不会占据太大空间。与List相比，它的效率更高。
 */
public class Choice1 {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		Frame f = new Frame("Choice Test");
		Choice ch = new Choice(); 	//创建Choice对象
		
		ch.add("苹果");
		ch.add("梨");
		ch.add("桃");
		ch.add("葡萄");
		ch.add("西瓜");
		ch.add("杏");
		
		f.setLayout(null);		//不使用任何布局管理器
		f.setBackground(Color.BLUE);	//将frame的背景色设为蓝色
		f.add(ch);		//向 frame 中添加 choice 对象
		f.setSize(100, 100);		//设定 frame 的大小
		ch.setLocation(30, 40);		//指定列表框的位置
		
		f.setVisible(true);
		
		for(int i=0;i<ch.getItemCount();i++){	//ch.getItemCount() == 6
			ch.select(i);
			Thread.sleep(1000);				//休眠 1 秒 
		}
	}

}
