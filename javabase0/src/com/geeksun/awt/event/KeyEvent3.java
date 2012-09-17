package com.geeksun.awt.event;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author 姜志强
 * @annotation: 游戏中做的键盘处理，点击方向键（左，右，上，下），"man"按钮会移动。但是，当失去了焦点，
 * 				KeyEvent就不会发生。KeyEvent事件只在拥有焦点的组件上发生。
 * @create at 2009-4-6
 */
public class KeyEvent3 extends Frame {

	Button man;
	public KeyEvent3(String title){
		super(title);
		setLayout(null);
		this.setSize(200, 200);
		
		man = new Button("man");	//产生KeyEvent事件的按钮
		man.setBounds(100, 100, 40, 20);	//设定按钮位置与大小
		man.setBackground(Color.BLUE);		//设定按钮的背景色为蓝色
		man.setForeground(Color.WHITE);		//将按钮的前景色设为白色
		
		this.add(man);						//向框架添加按钮
		man.addKeyListener(new KeyHandler());	//注册键盘事件监听对象
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KeyEvent3 ke = new KeyEvent3("活用 Key 事件");
		ke.setVisible(true);
	}

	class KeyHandler extends KeyAdapter{	//处理键盘事件的类
		public void keyPressed(KeyEvent e){	//按下键时被活用
			String direction = e.getKeyText(e.getKeyCode());	//接收 keyText
			int x = man.getX();		//man的x坐标
			int y = man.getY();		//man的y坐标
			
			//根据 keyText 的值，变换坐标
			if(direction.equals("Right")) 	x += 10;
			else if(direction.equals("Left"))	x -= 10;
			else if(direction.equals("Down"))	y += 10;
			else if(direction.equals("Up"))	y -= 10;
			
			man.setLocation(x, y);		//设定按钮的位置
		}
	}
}
