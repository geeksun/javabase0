package com.base.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * @author jzq 
 * 操作Toos_Koolearn_info表的工具类
 */
public class KoolearnUtils {
	public static HashMap map;
	public static HashMap processMap(){
		//  新东方课程
		map = new HashMap();
		map.put("T0821", "成人本科学位英语辅导");
		map.put("T0822", "统考英语辅导");
		map.put("T0823", "学位英语辅导+统考英语辅导");
		
		map.put("341259", "知金统考英语");
		
		/*map.put("T0011", "学位英语辅导课程");
		map.put("T1011", "统考英语辅导课程");
		
		map.put("T0811", "学位英语辅导课程");			//  repeat
		map.put("T0812", "统考英语辅导课程");			//  repeat
		
		map.put("T0012", "学位英语（三级英语）重读课");
		map.put("T1012", "统考重读课");*/
		
		map.put("jsj", "本院计算机辅导");
		
		return map;
	}
	
	/**
	 *  处理时间
	 */
	public void processTime(){
		
		
	}
	/**
	 * @param str
	 * @return K 值
	 */
	public static String process(String str){
		HashMap hashmap = processMap();
		Set keySet   =   hashmap.keySet();  
        for (Iterator i = keySet.iterator(); i.hasNext();) {  
            String  key = (String)i.next();  
            String  value = (String)hashmap.get(key);  
            if (value.equals(str)) {  
            	map.clear();
            	keySet.clear();
                return  key;   
            }  
        }
		return null;    
	}
	
	/**
	 * @param date
	 * @return  日期格式化后的字符串 : 格式必须为“yyyy-MM--dd” MM 小写即不可
	 */
	public static String timeFormat(Date date){
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		return sim.format(date);
	}
	public static void main(String[] args){
		System.out.println(process("知金统考英语"));
		Date d = new Date();
		System.out.println(d);
		System.out.println(timeFormat(d));
	}
}
