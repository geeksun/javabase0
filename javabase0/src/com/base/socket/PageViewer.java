package com.base.socket;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import com.geeksun.awt.event.CloseFrameDialog;

/**
 * @author 姜志强
 * @annotation: 操作 URL ，读取URL中的内容，URL包含protocal,port,host,file name。
 * @create at 2009-4-20
 */
public class PageViewer extends Frame {
	
	private TextField tURL = new TextField("");		//用于输 URL 的文本单行文本框
	
	//显示 Web 网页源代码的多行文本框
	private TextArea tPage = new TextArea();
	
	private BufferedReader reader;		//输入流
	
	public PageViewer(String title){
		super(title);
		tPage.setEditable(false);
		add(tURL, "North");
		add(tPage, "Center");
		
		//注册动作事件监听器
		tURL.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				try{
					//读取 web 网页
					readPage(new URL(tURL.getText()));
				}catch(Exception e){
					tPage.setText("URL错误");
				}
			}
		});
		
		//使用匿名类来进行事件处理，创建 WindowListener 对象
		WindowListener winHandler = new WindowAdapter(){
		public void windowClosing(WindowEvent e){
			//this指WindowEvent3的对象，即框架对象。
			CloseFrameDialog d = new CloseFrameDialog(PageViewer.this, "关闭", "确实要关闭吗？");
			
			d.setSize(200, 100);
			d.setVisible(true);
			}
		};

		addWindowListener(winHandler);		//注册事件监听者
	}
	
	/**
	 * @param url
	 * 读取 url 对象所引用的 web 网页内容
	 */
	void readPage(URL url){
		tPage.setText("");
		String line;
		try{
			//获取 url 输入流
			reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
			
			//读取一行，并添加至 tPage 中
			while((line=reader.readLine())!=null){
				tPage.append(line + "\n");
			}
		
		}catch(Exception e){
			tPage.setText("发生输入输出异常");
			e.printStackTrace();
		}finally{
			try{
				if(reader!=null)
					reader.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PageViewer me = new PageViewer("Page Viewer");
		me.setSize(400, 400);
		me.setVisible(true);
		
	}

}
