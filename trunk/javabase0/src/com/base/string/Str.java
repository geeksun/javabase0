package com.base.string;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;
import java.util.Map.Entry;

/** @category strs ��һ����̬����,����Ϊdynamic
 *  @author yili
 *  @version Ҫ�����:����:2,����:3
 */
public class Str {
	public static void main(String [] args){
		String str = "����,�Ŀ�,���,����,�Ŀ�,�Ŀ�,����,����,����";
		String[] strs=str.split(",");
		java.util.Arrays.sort(strs);										// ��������,ʹ��ͬ��Ԫ��������һ��
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
					// map.put(Key k,Value v)  ��ָ����ֵ��ӳ���е�ָ���������
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
