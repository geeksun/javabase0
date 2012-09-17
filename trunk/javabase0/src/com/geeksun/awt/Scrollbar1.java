package com.geeksun.awt;

import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Scrollbar;

public class Scrollbar1 {

	/**
	 * @throws InterruptedException 
	 * @see 滚动条
	 */
	public static void main(String[] args) throws InterruptedException {
		Frame f = new Frame("调制颜色");
		Panel p = new Panel();	//显示颜色的面板
		Label l = new Label("0,0,0");	//显示颜色的RGB值
		
		p.setBackground(new Color(0,0,0));	//将面板的颜色设为黑色
		
		//Red, Green, Blue滚动条
		//方向＝水平，value=0,可视量=1,最小值=0
		//最大值=256
		Scrollbar sRed = new Scrollbar(Scrollbar.HORIZONTAL,0,1,0,256);	//水平滚动条
		Scrollbar sGreen = new Scrollbar(Scrollbar.HORIZONTAL,0,1,0,256);
		Scrollbar sBlue = new Scrollbar(Scrollbar.HORIZONTAL,0,1,0,256);
	
		f.setLayout(new GridLayout(5, 1));
		
		f.add(p);	//添加组件
		f.add(l);
		f.add(sRed); 
		f.add(sGreen);
		f.add(sBlue);
		
		f.pack();
		f.setVisible(true);
		
		Color col;
		int nRed, nGreen, nBlue;
		
		//每隔 0.1 秒，将 Scrollbar 的value指定为 panel 的颜色
		while(true){
			nRed = sRed.getValue();	//获取并存储相应的滚动条值
			nGreen = sGreen.getValue();
			nBlue = sBlue.getValue();
			
			//使用 RGB 值创建颜色 col
			col = new Color(nRed, nGreen, nBlue);
			
			p.setBackground(col);	//将颜色 col 设为p 的背景色
			
			//在标签 l 中显示RGB值
			l.setText(nRed+","+nGreen+","+nBlue);
			
			Thread.sleep(100);
		}
		
	}

}
