package com.base.awt.event;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author 姜志强
 * @annotation: 关闭窗口事件的处理
 * @dispose() 用于关闭窗口，并且释放窗口占用的资源。
 * @create at 2009-4-3
 */
public class CloseFrameDialog extends Dialog implements ActionListener {
	private static final long serialVersionUID = 8379011275941699820L;
	
	Button yes = new Button("是");	//“是”按钮
	Button no = new Button("否");
	Frame owner;		//所有者对话框
	Label msgLabel;		//显示消息的标签
	
	/**
	 * @annotation: 构造函数，owner＝所有者，title＝对话框标题，msg＝消息
	 */
	public CloseFrameDialog(Frame owner, String title, String msg) {
		//调用父类构造函数，指定所有者标题与模式
		super(owner, title, true);
		
		this.owner = owner;		//所有者
		msgLabel = new Label(msg, Label.CENTER);	//拥有指定消息的标签
		
		//创建面板，并向其添加“是”，“否”两个按钮
		Panel p = new Panel();
		p.setLayout(new GridLayout(1, 2));
		p.add(yes);
		p.add(no);
		
		//向对话框添加标签和面板
		add(msgLabel, "Center");
		add(p, "South");
		
		//向按钮注册事件监听者
		yes.addActionListener(this);
		no.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		//读取按钮上的字符串
		String command = e.getActionCommand();
		
		if(command.equals("是")){	//若为”是“按钮
			owner.dispose();		//关闭所有者对话窗口，对话框也被关闭。
		}else if(command.equals("否")){	//若为“否”按钮
			this.dispose();			//只有对话框被关闭
		}
	}

}
