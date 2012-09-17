package com.base.core;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 姜志强
 * 时间格式化
 */
public class DateFormat {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Date d = new Date();
		SimpleDateFormat f = new SimpleDateFormat("今天是"+"yyyy年MM月dd日 E kk点mm分"); 
		System.out.println(f.format(d)); 
		f = new SimpleDateFormat("a hh点mm分ss秒"); 
		System.out.println(f.format(d));
		SimpleDateFormat ff = new SimpleDateFormat("yyyy-mm-dd");
		String fd = ff.format(d);
		System.out.println(fd);
	}

}
