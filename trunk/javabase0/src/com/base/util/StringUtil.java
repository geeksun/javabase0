package com.base.util;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import sun.io.ByteToCharConverter;
import sun.io.CharToByteConverter;

/**
 * <p>公共方法类</p>
 * <p>提供字符串处理的实用方法集</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: NineTowns</p>
 * @author Weiwenqi
 * @version 1.0
 *
 */

public class StringUtil
{
	
	public static final String escapeForIntro(String string)
	{
		//String str = escapeHTMLTags(string);
		String str = string;
		str = replace(str, "\r\n", "<br>");
		str = replace(str, "\n", "<br>");
		str = replace(str, "'", "\\'");
		return replace(str, "\r", "");

	}
	/**
	 * 得到非空的字符串，若字符串对象为null，则返回""。
	 * @param objValue Object待转换的原字符串对象
	 * @return String 转换后的字符串
	 * */
	public static String getNotNullStr(Object objValue)
	{
		return (objValue == null ? "" : objValue.toString());
	}
	/**
	 * 得到非空的字符串，若字符串为null，则返回""。
	 * @param strValue String待转换的原字符串
	 * @return String 转换后的字符串
	 * */
	public static String getNotNullStr(String strValue)
	{
		return (strValue == null ? "" : strValue.trim());
	}
	/**
	 * 将中文转化成AscII码以便存入数据库
	 * @param s  中文字符串
	 * @return 16进制字符串
	 */
	public static String ChineseStringToAscii(String s)
	{
		try
		{
			CharToByteConverter toByte = CharToByteConverter.getConverter("GBK");
			byte[] orig = toByte.convertAll(s.toCharArray());
			char[] dest = new char[orig.length];
			for (int i = 0; i < orig.length; i++)
				dest[i] = (char) (orig[i] & 0xFF);
			return new String(dest);
		}
		catch (Exception e)
		{
			//System.out.println(e);
			return s;
		}
	}
	/**
	 * 将UTF-8转化成AscII码以便存入数据库
	 * @param s 中文字符串
	 * @return 16进制字符串
	 */
	public static String ChineseStringToUTF(String s)
	{
		try
		{
			CharToByteConverter toByte = CharToByteConverter.getConverter("UTF-8");
			byte[] orig = toByte.convertAll(s.toCharArray());
			char[] dest = new char[orig.length];
			for (int i = 0; i < orig.length; i++)
				dest[i] = (char) (orig[i] & 0xFF);
			return new String(dest);
		}
		catch (Exception e)
		{
			//System.out.println(e);
			return s;
		}
	}

	/**
	 * 将AscII字符转换成汉字
	 * @param s -  ASCII字符串
	 * @return 汉字
	 */
	public static String AsciiToChineseString(String s)
	{
		char[] orig = s.toCharArray();
		byte[] dest = new byte[orig.length];
		for (int i = 0; i < orig.length; i++)
			dest[i] = (byte) (orig[i] & 0xFF);
		try
		{
			ByteToCharConverter toChar = ByteToCharConverter.getConverter("GBK");
			return new String(toChar.convertAll(dest));
		}
		catch (Exception e)
		{
			//System.out.println(e);
			return s;
		}
	}

	/**
	 * 使用正则表达式进行字符串内容替换
	 * @param regularExpression 正则表达式
	 * @param sub 替换的字符串
	 * @param input 要替换的字符串
	 * @return String 替换后的字符串
	 */
//	public static synchronized String regexReplace(String regularExpression, String sub, String input)
//	{
//		Pattern pattern = PatternFactory.getPattern(regularExpression);
//		Matcher matcher = pattern.matcher(input);
//		StringBuffer sb = new StringBuffer();
//		while (matcher.find())
//		{
//			matcher.appendReplacement(sb, sub);
//		}
//		matcher.appendTail(sb);
//		return sb.toString();
//	}

	/**
	 * 判断一个字符串中是否包含符合正则表达式定义的匹配条件的子串
	 * @param regularExpression - 正则表达式
	 * @param input - 待检查字符串
	 * @return - 若输入字符串中包含符合正则表达式定义的匹配条件的子串，则返回true，否则返回false
	 */
	//正则表达式匹配判断
//	public static synchronized boolean exist(String regularExpression, String input)
//	{
//		Pattern pattern = PatternFactory.getPattern(regularExpression);
//		Matcher matcher = pattern.matcher(input);
//		return matcher.find();
//	}

	/**
	 * 用"0"补足一个字符串到指定长度
	 * @param str -  源字符串
	 * @param size - 补足后应达到的长度
	 * @return - 补零后的结果
	 */
	public static String fillZero(String str, int size)
	{
		String result;
		if (str.length() < size)
		{
			char[] s = new char[size - str.length()];
			for (int i = 0; i < (size - str.length()); i++)
			{
				s[i] = '0';
			}
			result = new String(s) + str;
		}
		else
		{
			result = str;
		}

		return result;
	}

