package com.base.awt;

import java.awt.*;   
import java.awt.image.*;   
import java.io.*;   
import javax.imageio.*;   
import java.awt.font.*;   
import java.awt.geom.*;   
  
/**
 * Description 生成纯色图片
 * @author Administrator
 * 2013-3-12
 */
public class CreateImage    
{   
    public static void main(String[] args) throws Exception   
    {   
        int width = 1002;   
        int height = 278;   
        //String s = "你好";
           
        File file = new File("c:/image.jpg");   
           
        //Font font = new Font("Serif", Font.BOLD, 10);   
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);   
        Graphics2D g2 = (Graphics2D)bi.getGraphics();   
        g2.setBackground(new Color(147,14,6));   
        g2.clearRect(0, 0, width, height);   
        //g2.setPaint(Color.RED);  
        
        //Graphics2D g2 = bi.createGraphics();  
        //g2.setColor(new Color(249,13,6));
        //g2.setStroke(new BasicStroke(1));
           
        //FontRenderContext context = g2.getFontRenderContext();   
        //Rectangle2D bounds = font.getStringBounds(s, context);   
        //double x = (width - bounds.getWidth()) / 2;   
        //double y = (height - bounds.getHeight()) / 2;
        //double ascent = -bounds.getY();   
        //double baseY = y + ascent;   
           
        //g2.drawString(s, (int)x, (int)baseY);   
        g2.drawString("", width, height);
        //g2.dispose();
           
        ImageIO.write(bi, "jpg", file);   
    }   
}  