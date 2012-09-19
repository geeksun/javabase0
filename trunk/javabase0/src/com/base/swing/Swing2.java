package com.base.swing;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * @author ��־ǿ
 * Swing �����ȫ
 * 2009-4-25
 */
public class Swing2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Swing");
		//�����ڹرգ�����ֹ����
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//��ȡ�� contentPane ������
		Container cp = frame.getContentPane();	//��ȡcontentPane����
		cp.setLayout(new FlowLayout());		//�趨 Layout
		
		cp.add(new JButton("��ť"));
		
		//��Ӵ�ͼƬ�İ�ť
		ImageIcon saveIcon = new ImageIcon("E:/gif/kiss.gif");
		cp.add(new JButton(saveIcon));
		
		//���JTextField
		JTextField tf = new JTextField("Hi~~~~~");
		tf.setBorder(new TitledBorder("����"));
		cp.add(tf);
		
		cp.add(new JSlider());		//��� JSlider ���
		
		//��� JProgressBar ���
		JProgressBar pb = new JProgressBar(JProgressBar.HORIZONTAL);
		pb.setStringPainted(true);
		pb.setValue(50);
		cp.add(pb);
		
		//��� List
		JList list = new JList(new String[]{"Java", "C++"});
		cp.add(list);
		
		//��� JcomboBox
		JComboBox combo = new JComboBox(new String[]{"Thinking", "Java"});
		cp.add(combo);
		
		frame.setSize(200, 200);
		frame.setVisible(true);
		
	  
		
	}

}
