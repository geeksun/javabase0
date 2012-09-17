package com.base.applet;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.TextArea;

public class Applet2 extends Applet {
	//显示方法调用时机及次数的多行文本框
	TextArea ta = new TextArea();
	
	//记录方法调用的次数
	static int objectCount, initCount, startCount, stopCount, destoryCount;
	
	static String info = "";		//显示方法调用顺序与次数的字符串对象
	
	public Applet2(){
		setLayout(new BorderLayout());	//设定 Applet 布局
		add(ta);		//添加多行文本框
		objectCount++;	//记录 init()方法调用次数
		info += "对象创建次数: " + objectCount + "\n";
		ta.setText(info);
	}
	
	public void start(){	//启动 Applet
		startCount++;
		info += "start()调用次数：" + startCount + "\n";
		ta.setText(info);
		
	}
	
	public void stop(){		//暂停 Applet
		stopCount++;
		info += "stop()调用次数：" + stopCount + "\n";
		ta.setText(info);
		
	}
	
	public void destory(){		//暂停 Applet
		destoryCount++; 
		info += "destory()调用次数：" + destoryCount + "\n";
		ta.setText(info);
		
	}
	
}
