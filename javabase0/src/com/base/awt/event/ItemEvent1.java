package com.base.awt.event;

import java.awt.Frame;
import java.awt.List;
import java.awt.TextField;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * @author 姜志强
 * @annotation: ItemEven项目事件是在具有某个项目功能的组件上发生（happen）的事件。如选中列表框或下拉列表框的项目或改变复选框的状态时。
 * 				ItemEven事件是在实现了ItemSelectable 接口的类上发生的事件。列表框，下拉列表框，复选框都实现了 ItemSelectable 接口。
 * @create at 2009-4-6
 */
public class ItemEvent1 extends Frame implements ItemListener{
	List good = new List(7);	//ItemEven的事件源
	TextField tf = new TextField();		//显示列表框被选中的项目的单行文本框
	
	public ItemEvent1(String title){
		super(title);
		good.add("小可");				//向列表框添加项目
		good.add("text");
		good.add("geeksun");
		good.add("gogo");
		good.add("google");
		good.add("music");
		good.add("run");
		good.addItemListener(this);		//向列表框注册项目事件监听者
		
		add(good, "North");				//向框架添加列表框单行文本框
		add(tf, "Center");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ItemEvent1 ie = new ItemEvent1("处理项目事件");
		ie.pack();
		ie.setVisible(true);
	}

	public void itemStateChanged(ItemEvent e) {		//处理ItemEven事件
		// TODO Auto-generated method stub
		if(e.getSource() == good)					//若事件源为 good 将列表框中被选中的项目显示在 TextField 中
			tf.setText(good.getSelectedItem());
		
		//输出事件源中被选中的项目（项目编号）
		System.out.println(e.getItem());
	}

	
}
