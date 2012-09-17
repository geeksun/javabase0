package com.geeksun.swing;

import java.awt.BorderLayout;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * @author ��־ǿ
 * @comment: �����¼������������ʱ�������磺�ƶ��������ϵĻ���ʱ������Slider.javaͬ
 * @create at: 2009��4��24
 */
public class WellAdjusted extends JFrame implements AdjustmentListener {
	JTextField value = new JTextField("50", 30);
	//������
	JScrollBar bar = new JScrollBar(SwingConstants.HORIZONTAL, 50, 10, 0, 100);
	
	public WellAdjusted(){
		super("Well Adjusted");
		setSize(350, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		bar.addAdjustmentListener(this);
		value.setEditable(true);
		JPanel pane = new JPanel();
		pane.setLayout(new BorderLayout());
		pane.add(value, "Center");
		pane.add(bar, "South");
		setContentPane(pane);
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new WellAdjusted();
		frame.setVisible(true);
	}

	public void adjustmentValueChanged(AdjustmentEvent e) {
		Object source = e.getSource();
		if(source == bar){
			int newValue = bar.getValue();
			value.setText("" + newValue);
		}
		repaint();
	}

}
