package com.base.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * @author jzq 
 * ����Toos_Koolearn_info��Ĺ�����
 */
public class KoolearnUtils {
	public static HashMap map;
	public static HashMap processMap(){
		//  �¶����γ�
		map = new HashMap();
		map.put("T0821", "���˱���ѧλӢ�︨��");
		map.put("T0822", "ͳ��Ӣ�︨��");
		map.put("T0823", "ѧλӢ�︨��+ͳ��Ӣ�︨��");
		
		map.put("341259", "֪��ͳ��Ӣ��");
		
		/*map.put("T0011", "ѧλӢ�︨���γ�");
		map.put("T1011", "ͳ��Ӣ�︨���γ�");
		
		map.put("T0811", "ѧλӢ�︨���γ�");			//  repeat
		map.put("T0812", "ͳ��Ӣ�︨���γ�");			//  repeat
		
		map.put("T0012", "ѧλӢ�����Ӣ��ض���");
		map.put("T1012", "ͳ���ض���");*/
		
		map.put("jsj", "��Ժ���������");
		
		return map;
	}
	
	/**
	 *  ����ʱ��
	 */
	public void processTime(){
		
		
	}
	/**
	 * @param str
	 * @return K ֵ
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
	 * @return  ���ڸ�ʽ������ַ��� : ��ʽ����Ϊ��yyyy-MM--dd�� MM Сд������
	 */
	public static String timeFormat(Date date){
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		return sim.format(date);
	}
	public static void main(String[] args){
		System.out.println(process("֪��ͳ��Ӣ��"));
		Date d = new Date();
		System.out.println(d);
		System.out.println(timeFormat(d));
	}
}
