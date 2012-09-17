package com.geeksun.data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Temp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(String.valueOf("20080210131222").substring(0,8)); 
		List<Long> list = new ArrayList<Long>();
		list.add(Long.parseLong("20080210131222"));
		list.add(Long.parseLong("20080210131452"));
		list.add(Long.parseLong("20080210132452"));
		list.add(Long.parseLong("20080219051827"));
		
		int stop = 2000;
		long total = 0;
		int k=0,j = 0;
		long before=0,after=0;
		for(int i=1;i<list.size();i++)
		{
			after = list.get(i);			//  如：20080210131222
			//prefix = String.valueOf(after).substring(0, 8);		//  返回年月日，如：20080210
			/**
			if(!prefix.equals(day))
			{
				total = total + 1200;
			}
			day = prefix;
			**/
			if(after-before < stop)
			{
				String tmp = String.valueOf(after-before);
				if(tmp.length() >=3)
				{
					long minutes = Long.parseLong(tmp.substring(tmp.length()==3?tmp.length()-3:tmp.length()-4,tmp.length()-2))*60+Long.parseLong(tmp.substring(tmp.length()-2));
					total = total + minutes;
				}else if(tmp.length() > 1)
				{
					long minutes = Long.parseLong(tmp.substring(tmp.length()-2));
					total = total + minutes;
				}
				k++;
				System.out.println("k: "+k);
			}else
			{
				total = total + 1200;
				j++;
				System.out.println("j: "+j+" before: "+before+" after: "+after); 
			}
			before = after;
		}
		System.out.println("total:  " + total); 
		System.out.println("time: " + new BigDecimal(String.valueOf(total)).divide(new BigDecimal(3600),1,BigDecimal.ROUND_HALF_UP).doubleValue());		
		String tmp = "1000";
		long minutes = Long.parseLong(tmp.substring(tmp.length()==3?tmp.length()-3:tmp.length()-4,tmp.length()-2))*60+Long.parseLong(tmp.substring(tmp.length()-2));
		System.out.println(minutes);
		System.out.println(10+"1000".substring(2));
		long test = Long.parseLong("10") + Long.parseLong("1000".substring(2));
		System.out.println(test);
		System.out.println("90".substring(0));
	}

}
