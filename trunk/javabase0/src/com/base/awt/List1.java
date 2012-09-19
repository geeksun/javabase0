package com.base.awt;

import java.awt.Frame;
import java.awt.List;
import java.awt.TextField;

/**
 * @author 姜志强
 *  List :列表框
 */
public class List1 {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		Frame frame = new Frame("List Test");
		List list = new List(7);
		
		//文本域：单行文本框
		TextField ft = new TextField();
		list.add("姜志强");		//向 list 中添加项目 item
		list.add("李白");
		list.add("bobo");
		list.add("Test");
		
		frame.add(list, "Center");	//向 frame 添加 list
		frame.add(ft, "South");		//向 frame 添加 ft
		
		frame.pack();		//自动调整Frame的大小,使其可以显示其中所有的组件
		frame.setVisible(true);
		
		for(int i=0;i<list.getItemCount();i++){
			ft.setText(list.getItem(i));	//获取 list 的第 i 项 ，并显示在 ft 中
			Thread.sleep(1000);				//休眠 1 秒钟
		} 
		
	}

}
