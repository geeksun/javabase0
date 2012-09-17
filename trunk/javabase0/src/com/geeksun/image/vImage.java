package com.geeksun.image;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.util.*;

import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;

public class vImage extends HttpServlet {
	public void init(ServletConfig conf) throws ServletException {
		super.init(conf);
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("image/jpeg");
		res.setHeader("Pragma", "No-cache");
		res.setHeader("Cache-Control", "no-cache");
		res.setDateHeader("Expires", 0);
		HttpSession session = req.getSession();
		
		// ���ڴ��д���ͼ��
		int width = 60, height = 20;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		// ��ȡͼ��������
		Graphics g = image.getGraphics();
		
		// ���������
		Random random = new Random();
		
		// �趨����ɫ
		g.setColor(getRandColor(200, 250));
		g.fillRect(0, 0, width, height);
		
		// �趨����
		g.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		// ���߿�
		// g.setColor(new Color());
		// g.drawRect(0,0,width-1,height-1);
		
		// �������155�������ߣ�ʹͼ���е���֤�벻�ױ���������̽�⵽
		g.setColor(getRandColor(160, 200));
		/*for (int i = 0; i 255) fc = 255;
		if (bc > 255) bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return  new Color(r, g, b);*/
	}
	//	 �������155�������ߣ�ʹͼ���е���֤�벻�ױ���������̽�⵽
	public Color getRandColor(int fc, int bc) {//������Χ��������ɫ
		Random random = new Random();
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}
}