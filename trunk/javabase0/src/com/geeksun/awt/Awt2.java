package com.geeksun.awt;

import java.awt.Frame;

public class Awt2 {

	/**
	 * @param args  
	 * @throws InterruptedException    
	 */
	public static void main(String[] args) throws InterruptedException {
		Frame f = new Frame("组件的大小与位置");		//创建Frame对象
		f.setVisible(true);					//显示Frame对象
		for(int i=1;i<=5;i++){				//循环5次
			f.setSize(i*100, i*100);		//改变f的大小
			f.setLocation(i*10, i*10);		//改变f的位置：move
			System.out.println("宽度= " + f.getWidth());		//输出f的宽度
			Thread.sleep(1000);			//休眠1秒钟
		}
	}

}
