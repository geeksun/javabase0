package com.base.awt;

import java.awt.Frame;
import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextArea1 {

	/**
	 * 多行文本框
	 * @since jdk 1.5
	 * @param args 
	 * @throws IOException    
	 */
	public static void main(String[] args) throws IOException {
		Frame f = new Frame("查看文件");
		TextArea ta = new TextArea(20, 50);		//show file content 
		String aline;							//保存从文件中读取的数据
		
		//System.out.println(class.getClassLoader().getResource("").getPath());
		System.err.println(System.getProperty("user.dir"));
				
		//使用 BufferedReader, 每次从文件中读取一行数据
		BufferedReader br = new BufferedReader(new FileReader
			(
				"D:/work/mianshi/src/com/geeksun/awt/TextArea1.java")
			);
		
		while((aline=br.readLine())!=null)		//读取一行数据后，存入 aline 中
			ta.append(aline + '\n'); 			//x1, 将 aline 中的数据追加于 ta 尾部
		
			br.close();							//关闭流
			
			f.add(ta);
			f.pack();				//自动调整Frame的大小,使其可以显示其中所有的组件
			f.setVisible(true);
		
	}

}