	/**
	 * 根据字符串（文件类型或者多行输入类型）获取字符串数组
	 * @param str1 String 输入字符串
	 * @return String[] 返回结果
	 */
	public static String[] getStrArryByString(String str1)
	{
		if (str1.indexOf("\t") > 0)
		{
			for (int i = 0; i < str1.length(); i++)
			{
				if (str1.substring(i, i + 1).equals("\t"))
				{
					str1 = str1.substring(0, i) + " " + str1.substring(i + 1, str1.length());
				}
			}
		}
		StringTokenizer stringTokenizer = new StringTokenizer(str1, "\r\n");
		String[] strId = new String[stringTokenizer.countTokens()];
		int i = 0;
		while (stringTokenizer.hasMoreTokens())
		{
			strId[i] = stringTokenizer.nextToken();
			i++;
		}
		return strId;
	}
	
	/**
	 * 判断一个字符串是否为 NUll 或为空
	 * @param inStr inStr
	 * @return boolean
	 */
	public static boolean isValid(String inStr)
	{
		if (inStr == null)
		{
			return false;
		}
		else if (inStr.equals(""))
		{
			return false;
		}
		else if (inStr.equals("null"))
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	/**
	 * 获得指定长度的空格
	 * @param spaceNum spaceNum
	 * @return String
	 */
	public static String getStrSpace(int spaceNum)
	{
		return getStrWithSameElement(spaceNum, " ");
	}
	/**
	 * 获得指定长度的字符串
	 * @param num int
	 * @param element String
	 * @return String
	 */
	public static String getStrWithSameElement(int num, String element)
	{
		if (num <= 0)
		{
			return "";
		}

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < num; i++)
		{
			sb.append(element);
		}
		return sb.toString();
	}
	/**
	 * 从右或左加空格
	 * @param strIn String
	 * @param totalLength int
	 * @param isRightAlign boolean
	 * @return String
	 */
	public static String getFillString(String strIn, int totalLength, boolean isRightAlign)
	{
		int spaceLength = 0;
		String spaces = null;
		String strOut = null;

		if (strIn == null)
		{
			strIn = "";
		}

		spaceLength = totalLength - strIn.length();

		if (spaceLength < 0)
		{
			spaceLength = 0;
		}
		spaces = StringUtil.getStrSpace(spaceLength);

		if (isRightAlign)
		{
			strOut = spaces + strIn;
		}
		else
		{
			strOut = strIn + spaces;

		}
		return strOut;
	}
	/**
	 * 以String类型返回错误抛出的堆栈信息
	 * @param t Throwable
	 * @return String
	 */
	public static String getStackTrace(Throwable t)
	{
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);

