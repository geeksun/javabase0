package com.geeksun.awt;

 import java.awt.*;  
 import javax.swing.*;  
 import java.awt.event.*;  
   
 /**
 * @author 姜志强
 * @annotation: awt 计算器
 * @reference at 2009-4-9
 */
public class JSQ1 {  
	 
     public static void main(String[] args) {  
         JSQFrame frame = new JSQFrame();  
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
         frame.show();  
     }  
 }  
   
 class JSQFrame extends JFrame {  
   
     public JSQFrame() {  
         JPanel panel = new JPanel();  
         text1 = new JTextField(35);  
         text1.setText("");  
         text1.setEditable(false);  
         panel.add(text1);  
   
         JSQPanel jsqpanel = new JSQPanel(this);  
   
         Container contentPane = getContentPane();  
         contentPane.add(panel, BorderLayout.NORTH);  
         contentPane.add(jsqpanel);  
   
         setSize(400, 200);  
         setTitle("计算器");  
         setResizable(false);  
     }  
     JTextField text1;  
 }  
   
 class JSQPanel extends JPanel implements ActionListener {  
   
     public JSQPanel(JSQFrame frame) {  
         this.frame = frame;  
         setLayout(new GridLayout(5, 5, 10, 5));  
   
         buttonBackSpace = new JButton("BS");  
         buttonCE = new JButton("CE");  
         buttonC = new JButton("C");  
   
         add(buttonBackSpace);  
         add(new JLabel());  
         add(buttonCE);  
         add(new JLabel());  
         add(buttonC);  
   
         for (int i = 7; i <= 9; i++) {  
             add(button[i] = new JButton("" + i));  
         }  
         buttonCHU = new JButton("/");  
         buttonSQRT = new JButton("sqrt");  
         add(buttonCHU);  
         add(buttonSQRT);  
   
         for (int i = 4; i <= 6; i++) {  
             add(button[i] = new JButton("" + i));  
         }  
         buttonCHENG = new JButton("*");  
         buttonPERCENT = new JButton("%");  
         add(buttonCHENG);  
         add(buttonPERCENT);  
   
         for (int i = 1; i <= 3; i++) {  
             add(button[i] = new JButton("" + i));  
         }  
         buttonJIAN = new JButton("-");  
         buttonX = new JButton("1/x");  
         add(buttonJIAN);  
         add(buttonX);  
   
         button[0] = new JButton("0");  
         buttonFU = new JButton("+/-");  
         buttonDIAN = new JButton(".");  
         buttonJIA = new JButton("+");  
         buttonDENG = new JButton("=");  
         add(button[0]);  
         add(buttonFU);  
         add(buttonDIAN);  
         add(buttonJIA);  
         add(buttonDENG);  
   
         for (int i = 0; i <= 9; i++) {  
             button[i].addActionListener(this);  
         }  
         buttonBackSpace.addActionListener(this);  
         buttonCE.addActionListener(this);  
         buttonC.addActionListener(this);  
         buttonCHU.addActionListener(this);  
         buttonSQRT.addActionListener(this);  
         buttonCHENG.addActionListener(this);  
         buttonPERCENT.addActionListener(this);  
         buttonJIAN.addActionListener(this);  
         buttonX.addActionListener(this);  
         buttonFU.addActionListener(this);  
         buttonDIAN.addActionListener(this);  
         buttonDENG.addActionListener(this);  
         buttonJIA.addActionListener(this);  
   
         String plaf = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";  
         try {  
             UIManager.setLookAndFeel(plaf);  
             SwingUtilities.updateComponentTreeUI(this);  
         } catch (Exception e) {  
         }  
   
     }  
   
     public void actionPerformed(ActionEvent event) {  
         for (int i = 0; i <= 9; i++) {  
             if (event.getSource() == button[i]) {  
                 frame.text1.setText(frame.text1.getText() + i);  
             }  
         }  
   
         if (event.getSource() == buttonJIA) {  
             if (!frame.text1.getText().equals("")) {  
                 DString = "";  
                 FUString = "";  
                 if (YSFString.equals("+")) {  
                     num1 = num1 + Double.parseDouble(frame.text1.getText());  
                     frame.text1.setText("");  
                 }  
   
                 if (YSFString.equals("")) {  
                     num1 = Double.parseDouble(frame.text1.getText());  
                     frame.text1.setText("");  
                     YSFString = "+";  
                 }  
             }  
         }  
   
         if (event.getSource() == buttonJIAN) {  
             if (!frame.text1.getText().equals("")) {  
                 DString = "";  
                 FUString = "";  
                 if (YSFString.equals("-")) {  
                     num1 = num1 - Double.parseDouble(frame.text1.getText());  
                     frame.text1.setText("");  
                 }  
   
                 if (YSFString.equals("")) {  
                     num1 = Double.parseDouble(frame.text1.getText());  
                     frame.text1.setText("");  
                     YSFString = "-";  
                 }  
             }  
         }  
         if (event.getSource() == buttonCHENG) {  
             if (!frame.text1.getText().equals("")) {  
                 DString = "";  
                 FUString = "";  
                 if (YSFString.equals("*")) {  
                     num1 = num1 * Double.parseDouble(frame.text1.getText());  
                     frame.text1.setText("");  
                 }  
   
                 if (YSFString.equals("")) {  
                     num1 = Double.parseDouble(frame.text1.getText());  
                     frame.text1.setText("");  
                     YSFString = "*";  
                 }  
             }  
         }  
         if (event.getSource() == buttonCHU) {  
             if (!frame.text1.getText().equals("")) {  
                 DString = "";  
                 FUString = "";  
                 if (YSFString.equals("/")) {  
                     num1 = num1 / Double.parseDouble(frame.text1.getText());  
                     frame.text1.setText("");  
                 }  
   
                 if (YSFString.equals("")) {  
                     num1 = Double.parseDouble(frame.text1.getText());  
                     frame.text1.setText("");  
                     YSFString = "/";  
                 }  
             }  
         }  
         if (event.getSource() == buttonDENG) {  
             DString = "";  
             FUString = "";  
             num2 = Double.parseDouble(frame.text1.getText());  
   
             if (YSFString.equals("+")) {  
                 result = num1 + num2;  
             }  
             if (YSFString.equals("-")) {  
                 result = num1 - num2;  
             }  
             if (YSFString.equals("*")) {  
                 result = num1 * num2;  
             }  
             if (YSFString.equals("/")) {  
                 result = num1 / num2;  
             }  
   
             frame.text1.setText("" + result);  
             YSFString = "";  
         }  
         if (event.getSource() == buttonC || event.getSource() == buttonCE) {  
             frame.text1.setText("");  
         }  
         if (event.getSource() == buttonDIAN) {  
             if ("".equals(DString)) {  
                 frame.text1.setText(frame.text1.getText() + ".");  
             }  
             DString = ".";  
         }  
         if (event.getSource() == buttonFU) {  
             if ("".equals(FUString)) {  
                 frame.text1.setText(frame.text1.getText() + "-");  
             }  
             FUString = "-";  
         }  
         if (event.getSource() == buttonSQRT) {  
             double d = 0;  
             if (!frame.text1.getText().equals("")) {  
                 d = Double.parseDouble(frame.text1.getText());  
             }  
             frame.text1.setText("" + Math.sqrt(d));  
         }  
         if (event.getSource() == buttonX) {  
             double d = 0;  
             if (!frame.text1.getText().equals("")) {  
                 d = Double.parseDouble(frame.text1.getText());  
                 d = 1 / d;  
                 frame.text1.setText("" + d);  
             }  
         }  
         if (event.getSource() == buttonPERCENT) {  
             if (!frame.text1.getText().equals("")) {  
                 double d = 0;  
                 d = Double.parseDouble(frame.text1.getText()) * 100;  
                 frame.text1.setText("" + d);  
             }  
         }  
         if (event.getSource() == buttonBackSpace) {  
             if (!frame.text1.getText().equals("")) {  
                 int length = 0;  
                 String string = "";  
                 length = (frame.text1.getText()).length();  
                 System.out.println(length);  
                 string = frame.text1.getText();  
                 String str = string.substring(0, length - 1);  
   
                 frame.text1.setText(str);  
             }  
         }  
     }  
     JButton button[] = new JButton[10];  
     JButton buttonBackSpace, buttonCE, buttonC, buttonCHU, buttonSQRT, buttonCHENG,  
             buttonPERCENT, buttonJIAN, buttonX, buttonFU, buttonDIAN, buttonDENG, buttonJIA;  
     JSQFrame frame;  
     double num1 = 0, num2 = 0, result = 0;  
     String YSFString = "", DString = "", FUString = "";  
 }  