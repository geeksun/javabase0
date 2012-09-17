package com.geeksun.awt.event;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * @author 姜志强
 * @annotation: 大部分监听接口都存在相应的适配器类，每个适配器类都实现了相应的监听接口。
 * 					   但是，适配器中的方法的方法体都是空实现。本例中使用WindowAdapter.
 * @create at 2009-4-5
 */
public class WindowEvent3 extends Frame {
	
	public WindowEvent3(){
		setTitle("关闭窗口事件的处理");		//指定标题
	
		//使用匿名类来进行事件处理，创建 WindowListener 对象
		WindowListener winHandler = new WindowAdapter(){
		public void windowClosing(WindowEvent e){
			//this指WindowEvent3的对象，即框架对象。
			CloseFrameDialog d = new CloseFrameDialog(WindowEvent3.this, "关闭", "确实要关闭吗？");
			
			d.setSize(200, 100);
			d.setVisible(true);
			}
		};

		addWindowListener(winHandler);		//注册事件监听者
	 }
	
	public static void main(String []args){
		WindowEvent3 we = new WindowEvent3();
		we.setSize(200, 200);
		we.setVisible(true);
		
	}
	
}
