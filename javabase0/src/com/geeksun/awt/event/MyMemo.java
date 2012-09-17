package com.geeksun.awt.event;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author 姜志强
 * @annotation: 记事本
 * @create at 2009-4-6
 */
public class MyMemo extends Frame implements ActionListener {
	
	private TextArea editor = new TextArea();		//可编辑的 TextArea
	private MyFile mf = new MyFile(this);			//MyFile 对象
	private MyClipboard cb = new MyClipboard();		//MyClipboard 对象
	private MyFindDialog findDlg = new MyFindDialog(this, editor);		//查找对话框
	
	public MyMemo(String title){
		super(title);
		MyMenuBar mb = new MyMenuBar(this);			//添加MyMenuBar对象
		
		//添加需要的菜单及菜单项
		mb.addMenus(new String[]{"文件","编辑","查找","帮助"});
		mb.addMenuItems(0, new String[]{"新建","打开","保存",null,"退出"});
		mb.addMenuItems(1, new String[]{"剪贴","复制","粘贴","清除",null,"全选"});
		mb.addMenuItems(2, new String[]{"查找",null,"查找替换"});
		mb.addMenuItems(3, new String[]{"我的记事本信息"});
		
		add(editor);
		mb.addActionListener(this);		//为菜单项注册动作事件监听器
		
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				MyMemo.this.dispose();
			}
		});
	}
	
	public void actionPerformed(ActionEvent e) {
		String selected = e.getActionCommand();		//获取菜单项标题
		
		if(selected.equals("新建")){		//若选中“新建”菜单项
			editor.setText("");			//清除 editor 的内容
			
		}else if(selected.equals("打开")){
			try{
				editor.setText(mf.getData());	//读取文件对话框中被选中的文件
			}catch(Exception ie){
				ie.printStackTrace();
			}
		}else if(selected.equals("保存")){
			try{
				mf.setData(editor.getText());	//保存至文件对话框中被选中的文件
			}catch(Exception iie){
				iie.printStackTrace();
			}
		}else if(selected.equals("退出")){
			dispose();			
		}else if(selected.equals("剪贴")){
			//将选中的字符串复制到剪贴板中并清除字符串
			cb.setData(editor.getSelectedText());
			
			editor.replaceRange("", editor.getSelectionStart(), editor.getSelectionEnd());
		}
		else if(selected.equals("复制")){
			//将选中的字符串复制到剪贴板中
			cb.setData(editor.getSelectedText());
		}else if(selected.equals("粘贴")){
			//从剪贴板读取字符串，并粘贴至光标位置
			String str = cb.getData();
			
			editor.replaceRange(str, editor.getSelectionStart(), editor.getSelectionEnd());
		}
		else if(selected.equals("清除")){
			//清除所选中的字符串
			editor.replaceRange("", editor.getSelectionStart(), editor.getSelectionEnd());
		}
		else if(selected.equals("全选")){
			//选中所选内容
			editor.setSelectionStart(0);
			editor.setSelectionEnd(editor.getText().length());
		}
		else if(selected.equals("查找")){
			findDlg.showFind();			//显示查找对话框
		}
		else if(selected.equals("查找替换")){
			findDlg.showReplace();		//显示查找替换对话框
		}
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyMemo mm = new MyMemo("我的记事本");
		mm.setSize(200, 200);
		mm.setVisible(true);
		
	}

}
