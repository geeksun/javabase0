package com.sun.common;
import java.util.Date;
import java.text.*;
/**
 * @author Administrator
 * @version : ��ʽʽ��ʹ��
 */
public class Formate {
	public void format(){
		// ��ʽ������
		DateFormat df=DateFormat.getInstance();
		Date d = new Date();
		df.format(d);
	}
}