		t.printStackTrace(pw);
		return sw.toString();
	}
	/**
	 * 转换字符串第一个字符为大写
	 * @param str String
	 * @return String
	 */
	public static String getStrByUpperFirstChar(String str)
	{
		try
		{
			return str.substring(0, 1).toUpperCase() + str.substring(1);
		}
		catch (Exception e)
		{
			return "";
		}

	}
	/**
	 * 转换字符串第一个字符为小写
	 * @param str String
	 * @return String
	 */
	public static String getStrByLowerFirstChar(String str)
	{
		try
		{
			return str.substring(0, 1).toLowerCase() + str.substring(1);
		}
		catch (Exception e)
		{
			return "";
		}

	}
	/**
	 * 通过字符串转换成相应的整型，并返回。
	 * @param strValue String 待转换的字符串
	 * @return int 转换完成的整型
	 * */
	public static int getStrToInt(String strValue)
	{
		if (null == strValue)
		{
			return 0;
		}
		int iValue = 0;
		try
		{
			iValue = new java.lang.Integer(strValue.trim()).intValue();
		}
		catch (Exception ex)
		{
			iValue = 0;
		}
		return iValue;
	}

	/**
	 * 通过字符串转换成相应的DOUBLE，并返回。
	 * @param strValue String 待转换的字符串
	 * @return double 转换完成的DOUBLE
	 * */
	public static double getStrToDouble(String strValue)
	{
		if (null == strValue)
		{
			return 0;
		}
		double dValue = 0;
		try
		{
			dValue = Double.parseDouble(strValue.trim());
		}
		catch (Exception ex)
		{
			dValue = 0;
		}
		return dValue;
	}

	/**
	 * 通过字符串转换成相应的短整型，并返回。
	 * @param strValue String 待转换的字符串
	 * @return short 转换完成的短整型
	 * */
	public static short getStrToShort(String strValue)
	{
		if (null == strValue)
		{
			return 0;
		}
		short iValue = 0;
		try
		{
			iValue = new java.lang.Short(strValue.trim()).shortValue();
		}
		catch (Exception ex)
		{
			iValue = 0;
		}
		return iValue;
	}

	/**
	 * 通过字符串转换成相应的长整型，并返回。
	 * @param strValue String 待转换的字符串
	 * @return long 转换完成的长整型
	 * */
	public static long getStrToLong(String strValue)
	{
		if (null == strValue)
		{
			return 0;
		}
		long lValue = 0;
		try
		{
			lValue = new java.lang.Long(strValue.trim()).longValue();
		}
		catch (Exception ex)
		{
			lValue = 0;
		}
		return lValue;
	}

	public static String toLengthForEn(String str, int length)
	{
		if (null != str)
		{
			if (str.length() <= length)
			{
				return str;
			}
			else
			{
				str = str.substring(0, length - 4);
				str = str + "..";
				return str;
			}
		}
		else
		{
			return "";
		}
	}

	/**
	  * 降字符串转换成给定长度的字符串，如超出的话截断，并在最后以两个点结尾
	  * @param str String
	  * @param length int
	  * @return String
	  */
	public static String toLengthForIntroduce(String str, int length)
	{
		str = delTag(str);

		byte[] strByte = str.getBytes();
		int byteLength = strByte.length;
		char[] charArray;
		StringBuffer buff = new StringBuffer();
		if (byteLength > (length * 2))
		{
			charArray = str.toCharArray();
			int resultLength = 0;
			for (int i = 0; i < charArray.length; i++)
			{
				resultLength += String.valueOf(charArray[i]).getBytes().length;
				if (resultLength > (length * 2))
				{
					break;
				}
				buff.append(charArray[i]);

			}
			buff.append("..");
			str = buff.toString();
		}

		//		str = replace(str, "'", "\\'");
		str = replace(str, "\"", "\\\"");
		str = replace(str, "，", ",");
		return str;

	}

	public static String delTag(String str)
	{
		str = str + "<>";
		StringBuffer buff = new StringBuffer();
		int start = 0;
		int end = 0;

		while (str.length() > 0)
		{
			start = str.indexOf("<");
			end = str.indexOf(">");
			if (start > 0)
			{
				buff.append(str.substring(0, start));
			}
			if (end > 0 && end <= str.length())
			{
				str = str.substring(end + 1, str.length());
			}
			else
			{
				str = "";
			}

		}
		String result = buff.toString();

		while (result.startsWith(" "))
		{

			result = result.substring(result.indexOf(" ") + 1, result.length());

		}
		return result;

	}

	public static final String replace(String line, String oldString, String newString)
	{
		if (line == null)
		{
			return null;
		}
		int i = 0;
		if ((i = line.indexOf(oldString, i)) >= 0)
		{
			char[] line2 = line.toCharArray();
			char[] newString2 = newString.toCharArray();
			int oLength = oldString.length();
			StringBuffer buf = new StringBuffer(line2.length);
			buf.append(line2, 0, i).append(newString2);
			i += oLength;
			int j = i;
			while ((i = line.indexOf(oldString, i)) > 0)
			{
				buf.append(line2, j, i - j).append(newString2);
				i += oLength;
				j = i;
			}
			buf.append(line2, j, line2.length - j);
			return buf.toString();
		}
		return line;

	}
	//	Replace
	public static String Replace(String source, String oldString, String newString)
	{
		if (source == null)
		{
			return null;
		}
		StringBuffer output = new StringBuffer();
		int lengOfsource = source.length();
		int lengOfold = oldString.length();
		int posStart = 0;
		int pos;
		while ((pos = source.indexOf(oldString, posStart)) >= 0)
		{
			output.append(source.substring(posStart, pos));
			output.append(newString);
			posStart = pos + lengOfold;
		}
		if (posStart < lengOfsource)
		{
			output.append(source.substring(posStart));
		}
		return output.toString();
	}

	//此函数前台使用中，请勿随便修改，不然会造成显示混乱(以前修改版本在下方注释中)
	public static String toHtml(String s)
	{
		if(s == null)
		{
			return null;
		}
		s=sliceTooLongWord(s,55);
		s=trimHtml(s);
		//s=filterAllHTML(s);
		s = Replace(s,"&lt;yA&gt;","");
		s = Replace(s,"&lt;/yA&gt;","");
		s = Replace(s, "<br>", "\n");
		s = Replace(s, "<", "&lt;");
		s = Replace(s, ">", "&gt;");
		s = Replace(s, "\t", "    ");
		s = Replace(s, "\r\n", "\n");
		//s = Replace(s, " ", "&nbsp;");
		s = Replace(s, "\n", "<br>");
		s = Replace(s, "'", "&#39;");
		s = Replace(s, "\"", "&quot;");
		s = Replace(s, "\\", "&#92;");
		s = Replace(s, "%", "％");
		//	s = Replace(s, "&", "&amp;");
		return s;
	}
	
	//转译SEWEB的搜索串
	public static String trancQueryStr(String qStr){
		//var invalidChars = ['&','(',')','!','"','-','|','+',':','[',']','$','?'];
		if(qStr == null||qStr.equals(""))
		{
			return qStr;
		}
		//var invalidChars = ['`','~','!','@','#','$','%','^','&','*','(',')','-','+','[',']','{','}','|','\\',':=',':',';','"','\'','<','>',',','.','/','?'];
		//qStr = Replace(qStr,"&","\&");
		//int n=qStr.indexOf('');
//		qStr = Replace(qStr," &"," ");
//		qStr = Replace(qStr,"& "," ");
//		qStr = Replace(qStr,"&"," ");
//		
//		qStr=  Replace(qStr," ("," ");
//		qStr=  Replace(qStr,"( "," ");
//	    qStr=  Replace(qStr,"("," ");
//	    
//		qStr=  Replace(qStr," )"," ");
//		qStr=  Replace(qStr,") "," ");
//		qStr = Replace(qStr,")"," ");
//		
//		qStr=  Replace(qStr," !"," ");
//		qStr=  Replace(qStr,"! "," ");
//		qStr = Replace(qStr,"!"," ");
//		
//		qStr = Replace(qStr," \""," ");
//		qStr = Replace(qStr,"\" "," ");
//		qStr = Replace(qStr,"\""," ");
//		
//		qStr = Replace(qStr," -"," ");
//		qStr = Replace(qStr,"- "," ");
//		qStr = Replace(qStr,"-"," ");
//		
//		qStr = Replace(qStr," |"," ");
//		qStr = Replace(qStr,"| "," ");
//		qStr = Replace(qStr,"|"," ");
//		
//		qStr = Replace(qStr," +"," ");
//		qStr = Replace(qStr,"+ "," ");
//		qStr = Replace(qStr,"+"," ");
//		
//		qStr = Replace(qStr," :"," ");
//		qStr = Replace(qStr,": "," ");
//		qStr = Replace(qStr,":"," ");
//		
//		qStr = Replace(qStr," :="," ");
//		qStr = Replace(qStr,":= "," ");
//		qStr = Replace(qStr,":="," ");
//		
//		qStr = Replace(qStr," ["," ");
//		qStr = Replace(qStr,"[ "," ");
//		qStr = Replace(qStr,"["," ");
//		
//		qStr = Replace(qStr,"　]"," ");
//		qStr = Replace(qStr,"] "," ");
//		qStr = Replace(qStr,"]"," ");
//		
//		qStr = Replace(qStr," $"," ");
//		qStr = Replace(qStr,"$ "," ");
//		qStr = Replace(qStr,"$"," ");
//		
//		qStr = Replace(qStr," ?"," ");
//		qStr = Replace(qStr,"? "," ");
//		qStr = Replace(qStr,"?"," ");
//		
//		qStr = Replace(qStr," ^"," ");
//		qStr = Replace(qStr,"^ "," ");
//		qStr = Replace(qStr,"^"," ");
//		
//		qStr = Replace(qStr," <"," ");
//		qStr = Replace(qStr,"< "," ");
//		qStr = Replace(qStr,"<"," ");
//		
//		qStr = Replace(qStr," >"," ");
//		qStr = Replace(qStr,"> "," ");
//		qStr = Replace(qStr,">"," ");
//		
//		qStr = Replace(qStr," {"," ");
//		qStr = Replace(qStr,"{ "," ");
//		qStr = Replace(qStr,"{"," ");
//		
//		qStr = Replace(qStr," }"," ");
//		qStr = Replace(qStr,"} "," ");
//		qStr = Replace(qStr,"}"," ");
//		
//		qStr = Replace(qStr," #"," ");
//		qStr = Replace(qStr,"# "," ");
//		qStr = Replace(qStr,"#"," ");
//		
//		qStr = Replace(qStr,"  "," ");
//var invalidChars = ['`','~','!','@','#','$','%','^','&','*','(',')','-','+','[',']','{','}','|','\\',':=',':',';','"','\'','<','>',',','.','/','?'];
		//String[] charArry ={"`","~","!","@","#","$","%","^","&","*","(",")","-","_","+","=","[","]","{","}","|","\\",":",":=",";","\"","\'","<",">",",",".","/","?"};
		//String[] charArry ={"`","~","!","@","#","$","%","^","&","*","(",")","-","_","+","=","[","]","{","}","|","\\",":",":=",";","\"","\'","<",">",",",".","/","?"};
		String[] charArry ={"`","~","!","@","#","$","%","^","&","*","(",")","+","=","[","]","{","}","|","\\",":",":=",";","<",">",",","/","?"};
		for(int i=0;i<charArry.length;i++){
        	qStr = Replace(qStr,charArry[i]," ");
			
        }
		//		qStr = Replace(qStr,"`"," ");
//		
//		qStr = Replace(qStr,"~"," ");
//		
//		qStr = Replace(qStr,"!"," ");
//		
//		qStr = Replace(qStr,"@"," ");
//		
//		qStr = Replace(qStr,"#"," ");
//		
//		qStr = Replace(qStr,"$"," ");
//		
//		qStr = Replace(qStr,"%"," ");
//		
//		qStr = Replace(qStr,"^"," ");
//		
//		qStr = Replace(qStr,"&"," ");
//		
//		qStr = Replace(qStr,"*"," ");
//		
//	    qStr=  Replace(qStr,"("," ");
//	    
//		qStr = Replace(qStr,")"," ");
//		
//
//		
//		qStr = Replace(qStr,"\""," ");
//		
//		qStr = Replace(qStr,"-"," ");
//		
//		qStr = Replace(qStr,"|"," ");
//		
//		qStr = Replace(qStr,"+"," ");
//		
//		qStr = Replace(qStr,":"," ");
//		
//		qStr = Replace(qStr,":="," ");
//		
//		qStr = Replace(qStr,"["," ");
//		
//		qStr = Replace(qStr,"]"," ");
//		
//
//		
//		qStr = Replace(qStr,"?"," ");
//		
//
//		
//		qStr = Replace(qStr,"<"," ");
//		
//		qStr = Replace(qStr,">"," ");
//		
//		qStr = Replace(qStr,"{"," ");
//		
//		qStr = Replace(qStr,"}"," ");
		qStr = Replace(qStr,"  "," ");
		return qStr.trim();
	}
	
	//转译SEWEB的搜索串 20080228 14:42 bak
	public static String trancQueryStrNewbak(String qStr){
		if(qStr == null||qStr.equals(""))
		{
			return qStr;
		}
		if (qStr.indexOf("\\")>-1)
		{
			qStr = Replace(qStr,"\\","\\\\");
		}	
		//String[] charArry ={"`","~","!","@","#","$","%","^","&","*","(",")","-","_","+","=","[","]","{","}","|","\\",":",":=",";","\"","\'","<",">",",",".","/","?"};
		//String[] charArry ={"`","~","!","@","#","$","%","^","&","*","(",")","-","_","+","=","[","]","{","}","|",":",":=",";","\"","\'","<",">",",",".","/","?"};
		//双引号不转，为包括短语查询
		String[] charArry ={"`","~","!","@","#","$","%","^","&","*","(",")","-","_","+","=","[","]","{","}","|",":",":=",";","\'","<",">",",",".","/","?"};
		for(int i=0;i<charArry.length;i++){
        	//qStr = Replace(qStr,charArry[i]," ");
			qStr = Replace(qStr,charArry[i],"\\"+charArry[i]);
        }
		qStr = Replace(qStr,"  "," ");
		return qStr.trim();
	}
	
	public static String trancQueryStrNew(String qStr){
		if(qStr == null||qStr.equals(""))
		{
			return qStr;
		}
		//双引号不转，为包括短语查询
		String[] charArry ={"`","~","!","@","#","$","%","^","&","*","(",")","-","_","+","=","[","]","{","}","|",":",":=",";","\'","<",">",",",".","/","?"};
		return trancQueryStrAll(qStr,charArry);
	}
	
	//all 
	public static String trancQueryStr2(String qStr){
		/*
		var str=v;
		var re=/(`|~|!|@|#|\$|%|\^|&|\*|\(|\)|-|_|\+|=|\[|]|\{|}|\||\\|:=|:|;|\"|\'|<|>|,|\.|\/|\?)/g
		var re2 =/(%|&|\\)/g
		//var replaceStr=str.replace(re, " ").replace(/\s+/g, " ").replace(/(^\s*)|(\s*$)/g, "");
		var replaceStr=str.replace(re2, " ").replace(re, "\\$1").replace(/\s+/g, " ").replace(/(^\s*)|(\s*$)/g, "");
		replaceStr=Trim(replaceStr);
		return replaceStr;
        */
		
		if(qStr == null||qStr.equals(""))
		{
			return qStr;
		}
		//双引号不转，为包括短语查询
		//String[] charArry ={"`","~","!","@","#","$","%","^","&","*","(",")","-","_","+","=","[","]","{","}","|",":",":=",";","\"","\'","<",">",",",".","/","?"};
		String[] charArry ={"`","~","!","@","#","$","^","*","(",")","-","_","=","[","]","{","}","|",":",":=",";","\"","\'","<",">",",",".","/","?"};
		qStr =Replace(qStr,"%","");
		qStr =Replace(qStr,"&","");
		qStr =Replace(qStr,"\\","");
		qStr =Replace(qStr,"+","");
		return trancQueryStrAll(qStr,charArry);
	}

	//no include  '"'
	public static String trancQueryStr3(String qStr){
		/*
		    var str=v;
			var re=/(`|~|!|@|#|\$|%|\^|&|\*|\(|\)|-|_|\+|=|\[|]|\{|}|\||\\|:=|:|;|\'|<|>|,|\.|\/|\?)/g
			var re2 =/(%|&|\\)/g
			//var replaceStr=str.replace(re, " ").replace(/\s+/g, " ").replace(/(^\s*)|(\s*$)/g, "");
			var replaceStr=str.replace(re2, " ").replace(re, "\\$1").replace(/\s+/g, " ").replace(/(^\s*)|(\s*$)/g, "");
			replaceStr=Trim(replaceStr);
			return replaceStr;
		*/
		if(qStr == null||qStr.equals(""))
		{
			return qStr;
		}
		//双引号不转，为包括短语查询
		//String[] charArry ={"`","~","!","@","#","$","%","^","&","*","(",")","-","_","+","=","[","]","{","}","|",":",":=",";","\"","\'","<",">",",",".","/","?"};
		String[] charArry = {"`","~","!","@","#","$"      ,"^"    ,"*","(",")","-","_",   "=","[","]","{","}","|",":",":=",";",     "\'","<",">",",",".","/","?"};
		qStr =Replace(qStr,"%","");
		qStr =Replace(qStr,"&","");
		qStr =Replace(qStr,"\\","");
		qStr =Replace(qStr,"+","");
		return trancQueryStrAll(qStr,charArry);
	} 
	
	//only include  '"'
	public static String trancQueryStr1(String qStr){
		    /*
		    var str=v;
			//var re=/(`|~|!|@|#|\$|%|\^|&|\*|\(|\)|-|_|\+|=|\[|]|\{|}|\||\\|:=|:|;|\'|<|>|,|\.|\/|\?)/g
			var re=/(\")/g
			var replaceStr=str.replace(re, "\\$1").replace(/\s+/g, " ").replace(/(^\s*)|(\s*$)/g, "");
			replaceStr=Trim(replaceStr);
			return replaceStr;
		 }*/
		if(qStr == null||qStr.equals(""))
		{
			return qStr;
		}
		String[] charArry = {"\""};
		return  Replace(qStr,"\"","\\\"").trim();
		//return trancQueryStrAll(qStr,charArry);
	} 
	
	//过滤 掉 %,$,\\
	public static String trancQueryStr4(String qStr){
		    /*
		    var str=v;
		    var re =/(%|&|\\)/g
			var replaceStr=str.replace(re, " ").replace(/\s+/g, " ").replace(/(^\s*)|(\s*$)/g, "");
			replaceStr=Trim(replaceStr);
			return replaceStr;
		 }*/
		if(qStr == null||qStr.equals(""))
		{
			return qStr;
		}
		qStr =Replace(qStr,"%","");
		qStr =Replace(qStr,"&","");
		qStr =Replace(qStr,"\\","");
		qStr = Replace(qStr,"  "," ");
		//qStr =Replace(qStr,"+","");
		return qStr;
	} 
	
	//转译SEWEB的搜索串
	public static String trancQueryStrAll(String qStr,String[] charArry){
		//var invalidChars = ['&','(',')','!','"','-','|','+',':','[',']','$','?'];
		if(qStr == null||qStr.equals(""))
		{
			return qStr;
		}
		if (charArry==null||charArry.length==0)
		{
			return qStr;
		}	
		if (qStr.indexOf("\\")>-1)
		{
			qStr = Replace(qStr,"\\","\\\\");
		}	

		//String[] charArry ={"`","~","!","@","#","$","%","^","&","*","(",")","-","_","+","=","[","]","{","}","|","\\",":",":=",";","\"","\'","<",">",",",".","/","?"};
		//String[] charArry ={"`","~","!","@","#","$","%","^","&","*","(",")","-","_","+","=","[","]","{","}","|",":",":=",";","\"","\'","<",">",",",".","/","?"};
		//双引号不转，为包括短语查询
		//String[] charArry ={"`","~","!","@","#","$","%","^","&","*","(",")","-","_","+","=","[","]","{","}","|",":",":=",";","\'","<",">",",",".","/","?"};

		for(int i=0;i<charArry.length;i++){
        	//qStr = Replace(qStr,charArry[i]," ");
			qStr = Replace(qStr,charArry[i],"\\"+charArry[i]);
        }
		qStr = Replace(qStr,"  "," ");
		return qStr.trim();
	}

	/**
	 * 过滤字符串中所有html代码
	 * @param s
	 * @return String
	 */
	public static synchronized String filterAllHTML(String s) {

		if (s != null) {
			s = s.replaceAll("\\s+", " ");//去掉多余的空格和回车换行
			s = s.replaceAll("<.*?>", "");
			// 处理全角空格
			s = s.replaceAll("　+", " ");
			// 去多个空合格
			s = s.replaceAll("&nbsp;", " ");
			s = s.replaceAll("\\s+", " ");

			// 去首尾空格
			s = s.trim();
		}
		return s;
	}
	
	
	
	//	逆
	public static String unHtml(String s)
	{
		//s = Replace(s, "&lt;", "<");
		//s = Replace(s, "&gt;", ">");
		//		s = Replace(s, "    ", "\t");
		//		s = Replace(s, "\n", "\r\n");
		s = Replace(s, "<br>", "\n");
		//		s = Replace(s, "&nbsp;", " ");
		//		s = Replace(s, "&amp;", "&");
		//		s = Replace(s, "&#39;", "'");
		//		s = Replace(s, "&#92;", "\\");
		//		s = Replace(s, "％", "%");
		return s;
	}
	
	public static String trimHtml(String s)
	{
		if(s == null)
		{
			return null;
		}

		return s.replaceAll("<.*?>", "");
	}

	//	此函数后台使用中，请勿随便修改，不然会造成显示混乱(以前修改版本在下方注释中)
	public static String toHtmlBack(String s)
	{
		//显示
		s = Replace(s, "&", "&amp;");
		s = Replace(s, "\\", "&#92;");
		s = Replace(s, "\"", "&quot;");
		s = Replace(s, "<", "&lt;");
		s = Replace(s, ">", "&gt;");
		s = Replace(s, "\t", "    ");
		s = Replace(s, "\r\n", "\n");
		//		s = Replace(s, "\n", "<br>");
//		s = Replace(s, " ", "&nbsp;");
		//		s = Replace(s, "'", "&#39;");
		//		s = Replace(s, "%", "%");

		return s;
	}
	//	逆
	public static String unHtmlBack(String s)
	{
		
		return s;
	}
	/**
	 * 将<br>按换行<p></p>按段落显示，其它都按原输入内容显示
	 * @param s
	 * @return String
	 */
	public static String toHtmlBak(String s){
		
		return s;
	}
	
	/*
	public static String toHtml(String s)
	{
		//显示
		s = Replace(s, "&", "&amp;");
		s = Replace(s, "\\", "&#92;");
		s = Replace(s, "\"", "&quot;");
		s = Replace(s, "<", "&lt;");
		s = Replace(s, ">", "&gt;");
		s = Replace(s, "\t", "    ");
		s = Replace(s, "\r\n", "\n");
	//		s = Replace(s, "\n", "<br>");
		s = Replace(s, " ", "&nbsp;");
	//		s = Replace(s, "'", "&#39;");
	//		s = Replace(s, "%", "%");
		
		return s;
	}
	
	public static String unHtml(String s)
	{
		s = Replace(s, "&lt;", "<");
		s = Replace(s, "&gt;", ">");
		s = Replace(s, "    ", "\t");
		s = Replace(s, "\n", "\r\n");
		s = Replace(s, "<br>", "\n");
		s = Replace(s, "&nbsp;", " ");
		s = Replace(s, "&amp;", "&");
		s = Replace(s, "&#39;", "'");
		s = Replace(s, "&#92;", "\\");
		s = Replace(s, "％", "%");
		return s;
	}
	*/
	//判断是否含有中文，如果含有中文返回ture
	public static boolean containsChinese(String str) throws UnsupportedEncodingException
	{

		if (str.length() < (str.getBytes()).length)
			return true;

		return false;

		//	  for (int i = 0; i < username.length(); i++) {
		//		String unit=Character.toString(username.charAt(i));
		//		byte[] unitByte=unit.getBytes("GBK");
		////  		((unitByte[0]+256)*256 + (unitByte[1]+256)) <= 0xFEFE)
		//	   if (unitByte.length == 2)
		//		{
		//		  return true;
		//		}
		//	  }
		//	  return false;

	}

	public static boolean isEmpty(String str)
	{
		if (str == null)
			return true;
		return "".equals(str.trim());
	}

	public static String[] split(String str1, String str2)
	{
		return org.apache.commons.lang.StringUtils.split(str1, str2);
	} 

	public static String left(String str, int length)
	{
		return org.apache.commons.lang.StringUtils.left(str, length);
	}

	/**
	 * 根据输入的长度截取字符串，单个单词超过输入长度的强制加<BR>换行
	 * @param str 输入的字符串
	 * @param len 输入的长度
	 * @return 处理过后的字符串
	 */
	public static String truncateStr(String str, int len)
	{
		if (str != null && !("").equalsIgnoreCase(str))
		{

			String strs[] = str.split(" ");
			StringBuffer buff = new StringBuffer();
			if (strs.length > 0)
			{
				for (int i = 0; i < strs.length; i++)
				{
					StringBuffer temp = new StringBuffer();
					while (strs[i].length() > len)
					{
						temp.append(strs[i].substring(0, len) + "<BR>");
						strs[i] = strs[i].substring(len);
					}
					temp.append(strs[i]);
					buff.append(temp.toString() + " ");
				}

			}
			return buff.toString();
		}
		else
		{
			return "";
		}
	}
	
	public static String truncateStr2(String str, int len)
	{
		if (str != null && !("").equalsIgnoreCase(str) && len!=0)
		{
			String strs[] = str.split(" ");
			
			StringBuffer buff = new StringBuffer();
			for (int i = 0; i < strs.length; i++)
			{
				StringBuffer temp = new StringBuffer();
				String tempstr = "";
				while (strs[i].length() > len)
				{
					tempstr = strs[i].substring(0, len);
					tempstr = tempstr.replaceAll(" ","&nbsp;");
					tempstr = tempstr.replaceAll("<","&lt;");
					tempstr = tempstr.replaceAll("\n","<br>").replaceAll("\"","&quot;").replaceAll("'","&#39;");
					tempstr = tempstr + "<br>";
					temp.append(tempstr);
					
					strs[i] = strs[i].substring(len);
				}
				tempstr = strs[i];
				tempstr = tempstr.replaceAll(" ","&nbsp; ");
				tempstr = tempstr.replaceAll("<","&lt; ");
				tempstr = tempstr.replaceAll("\n","<br> ").replaceAll("\"","&quot; ").replaceAll("'","&#39; ");
								
				temp.append(tempstr);
				buff.append(temp.toString() + " ");
			}
			
			if(buff.length() > 0)
				return buff.toString().substring(0,buff.length()-1);
			else
				return str;
		}
		else
		{
			return "";
		}
	}
	
	/**
	 * 编码转换，从unicode转换为GBK
	 * @param l_S_Source 输入字符串
	 * @return str编码转换后的字符串
	 * @throws UnsupportedEncodingException
	 */
	public static String unicodeToGB(String l_S_Source) throws UnsupportedEncodingException
	{
		String l_S_Desc = "";
		if (l_S_Source != null && !l_S_Source.trim().equals(""))
		{
			byte l_b_Proc[] = l_S_Source.getBytes("GBK");
			l_S_Desc = new String(l_b_Proc, "ISO8859_1");
		}
		return l_S_Desc;
	}
	/**
	 * 编码转换，从GBK转换为unicode
	 * @param l_S_Source 输入字符串
	 * @return str 编码转换后的字符串
	 * @throws UnsupportedEncodingException
	 */
	public static String GBToUnicode(String l_S_Source) throws UnsupportedEncodingException
	{
		String l_S_Desc = "";
		if (l_S_Source != null && !l_S_Source.trim().equals(""))
		{
			byte l_b_Proc[] = l_S_Source.getBytes("ISO8859_1");
			l_S_Desc = new String(l_b_Proc, "GBK");
		}
		return l_S_Desc;
	}

	private static StringUtil instance = null;
	public static synchronized StringUtil getInstance()
	{
		if (instance == null)
		{
			instance = new StringUtil();
		}
		return instance;
	}

	public static String replace(String src, String target, String rWith, int maxCount)
	{
		return org.apache.commons.lang.StringUtils.replace(src, target, rWith, maxCount);
	}

	public static boolean equals(String str1, String str2)
	{
		return org.apache.commons.lang.StringUtils.equals(str1, str2);
	}

	public static boolean isAlphanumeric(String str)
	{
		return org.apache.commons.lang.StringUtils.isAlphanumeric(str);
	}

	public static boolean isNumeric(String str)
	{
		return org.apache.commons.lang.StringUtils.isNumeric(str);
	}

	public static String[] stripAll(String[] strs)
	{
		return org.apache.commons.lang.StringUtils.stripAll(strs);
	}
	
	public static String getDate(Date date){
		if(date==null)
			return null;
		DateFormat t = DateFormat.getDateInstance();
		return t.format(date);
	}
	
	public static String addspace(String str,int len){
		if(str==null || len<=0)
			return null;
		StringBuffer sb = new StringBuffer("");
		String[] a = str.split(" ");
		
		for(int i=0;i<a.length;i++){
			if(validateChinese(a[i])){
				sb.append(a[i]);
				sb.append(" ");
			}else{
				sb.append(changeString(a[i],len));
				sb.append(" ");
			}
		}
		
		return sb.toString();
	}
	
	public static boolean validateChinese(String value){
		if(value==null)
			return false;
		Pattern re = Pattern.compile("[^\\x00-\\xff]");
		Matcher regexMatcher = re.matcher(value);
		return regexMatcher.find();
	}
	
	public static String changeString(String str,int len){
		if(str==null || len<=0)
			return "";
		StringBuffer sb = new StringBuffer("");
		int count = 0;
		for(int i=0;i<str.length();i++){
			char ch = str.charAt(i);
			if(ch<256){
				count++;
			}else{
				count=0;
			}
			if(count>=len){
				sb.append(" ");
				count=0;
			}
			sb.append(ch);
		}
		return sb.toString();		
	}
	public static synchronized String sliceTooLongWord(String str,int length)
	{
		String reg = "(\\S){" + length + "}?";
//		Pattern pattern = Pattern.compile(reg);
//		Matcher matcher = pattern.matcher(str);	
//		if(matcher.matches()){
//			System.out.println("match");
//		}else{
//			System.out.println("not match");
//		}
		return str.replaceAll(reg, "$0 ");
	}
	
	
	
	
	
	public static String toHTML(String s)
	{
		if(s == null)
		{
			return null;
		}
		s=sliceTooLongWord(s,55);
		//s=filterAllHTML(s);
		//为了让表红 准确率，和精度 更高； 转换前＋" "  zhengnsh 20080115
		s = Replace(s,"&lt;yA&gt;","");
		s = Replace(s,"&lt;/yA&gt;","");
		s = Replace(s, "<br>", " \n");
		s = Replace(s, "<", " &lt;");
		s = Replace(s, ">", " &gt;");
		s = Replace(s, "\t", "    ");
		s = Replace(s, "\r\n", " \n");
		//s = Replace(s, " ", "&nbsp;");
		s = Replace(s, "\n", " <br>");
		s = Replace(s, "'", " &#39;");
		s = Replace(s, "\"", " &quot;");
		s = Replace(s, "\\", " &#92;");
		s = Replace(s, "%", " ％");
		//	s = Replace(s, "&", "&amp;");
		return s;
	}
	
	public static String toHTMLForKword(String s)
	{
		if(s == null)
		{
			return null;
		}
		s=sliceTooLongWord(s,55);
		//s=filterAllHTML(s);
		//为了让表红 准确率，和精度 更高； 转换前＋" "  zhengnsh 20080115
		s = Replace(s,"&lt;yA&gt;","");
		s = Replace(s,"&lt;/yA&gt;","");
		//s = Replace(s, "<br>", " \n");
		s = Replace(s, "<", " &lt;");
		s = Replace(s, ">", " &gt;");
		s = Replace(s, "\t", "    ");
		s = Replace(s, "\r\n", " \n");
		s = Replace(s, "\n", " <br>");
		s = Replace(s, "'", " &#39;");
		s = Replace(s, "\"", " &quot;");
		s = Replace(s, "\\", " &#92;");
		s = Replace(s, "%", " ％");
		return s;
	}
	
	/**
	 * 高级搜索：非运算 字符串转换
	 * @param str
	 * @return
	 */
	public String  insertChar(String str){
		if (str==null||"".equals(str))
			return str;
		String[] charArr ;   
		charArr = str.split(" ");
		String returnStr = "";
		String value="";
		for(int i=0;i<charArr.length;i++){
			if( value.indexOf(charArr[i])==-1){
			   if (i!= charArr.length-1)
			      returnStr+=charArr[i]+'|';
			   else
			      returnStr+=charArr[i];
			}		
		}
		return returnStr;
	}
	
	public static void main(String[] args)
	{
		try
		{
			String testStr="<Br>  <br >  <input>  <inpub /> <br/> <br/> < P> <p> </p>";
			//String testhtml="4854632 <input type="text"><input type="text"><input type="text"><input type="text"><input type="text"><input type="text"><input type="text"><input type="text"><input type="text"><input type="text"><input type="text"><input type="text"><input type="text"><input type="text"><input type="text"><input     /img00/products/004/290/1004290.jpg     2587050     dctech     fasdf          1970-01-01 08:00:48          1186750205     1 //";
			String qstr="&mp3";
			System.out.println("trancQueryStr="+trancQueryStr(qstr));
			System.out.println(testStr);
			System.out.println(toHtmlBak(testStr));
			
			System.out.println(toHTML("=========="+testStr));
			
			String str = "tv &quot;40&quot;&quot;";
			System.out.println(StringUtil.toHTML(str));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

}

