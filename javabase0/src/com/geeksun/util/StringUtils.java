package com.geeksun.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 姜志强
 *  公共方法类
 *  2009-6-2
 */
public class StringUtils {

	/**
	 * 判断字符串是否为空
	 * @param str
	 * @return boolean value
	 */
	public final static boolean isBlank(String str){
		return  str == null||str.trim().equals("") ;
	}
	
	/**
	 * 格式化数字, 截取小数点后两位
	 * @param d
	 * @return
	 */
	public final static String trunkIntercept(Double d){
		if (d == null)
			return null;
		String format = "###0.00";
		DecimalFormat formater = new DecimalFormat(format);
		String trunkValue = formater.format(d);
		return trunkValue; 
	}
	
	/**
	 * 替换字符串
	 * @param str
	 * @return
	 */
	public final static String replaceAll(String str){
		String temp = str.replaceAll("\\s+", "|");
		System.out.println(temp);
		temp = temp.replaceAll("^&|&$", "");
		System.err.print(temp);
		return temp;
	}
	
	/**
	 * @param str
	 * @return  去除前缀中的"-"
	 */
	static final String removePrifix(String str){
		if(str.startsWith("-")){ 
			str = str.substring(1);
			return removePrifix(str);
		}else{
			return str;
		}
	}
	
	/**
	 * @param str
	 * @return 去除后缀中的"-"
	 */
	static final String removePostfix(String str){
		if(str.endsWith("-")){ 
			str = str.substring(0, str.length()-1);
			return removePostfix(str);
		}else{
			return str;
		}
	}
	
	/**
	 * @param str
	 * @return 将非字母和数字的符号转换为“-”
	 */
	static final String transit(String str){
		int len = str.length();
		for(int i=0;i<len;i++){
			char c = str.charAt(i); 
			String s = String.valueOf(c);
			if(!s.matches("[a-zA-Z]")&&!s.matches("[0-9]")){
				str = str.replace(s, "-");
			}
		}
		return str;
	}
	
	/**
	 * 获取日期及时间字符串
	 * @param date
	 * @return
	 */
	public static synchronized String getDateTimeString(Date date) {
		if (date == null)
			return null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm");
		return sdf.format(date);
	}
	
	/**
	 * 分隔数字用, 每3个数字用1个,
	 * @param i
	 * @return
	 */
	static final String splitWithSymbol(int intValue){
		String str = Integer.toString(intValue);
		String s = null;
		int length = str.length();
		if(length==3){
			return str;
		}
		if(6>=length&&length>3){
			s = str.substring(0, length-3) +"," + str.substring(length-3);
		}
		if(9>length&&length>6){
			s = str.substring(0, length-6) +"," + str.substring(length-6, length-3) + "," + str.substring(length-3);
		}
		return s;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		replaceAll("(watch)!&(TAG)&st=0&e=20");

	}

}
