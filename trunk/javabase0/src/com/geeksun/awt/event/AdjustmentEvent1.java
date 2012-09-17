package com.geeksun.awt.event;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Scrollbar;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

/**
 * @author 姜志强
 * @annotation: 调整 Scrollbar和ScrollPane的大小,本例用于调整标签中的字体的大小。
 * @create at 2009-4-6
 */
public class AdjustmentEvent1 extends Frame implements AdjustmentListener {
	Scrollbar sb;		//AdjustmentEvent 的事件源 Scrollbar
	Label label;		//对滚动值大小不断发生变化的标签
	
	public AdjustmentEvent1(String title){
		super(title);
		label = new Label("Thinking in Java", label.CENTER);		//标签对象
		
		//水平滚动条，value=10,visibleAmount=1,minimum=1,maximum=300
		sb = new Scrollbar(Scrollbar.HORIZONTAL, 10, 1, 1, 300);
		
		add(label, "Center");
		add(sb, "South");
		
		sb.addAdjustmentListener(this);		//向 sb 注册 AdjustmentListener 事件监听对象
	}
	
	public void adjustmentValueChanged(AdjustmentEvent e) {	//处理事件
		//创建适合于标签的字体对象
		//字体大小＝滚动条的值（sb.getValue())
		Font font = new Font("TimesRoman", 1, sb.getValue());
		
		//改变标签字体
		label.setFont(font);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdjustmentEvent1 ae = new AdjustmentEvent1("处理调整事件");
		ae.setSize(300, 300);
		ae.setVisible(true);
	}

}
