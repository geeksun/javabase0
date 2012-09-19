package com.base.swing;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author 姜志强： Swing 工程中，首先关心的是布局， 然后才是功能。
 * @see Swing 颜色测试,可选择 RGB或HSB来调整颜色。
 * @create at 2009-4-24
 */
public class SwingColorTest extends JFrame {
	SwingColorControls RGBcontrols, HSBcontrols;
	JPanel swatch;
	
	public SwingColorTest(){
		super("Color Test");
		setSize(400, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel pane = new JPanel();
		GridLayout grid = new GridLayout(1, 3, 5, 15);
		pane.setLayout(grid);
		swatch = new JPanel();
		swatch.setBackground(Color.black);
		String[] rgbLabels = {"Red", "Green", "Blue"};
		RGBcontrols = new SwingColorControls(this, rgbLabels);
		String[] hsbLabels = {"Hue", "Saturation", "Brightness"};
		HSBcontrols = new SwingColorControls(this, hsbLabels);
		pane.add(swatch);
		pane.add(RGBcontrols);
		pane.add(HSBcontrols);
		setContentPane(pane);
		pack();
		setVisible(true);
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new SwingColorTest();
	}


	public void update(SwingColorControls control) {
		Color c;
		
		int[] value = new int[3];
		for(int i=0;i<3;i++){
			value[i] = Integer.parseInt(control.setting[i].getText());
			if((value[i]<0)||(value[i]>255)){
				value[i] = 0;
				control.setting[i].setText("" + value[i]);
			}
		}
		
		if(control == RGBcontrols){
			c = new Color(value[0], value[1], value[2]);
			
			float[] hsbValues = new float[3];
			float[] HSB = Color.RGBtoHSB(value[0], value[1], value[2], hsbValues);
			HSB[0] *= 360;
			HSB[1] *= 100;
			HSB[2] *= 100;
			
			for(int i=0;i<3;i++){
				HSBcontrols.setting[i].setText(String.valueOf((int)HSB[i]));
				
			}
			
		}else{
			c = Color.getHSBColor((float)value[0]/360, (float)value[0]/100, (float)value[0]/100);
			//reset RGB fields
			RGBcontrols.setting[0].setText(String.valueOf(c.getRed()));
			RGBcontrols.setting[0].setText(String.valueOf(c.getGreen()));
			RGBcontrols.setting[0].setText(String.valueOf(c.getBlue()));
		}
		
		//update swatch
		swatch.setBackground(c);
		swatch.repaint();
	}

}
/**
 * @author 姜志强
 * 从 JPanel 类派生而来，表示三个文本框，并处理他们的事件。
 */
class SwingColorControls extends JPanel implements ActionListener, FocusListener{
	SwingColorTest frame;
	JTextField[] setting = new JTextField[3];
	
	SwingColorControls(SwingColorTest parent, String[] label){
		frame = parent;
		GridLayout cGrid = new GridLayout(3, 2, 10, 10);
		setLayout(cGrid);
		for(int i=0;i<3;i++){
			setting[i] = new JTextField("0");
			setting[i].addFocusListener(this);
			setting[i].addActionListener(this);
			JLabel settingLabel = new JLabel(label[i], JLabel.RIGHT);
			add(settingLabel);
			add(setting[i]);
		}
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() instanceof JTextField)
			frame.update(this);
	}

	public void focusGained(FocusEvent e) {
	}

	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		frame.update(this);
	}
	
}
