package com.base.swing;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * @author ��־ǿ
 * @comment: ����һ���Ի����������ü��ظöԻ���Ŀ�ܵı��⡣
 * @create at 2009-4-22
 */
public class TitleFrame extends JFrame {
	
    public TitleFrame() {
        super("Title Frame");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        String response = JOptionPane.showInputDialog(null,
            "Enter a Title for the Frame:");
        setTitle(response);
    }

    public static void main(String[] arguments) {
        JFrame frame = new TitleFrame();
    }
    
}

