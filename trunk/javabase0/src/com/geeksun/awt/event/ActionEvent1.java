package com.geeksun.awt.event;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author 姜志强
 * @annotation: awt的事件处理:动作事件ActionEvent
 * @create at 2009-4-2
 */

public class ActionEvent1 extends Frame {	//继承框架类
	private static final long serialVersionUID = 7584707070432946494L;
	Button button;
	public ActionEvent1(String title){
		super(title);		//父类构造函数，添加框架窗口标题
		button = new Button("确认");	//按钮
		add(button);		//向框架添加按钮
		
		//创建事件监听者对象
		ActionListener lis = new ActionHandler(); 
		
		//register->>注册事件监听者对象
		button.addActionListener(lis);
	}
	
	public static void main(String[] args) {
		ActionEvent1 am = new ActionEvent1("动作事件处理");
		am.pack();
		am.setVisible(true);
		
	}
	
	/**
	 * @mark: 内部类，实现事件监听接口的类常被定义成内部类，这种方法常使用。
	 */
	class ActionHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {	//ActionEvent 处理
			//添加处理事件的代码
			System.err.println(e.getActionCommand());	//输出按钮文本
		}
		
	}
}
