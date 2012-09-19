package com.base.awt;

import java.awt.Frame;
import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author 姜志强
 * @annotation: 实现在DOS 窗口输入字符串，并在TextArea显示出来的功能。见书上第277页。
 * create at 2009-4-2
 */
public class TextAreaExperience {
	public static void main(String[] args) throws IOException {
		Frame f = new Frame("TextAreaExperience");
		TextArea ta = new TextArea(20, 60);
		
		String aline;
		
		System.out.println("输入一行数据,并以Enter结束");
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
		
		label:while((aline = br.readLine())!=null){
			System.out.println("请继续输入数据,并以Enter结束");
			if(aline.equals("stop")){
				System.out.println("结束");
				br.close();
				System.exit(1);		//终止当前运行的虚拟机，非0表示异常终止
				break;
			}
			ta.append(aline+'\n');
			//br.close();
			
			f.add(ta);
			f.pack();	//自动调整Frame的大小,使其可以显示其中所有的组件
			f.setVisible(true);
			
			continue label;
		}
		
		//br.close();
	}

}
