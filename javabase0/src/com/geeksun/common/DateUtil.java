package com.geeksun.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

public class DateUtil {
	private static String defaultDatePattern = "yyyy-MM-dd";

	/**  
	 *   ���Ĭ�ϵ�   date   pattern  
	 */
	public static String getDatePattern() {
		return defaultDatePattern;
	}

	/**  
	 *   ����Ԥ��Format�ĵ�ǰ�����ַ���  
	 */
	public static String getToday() {
		Date today = new Date();
		return format(today);
	}

	/**  
	 *   ʹ��Ԥ��Format��ʽ��Date���ַ���  
	 */
	public static String format(Date date) {
		return date == null ? "" : format(date, getDatePattern());
	}

	/**  
	 *   ʹ�ò���Format��ʽ��Date���ַ���  
	 */
	public static String format(Date date, String pattern) {
		return date == null ? "" : new SimpleDateFormat(pattern).format(date);
	}

	/**  
	 *   ʹ��Ԥ���ʽ���ַ���תΪDate  
	 */
	public static Date parse(String strDate) throws ParseException {
		return StringUtils.isBlank(strDate) ? null : parse(strDate,
				getDatePattern());
	}

	/**  
	 *   ʹ�ò���Format���ַ���תΪDate  
	 */
	public static Date parse(String strDate, String pattern)
			throws ParseException {
		return StringUtils.isBlank(strDate) ? null : new SimpleDateFormat(
				pattern).parse(strDate);
	}

	/**  
	 *   ��������������������  
	 */
	public static Date addMonth(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();
	}

	public static String getLastDayOfMonth(String year, String month) {
		Calendar cal = Calendar.getInstance();
		//��  
		cal.set(Calendar.YEAR, Integer.parseInt(year));
		//�£���ΪCalendar������Ǵ�0��ʼ������Ҫ-1  
		//     cal.set(Calendar.MONTH,   Integer.parseInt(month)   -   1);  
		//�գ���Ϊһ��  
		cal.set(Calendar.DATE, 1);
		//�·ݼ�һ���õ��¸��µ�һ��  
		cal.add(Calendar.MONTH, 1);
		//��һ���¼�һΪ�������һ��  
		cal.add(Calendar.DATE, -1);
		return String.valueOf(cal.get(Calendar.DAY_OF_MONTH));//�����ĩ�Ǽ���  
	}

	public static Date getDate(String year, String month, String day)
			throws ParseException {
		String result = year + "-"
				+ (month.length() == 1 ? ("0" + month) : month) + "-"
				+ (day.length() == 1 ? ("0" + day) : day);
		return parse(result);
	}
	public static void main(String[] args) throws ParseException {
		String str = "2008-11-10";
		String pattern = "yyyy-MM-dd";
		System.out.println(parse(str,pattern));
		
		Date days = new Date();
		SimpleDateFormat formats = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String today = formats.format(days);
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		days = format.parse(today);
		System.out.println(days);
		
		String s = "2008-11-11";
		DateFormat d = new SimpleDateFormat("yyyy-MM-dd");
		Date dd = d.parse(s);
		System.out.println(dd);
		
	}
}