package com.base.swing;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author ½ªÖ¾Ç¿
 * @annotation: ²¥·ÅÆ÷
 * @create at 2009-4-21
 */
public class VCR extends JFrame {
    JButton play = new JButton("Play");
    JButton stopEject = new JButton("Stop/Eject");
    JButton rewind = new JButton("Rewind");
    JButton fastForward = new JButton("Fast Forward");
    JButton pause = new JButton("Pause");
    
    public VCR() {
        super("VCR");
        setSize(540, 80);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel pane = new JPanel();
        pane.add(play);
        pane.add(stopEject);
        pane.add(rewind);
        pane.add(fastForward);
        pane.add(pause);
        setContentPane(pane);
        setVisible(true);
}

    public static void main(String[] arguments) {
        VCR vcr = new VCR();
    }
}


