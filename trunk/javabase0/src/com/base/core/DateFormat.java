package com.base.core;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ��־ǿ
 * ʱ���ʽ��
 */
public class DateFormat {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Date d = new Date();
		SimpleDateFormat f = new SimpleDateFormat("������"+"yyyy��MM��dd�� E kk��mm��"); 
		System.out.println(f.format(d)); 
		f = new SimpleDateFormat("a hh��mm��ss��"); 
		System.out.println(f.format(d));
		SimpleDateFormat ff = new SimpleDateFormat("yyyy-mm-dd");
		String fd = ff.format(d);
		System.out.println(fd);
	}

}
