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
		
		// 在内存中创建图象
		int width = 60, height = 20;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		// 获取图形上下文
		Graphics g = image.getGraphics();
		
		// 生成随机类
		Random random = new Random();
		
		// 设定背景色
		g.setColor(getRandColor(200, 250));
		g.fillRect(0, 0, width, height);
		
		// 设定字体
		g.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		// 画边框
		// g.setColor(new Color());
		// g.drawRect(0,0,width-1,height-1);
		
		// 随机产生155条干扰线，使图象中的认证码不易被其它程序探测到
		g.setColor(getRandColor(160, 200));
		/*for (int i = 0; i 255) fc = 255;
		if (bc > 255) bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return  new Color(r, g, b);*/
	}
	//	 随机产生155条干扰线，使图象中的认证码不易被其它程序探测到
	public Color getRandColor(int fc, int bc) {//给定范围获得随机颜色
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