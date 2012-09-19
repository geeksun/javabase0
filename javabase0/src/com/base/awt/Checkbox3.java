package com.base.awt;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Frame;
import java.awt.GridLayout;

public class Checkbox3 {

	/**
	 * @param args
	 * @throws InterruptedException 
	 *  有趣的程序设计：跳动的光点
	 */
	public static void main(String[] args) throws InterruptedException {
		Frame f = new Frame("有趣的程序设计");
		f.setLayout(new GridLayout(10, 10));	//GridLayout 布局， 10行×10列
		
		CheckboxGroup cbg = new CheckboxGroup();	//复选框组
		Checkbox[] cb = new Checkbox[100];		//cb.leng == 100
		
		for(int i=0;i<cb.length;i++){
			cb[i] = new Checkbox("", false, cbg);	//创建复选框， cb[0]~cb[99]
			f.add(cb[i]);						//添加到 frame 中
		}
		
		f.pack();
		f.setVisible(true);						//显示 frame
		
		int a = 0;
		while(true){
			cb[a].setState(true);				//将 cb[a] 状态设定为 true, a在0～99之间
			Thread.sleep(50); 
			a++;								//将 a 增1
			if(a>=cb.length)	a = 0;			//若 a 大于100， 则将a 置0
		}
	}

}
