package com.lifeopera.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author jzq 
 * 正则表达式 
 * 2009-4-30
 */
public class RegularTest {

	/**
	 * 传统方法：查询文本或字符串中是否有y和f字符
	 */
	static void method1() {
		String str = "For my money, the important thing "
				+ "about the meeting was bridge-building";
		char x = 'y';
		char y = 'f';
		boolean result = false;
		for (int i = 0; i < str.length(); i++) {
			char z = str.charAt(i); // System.out.println(z);
			if (x == z || y == z) {
				result = true;
				break;
			} else
				result = false;
		}
		System.out.println(result);
	}

	/**
	 * 查找
	 */
	static void method2() {
		String str = "For my money, the important thing "
				+ "about the meeting was bridge-building";
		String regEx = "a|f"; // 表示a或f
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		boolean result = m.find();
		System.out.println(result);
	}

	/**
	 * 替换或删除
	 */
	static void method3() {
		String regEx = "a+";// 表示一个或多个a
		String str = "abbbaaa an banana hhaana";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		String s = m.replaceAll("⊙⊙");
		/*如果写成空串，既可达到删除的功能，比如：
		 String s=m.replaceAll("");*/
		System.out.println(s);

	}

	/**
	 *  分割
	 */
	static void metho4() {
		String regEx = "::";
		Pattern p = Pattern.compile(regEx);
		String[] r = p.split("xd::abc::cde");

		//执行后，r就是{"xd","abc","cde"}，其实分割时还有跟简单的方法：
		/*String str="xd::abc::cde";
		 String[] r=str.split("::"); */
		System.err.println(r);
	}

	/**
	 *  查找以Java开头,任意结尾的字符串
	 */
	static void metho5() {
		Pattern pattern = Pattern.compile("^Java.*");
		Matcher matcher = pattern.matcher("Java不是人");
		boolean b = matcher.matches();
		//当条件满足时，将返回true，否则返回false
		System.out.println(b);
	}

	/**
	 *  以多条件分割字符串
	 */
	static void method6(){
		Pattern pattern = Pattern.compile("[, |]+");
		String[] strs = pattern.split("Java Hello World  Java,Hello,,World|Sun");
		for (int i=0;i<strs.length;i++) {
		    System.out.println(strs[i]);
		} 
	}
	
	/**
	 *  文字替换（首次出现字符）
	 */
	static void method8(){
		Pattern pattern = Pattern.compile("正则表达式");
		Matcher matcher = pattern.matcher("正则表达式 Hello World,正则表达式 Hello World");
//		替换第一个符合正则的数据
		System.out.println(matcher.replaceFirst("Java"));
	}
	
	/**
	 *  文字替换（全部）
	 */
	static void method9(){
		Pattern pattern = Pattern.compile("正则表达式");
		Matcher matcher = pattern.matcher("正则表达式 Hello World,正则表达式 Hello World");
//		替换第一个符合正则的数据
		System.out.println(matcher.replaceAll("Java"));
	}
	
	/**
	 *  验证是否为邮箱地址
	 */
	static void method10(){
		String str="ceponline@yahoo.com.cn";
		Pattern pattern = Pattern.compile("[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w\\-]+",Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(str);
		System.out.println(matcher.matches());
	}
	
	/**
	 *  去除html标记
	 */
	static void method11(){
		Pattern pattern = Pattern.compile("<.+?>", Pattern.DOTALL);
		Matcher matcher = pattern.matcher("<a href=\"index.html\">主页</a>");
		String string = matcher.replaceAll("");
		System.out.println(string);
	}
	
	/**
	 *  查找html中对应条件字符串
	 */
	static void method12(){
		Pattern pattern = Pattern.compile("href=\"(.+?)\"");
		Matcher matcher = pattern.matcher("<a href=\"index.html\">主页</a>");
		if(matcher.find())
		  System.out.println(matcher.group(1));
	}
	
	/**
	 *  截取http://地址
	 */
	static void method13(){
		//截取url
		Pattern pattern = Pattern.compile("(http://|https://){1}[\\w\\.\\-/:]+");
		Matcher matcher = pattern.matcher("dsdsds<http://dsds//gfgffdfd>fdf");
		StringBuffer buffer = new StringBuffer();
		while(matcher.find()){             
		    buffer.append(matcher.group());       
		    buffer.append("\r\n");             
		System.out.println(buffer.toString());
		}
	}
	
	
	public static void main(String[] args) {
		method1();
		method2();
		method3();
	}

}
