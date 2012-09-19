package com.base.string;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;
import java.util.Map.Entry;

/** @category strs 是一个动态数组,内容为dynamic
 *  @author yili
 *  @version 要求输出:张三:2,李四:3
 */
public class Str {
	public static void main(String [] args){
		String str = "张三,四口,李可,张三,四口,四口,张三,张三,张四";
		String[] strs=str.split(",");
		java.util.Arrays.sort(strs);										// 整理数组,使相同的元素排列在一起
		Map<String,Integer> map=new HashMap<String,Integer>();
		int n=1;
		
		for(int k=0;k<strs.length-1;k++){							// k min value is strs.length-2
			if(k==strs.length-2){										
				if(strs[k].equals(strs[k+1])){
					n++;
					map.put(strs[k], new Integer(n));
				}
				else
				{
					map.put(strs[k], new Integer(n));				
					map.put(strs[k+1], new Integer(1));		
					// map.put(Key k,Value v)  将指定的值与映射中的指定键相关联
				}
			}		
			else
			{
				if(strs[k].equals(strs[k+1])){
					n++;
				}
				else
				{				
					map.put(strs[k], new Integer(n));
					n=1;											// when different,n=1 
				}
			}
		}
		
		Set set = map.entrySet();
		Iterator it =  set.iterator();
		while(it.hasNext()){
			Entry o=(Entry)it.next();
			System.out.print(o.getKey()+":"+o.getValue());
		}
	}
}
