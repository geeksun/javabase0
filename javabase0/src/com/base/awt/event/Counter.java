package com.base.awt.event;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author 姜志强
 * @annotation: 简单的计算器程序 --> Page.312
 * @create at 2009-4-8
 */
public class Counter extends Frame implements ActionListener {
	
	public Counter(String title){
		super(title);
		TextField tf = new TextField(50);
		
		Button ce = new Button("C E");
		Button c = new Button("C");
		Button d = new Button("0");
		Button e = new Button("1");
		Button f = new Button("2");
		Button g = new Button("3");
		Button h = new Button("4");
		Button i = new Button("5");
		Button j = new Button("6");
		Button k = new Button("7");
		Button l = new Button("8");
		Button m = new Button("9");
		Button sign = new Button("+/-");
		Button point = new Button(".");
		Button plus = new Button("+");
		Button decrease = new Button("-");
		Button multiply = new Button("*");
		Button division = new Button("/");
		Button result = new Button("=");
		
		add(tf, BorderLayout.NORTH);
		add(ce);
		add(c);
		add(d);
		add(e);
		add(f);
		add(g);
		add(h);
		add(i);
		add(j);
		add(k);
		add(l);
		add(m);
		add(sign);
		add(point);
		add(plus);
		add(decrease);
		add(multiply);
		add(division);
		add(result);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Counter count = new Counter("计算器");
		count.setLayout(new FlowLayout());
		count.pack();
		count.setVisible(true);
		
	}

}
