package com.geeksun.swing;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;

/**
 * @author ��־ǿ
 * @serial ���飺WellAdjusted.java Ϊ������
 * @create at 2009-4-22
 */
public class Slider extends JFrame {
	
	public Slider(){
		super("Slider ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//ˮƽ����Сֵ�����ֵ���ͳ�ʼֵ�Ļ���
		JSlider pickNum = new JSlider(JSlider.HORIZONTAL, 0, 30, 5);
		pickNum.setMajorTickSpacing(10);	//���̶���
		pickNum.setMinorTickSpacing(1);		//�ο̶���
		pickNum.setPaintTicks(true);		//�Ƿ���ʾ�̶���
		pickNum.setPaintLabels(true);		//�Ƿ���ʾ���ֱ�ǩ
		JPanel pane = new JPanel();
		pane.add(pickNum);
		
		setContentPane(pane);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Slider frame = new Slider();
		frame.pack();
		frame.setVisible(true);
	}

}
