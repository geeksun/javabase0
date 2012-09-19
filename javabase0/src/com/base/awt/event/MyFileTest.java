package com.base.awt.event;

import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author 姜志强
 * @annotation: 为文件的打开与保存提供了极大的方便，并且它拥有文件对话框成员。
 * @create at 2009-4-6
 */
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

public class MyFileTest {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Frame f = new Frame("MyFile Test");
		TextArea ta = new TextArea();
		f.add(ta);
		f.setSize(300, 300);
		f.setVisible(true);
		MyFile file = new MyFile(f);		//创建指定f 为其所有者的 MyFile 类对象
		
		try{
			ta.setText(file.getData());		//从文件中读取数据 ta,并显示在 ta 中
			file.setData(ta.getText());		//将 ta 中的内容存储在文件中
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
}
