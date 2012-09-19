package com.base.awt;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author 姜志强
 * @annotation: 记事本，参见com.geeksun.awt.event.MyMemo.java.
 * @create at 2009-4-8
 */
public class Notepad extends Frame implements ActionListener {
	
	private TextArea editor = new TextArea();		//可编辑的 TextArea
	private MyFile mf = new MyFile(this);			//MyFile 对象
	private MyClipboard cb = new MyClipboard();		//MyClipboard 对象
	private MyFindDialog findDlg = new MyFindDialog(this, editor);		//查找对话框
	
	public Notepad(String title){
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
				Notepad.this.dispose();
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
		Notepad pad = new Notepad("我的记事本");
		pad.setSize(200, 200);
		pad.setVisible(true);
	}

}

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

class MyClipboard{ 
	private Clipboard cb;	//剪切板
	
	public MyClipboard(){	//构造函数，获取系统剪切板
		cb = Toolkit.getDefaultToolkit().getSystemClipboard();
	}
	
	public void setData(String data){	//将字符串存入剪贴板
		cb.setContents(new StringSelection(data), null);
	}
	
	public String getData(){	//从剪贴板读取数据，并将其返回
		Transferable content = cb.getContents(null);
		
		try{
			return (String)content.getTransferData(DataFlavor.stringFlavor);
		}catch(Exception e){
			return null;
		}
	}
}

class MyFile{
	private FileDialog fDlg;	//文件对话框
	
	public MyFile(Frame parent){
		fDlg = new FileDialog(parent, "", FileDialog.LOAD);		//初始化文件对话框
	}
	
	private String getPath(){
		return fDlg.getDirectory() + "\\" + fDlg.getFile();		//返回选中文件的路径
	}
	
	public String getData() throws IOException{
		fDlg.setTitle("打开");		//设定文件对话框的标题为”打开“
		fDlg.setMode(FileDialog.LOAD);	//将文件对话框的模式设定为打开模式
		fDlg.setVisible(true);		//显示文件对话框
		
		//读取文件对话框选中文件的内容并将其返回
		BufferedReader br = new BufferedReader(new FileReader(getPath()));
		StringBuffer sb = new StringBuffer();
		String aline;
		while((aline = br.readLine()) != null){
			sb.append(aline + '\n');
		}
		br.close();
		return sb.toString();
	}
	
	public void setData(String data) throws IOException{
		//显示保存模式对话框，并将数据 data 存入选中的文件中
		fDlg.setTitle("保存");
		fDlg.setMode(FileDialog.SAVE);	
		fDlg.setVisible(true);
		BufferedWriter bw = new BufferedWriter(new FileWriter(getPath()));
		bw.write(data);
		bw.close();
	}
}

class MyMenuBar extends MenuBar{
	private static final long serialVersionUID = -6509201141315415912L;
	
	public MyMenuBar(Frame parent){
		parent.setMenuBar(this);			//向parent添加自身
	}
	
	public void addMenus(String[] menus){
		for(int i=0;i<menus.length;i++){	//循环0 ～ menus.length-1次
			add(new Menu(menus[i]));		//添加以menus[i]为标题的菜单
		}
	}
	
	public void addMenuItems(int menuNumber, String[] items){
		for(int i=0;i<items.length;i++){
			//若字符为null，则添加Separator,否则，添加菜单项
			if(items[i] != null)
				getMenu(menuNumber).add(new MenuItem(items[i]));
			else
				getMenu(menuNumber).addSeparator();
		}
	}
	
	public void addActionListener(ActionListener al){
		//循环得到菜单的个数
		for(int i=0;i<getMenuCount();i++){
			//循环到第i菜单的个数
			for(int j=0;j<getMenu(i).getItemCount();j++){
				//向第i菜单的第j个项目注册动作事件监听器
				getMenu(i).getItem(j).addActionListener(al);
			}
		}
	}
}