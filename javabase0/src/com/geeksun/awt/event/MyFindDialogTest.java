package com.geeksun.awt.event;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author 姜志强
 * @annotation: 提供查找 TextArea 中特定字符串的功能;也可以查找并替换字符串。
 * @create at 2009-4-6
 */
class MyFindDialog extends Dialog implements ActionListener{
	
	//创建对话框所使用的组件
	private Label lFind = new Label("待查字符串");
	private Label lReplace = new Label("替换字符串");
	private TextField tFind = new TextField(10);	//接收待查字符串的TextField
	private TextField tReplace = new TextField(10);	//接收要替换字符串的 TextField
	private Button bFind = new Button("查找");
	private Button bReplace = new Button("替换");	//替换按钮
	
	private TextArea ta;					//ta 为含有待查字符串的 TextField
	
	public MyFindDialog(Frame owner, TextArea ta){
		super(owner,"查找",false);		//非模式对话框
		this.ta = ta;
		setLayout(null);
		
		//设定组件的位置大小
		lFind.setBounds(10, 30, 80, 20);
		lReplace.setBounds(10, 70, 80, 20);
		tFind.setBounds(90, 30, 90, 20);
		tReplace.setBounds(90, 70, 90, 20);
		bFind.setBounds(190, 30, 80, 20);
		bReplace.setBounds(190, 70, 80, 20);
		
		//添加组件
		add(lFind);	add(tFind);	add(bFind);	add(lReplace);
		add(tReplace);	add(bReplace);
		
		//禁止用户调整对话框的大小
		setResizable(false);
		
		//为两个按钮注册动作事件监听器
		bFind.addActionListener(this);
		bReplace.addActionListener(this);
		
		//为对话框注册关闭窗口事件监听器
		addWindowListener(new WindowAdapter(){
			//使用内部类
			public void WindowClosing(WindowEvent e){
				MyFindDialog.this.dispose();
			}
		});
	}
	
	public void showFind(){
		setTitle("查找");		//将对话框标题设为“查找”
		setSize(280, 60);		//将对话框大小设定为合适大小
		setVisible(true);
	}
		
	public void showReplace(){
		setTitle("查找替换");
		setSize(280, 110);
		setVisible(true);
	}
	
	/**
	 *  查找
	 */
	private void find(){
		String text = ta.getText();		//从ta 中获取字符串，并存入 text 中
		String str = tFind.getText();	//获取 tFind 字符串，并存入 str 中
		int end = text.length();	//获取ta 字符串的长度
		int len = str.length();		//获取 tFind 字符串的长度
		int start = ta.getSelectionEnd();	//从光标位置开始查找字符串
		if(start == end)	start = 0;		//若光标位于末尾，则从头开始查找
		//System.err.println("search value:"+text);
		for(;start<=end-len;start++){
			if(text.substring(start, start + len).equals(str)){		//若找到查找字符串
				ta.setSelectionStart(start);		//选中并显示字符串
				ta.setSelectionEnd(start + len);
				//System.err.println("start value:"+start);
				return;			//退出方法
			}
		}
		//System.err.println("no search value");
		//若找不到待查字符串，则将光标置于末尾
		ta.setSelectionStart(end);
		ta.setSelectionEnd(end);
	}
	
	/**
	 *  替换
	 */
	private void replace(){
		String str = tReplace.getText();		//获取待查字符串
		
		//若选中的字符串与待查字符串一致，则将其替换为替换字符串
		//若选中的字符串与待查字符串不一致， 则继续查找
		if(ta.getSelectedText().equals(tFind.getText()))
			ta.replaceRange(str, ta.getSelectionStart(), ta.getSelectionEnd());
		else
			find();
			
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == bFind){			//按下查找按钮，调用find()方法
			//System.err.println("search");
			find();
		}
		else if(e.getSource() == bReplace)	//按下替换按钮，调用 replace() 方法
			replace();
	}
}

public class MyFindDialogTest {
	public static void main(String[] args) {
		Frame f = new Frame("MyFindDialog Test");
		TextArea ta = new TextArea();
		
		f.add(ta);
		MyFindDialog fDlg = new MyFindDialog(f, ta);	//查找，替换对话框
		f.setSize(300, 300);
		f.setVisible(true);
		fDlg.showReplace();								//显示查找替换对话框
	}

}
