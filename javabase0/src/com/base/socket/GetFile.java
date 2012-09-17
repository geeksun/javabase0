package com.base.socket;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * @author 姜志强
 *  加载网上的文本并逐行读取其中的内容: 需要一个命令行参数，如 http://www.google.cn
 *  2009-4-26
 */
public class GetFile {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if(args.length == 1){
			PageFrame page = new PageFrame(args[0]);
			page.setVisible(true);
		}else
			System.out.print("Usage:java GetFile url");		
	}

}

class PageFrame extends JFrame{
	JTextArea box = new JTextArea("Getting data ...");
	URL page;
	
	public PageFrame(String address){
		super(address);
		setSize(600, 300);
		JScrollPane pane = new JScrollPane(box);
		getContentPane().add(pane);
		WindowListener l = new WindowAdapter(){
			public void WindowClosing(WindowEvent evt){
				System.exit(0);
			}
		};
		addWindowListener(l);
		
		try{
			page = new URL(address);
			getData(page);
		}catch(Exception e){
			System.err.print("Bab URL:" + address);
		}
	}
	
	void getData(URL url){
		URLConnection conn = null;
		InputStreamReader in;
		BufferedReader data;
		String line;
		StringBuffer buf = new StringBuffer();
		try{
			conn = this.page.openConnection();
			conn.connect();
			box.setText("Connection opened...");
			
			in = new InputStreamReader(conn.getInputStream());
			data = new BufferedReader(in);
			
			box.setText("\nReading data...");
			while((line=data.readLine())!=null)
				buf.append(line+"\n");
			
			box.setText(buf.toString());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}