package com.sun.common;
import java.util.Date;
import java.text.*;
/**
 * @author Administrator
 * @version : 格式式的使用
 */
public class Formate {
	public void format(){
		// 格式化日期
		DateFormat df=DateFormat.getInstance();
		Date d = new Date();
		df.format(d);
	}
}
