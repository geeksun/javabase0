package com.lifeopera.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author jzq 
 * ������ʽ 
 * 2009-4-30
 */
public class RegularTest {

	/**
	 * ��ͳ��������ѯ�ı����ַ������Ƿ���y��f�ַ�
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
	 * ����
	 */
	static void method2() {
		String str = "For my money, the important thing "
				+ "about the meeting was bridge-building";
		String regEx = "a|f"; // ��ʾa��f
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		boolean result = m.find();
		System.out.println(result);
	}

	/**
	 * �滻��ɾ��
	 */
	static void method3() {
		String regEx = "a+";// ��ʾһ������a
		String str = "abbbaaa an banana hhaana";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		String s = m.replaceAll("�ѡ�");
		/*���д�ɿմ����ȿɴﵽɾ���Ĺ��ܣ����磺
		 String s=m.replaceAll("");*/
		System.out.println(s);

	}

	/**
	 *  �ָ�
	 */
	static void metho4() {
		String regEx = "::";
		Pattern p = Pattern.compile(regEx);
		String[] r = p.split("xd::abc::cde");

		//ִ�к�r����{"xd","abc","cde"}����ʵ�ָ�ʱ���и��򵥵ķ�����
		/*String str="xd::abc::cde";
		 String[] r=str.split("::"); */
		System.err.println(r);
	}

	/**
	 *  ������Java��ͷ,�����β���ַ���
	 */
	static void metho5() {
		Pattern pattern = Pattern.compile("^Java.*");
		Matcher matcher = pattern.matcher("Java������");
		boolean b = matcher.matches();
		//����������ʱ��������true�����򷵻�false
		System.out.println(b);
	}

	/**
	 *  �Զ������ָ��ַ���
	 */
	static void method6(){
		Pattern pattern = Pattern.compile("[, |]+");
		String[] strs = pattern.split("Java Hello World  Java,Hello,,World|Sun");
		for (int i=0;i<strs.length;i++) {
		    System.out.println(strs[i]);
		} 
	}
	
	/**
	 *  �����滻���״γ����ַ���
	 */
	static void method8(){
		Pattern pattern = Pattern.compile("������ʽ");
		Matcher matcher = pattern.matcher("������ʽ Hello World,������ʽ Hello World");
//		�滻��һ���������������
		System.out.println(matcher.replaceFirst("Java"));
	}
	
	/**
	 *  �����滻��ȫ����
	 */
	static void method9(){
		Pattern pattern = Pattern.compile("������ʽ");
		Matcher matcher = pattern.matcher("������ʽ Hello World,������ʽ Hello World");
//		�滻��һ���������������
		System.out.println(matcher.replaceAll("Java"));
	}
	
	/**
	 *  ��֤�Ƿ�Ϊ�����ַ
	 */
	static void method10(){
		String str="ceponline@yahoo.com.cn";
		Pattern pattern = Pattern.compile("[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w\\-]+",Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(str);
		System.out.println(matcher.matches());
	}
	
	/**
	 *  ȥ��html���
	 */
	static void method11(){
		Pattern pattern = Pattern.compile("<.+?>", Pattern.DOTALL);
		Matcher matcher = pattern.matcher("<a href=\"index.html\">��ҳ</a>");
		String string = matcher.replaceAll("");
		System.out.println(string);
	}
	
	/**
	 *  ����html�ж�Ӧ�����ַ���
	 */
	static void method12(){
		Pattern pattern = Pattern.compile("href=\"(.+?)\"");
		Matcher matcher = pattern.matcher("<a href=\"index.html\">��ҳ</a>");
		if(matcher.find())
		  System.out.println(matcher.group(1));
	}
	
	/**
	 *  ��ȡhttp://��ַ
	 */
	static void method13(){
		//��ȡurl
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
