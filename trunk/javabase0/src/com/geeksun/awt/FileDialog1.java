package com.geeksun.awt;

import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author 姜志强
 *  文件对话框：继承了Dialog类，在打开或保存文件时使用。自动设定为模式对话框，分为打开对话框和另存为对话框。
 */
public class FileDialog1 extends Frame {	//继承自 Frame 类
	FileDialog fopen;			//文件对话框
	TextArea ta;				//显示文件内容的TextArea
	
	public FileDialog1(String title){
		super(title);	//设定窗口标题
		ta = new TextArea();
		add(ta);
		setSize(300, 300);	//设定大小
	}
	
	//显示文件对话框，并获取选中文件的名称
	public String showLoad(){
		fopen = new FileDialog(this, "打开文件", FileDialog.LOAD);	//打开模式
		fopen.setVisible(true);		//显示文件对话框，this处于等待状态
		//关闭文件对话框，才继续执行
		String fileName = fopen.getFile();	//fileName 保存选中文件的名称
		String fileDir = fopen.getDirectory();	//fileDir 保存选中文件的目录
		
		if(fileName==null){
			return null;
		}
		
		return fileDir+"\\"+fileName;	//获取文件的绝对目录
		
	}
	
	//读取文件内容，并显示在 ta 中
	public void loadFile(String fileName) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String aline;
		while((aline = br.readLine())!=null){
			ta.append(aline+'\n');
		}
		br.close();
	}
	
	/**
	 *   显示“另存为”对话框
	 */
	public void showSave(){		
		fopen = new FileDialog(this, "保存文件", FileDialog.SAVE);	//打开模式为另存为
		fopen.setVisible(true);
		//关闭文件对话框，才继续执行
		String fileName = fopen.getFile();	//fileName 保存选中文件的名称
		String fileDir = fopen.getDirectory();	//fileDir 保存选中文件的目录
		
		if(fileName==null){
			return;
		}

	}
	
	/**
	 *  何解？
	 */
	public void saveFile(){
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileDialog1 fd = new FileDialog1("文件");
		String fileName;
		
		//若文件名不存在，则输入相应的提示信息
		if((fileName=fd.showLoad())==null)
			System.out.println("尚未选取文件");
		else{
			//读取文件
			try{
				fd.loadFile(fileName);
			}catch(IOException e){
				System.err.println(e);
			}
		}
		fd.setVisible(true);		//显示窗口
	}

}
