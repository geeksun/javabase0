package com.geeksun.common;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author geeksun ʱ�乤����
 */
public class DateUtils {
	/**
	 * ʱ��ת��,��StringתΪDate��
	 * @param adateStrteStr
	 * @param format
	 * @return
	 */
	public static Date convertDate(String adateStrteStr, String format) {
		java.util.Date date = null;
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
			ParsePosition pos = new ParsePosition(0);
			date = simpleDateFormat.parse(adateStrteStr,pos);
		} catch (Exception e) {
			// LogHome.getLog().error("", ex);
			System.out.println(e);
		}
		return date;
	}

	public static Date test(String format) throws ParseException{
		SimpleDateFormat formatter = new SimpleDateFormat(format);//format��ʽ��"yyyy-MM-dd"
	    ParsePosition pos = new ParsePosition(0);
	   // Date strtodate = formatter.parse(adateStrteStr, pos);
	    
	    String sDate = "2008-04-07";
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    Date date = sdf.parse(sDate);
	    
	    return date; 
	}

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		String str = "2008-7-7";
		System.out.println(convertDate(str,"yyyyMMdd"));
		System.out.println(test("yyyy-MM-dd")); 
		
		Date date=null;
		SimpleDateFormat fordate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		date=fordate.parse("2006-07-15 15:30:36");
		System.out.println(fordate.format(date));  
	}

}
