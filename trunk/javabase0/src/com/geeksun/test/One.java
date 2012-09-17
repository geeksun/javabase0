package com.geeksun.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class One {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		String str="2008-11-02";
		SimpleDateFormat sd= new SimpleDateFormat("yyyy-MM-dd");
		Date date=sd.parse(str);
		System.out.println(date);
		
	}

}
