package com.base.string;
/**
 * @author geeksun
 * @version 要求输出:张三:2,李四:3
 */
public class StringTest {
	public static void main(String[] args){
		String s = new String("张三,李四,王五,张三,李四,王五,张三");
		String[] t = s.split(",");
		int k = 0;	
	    /*for(int i=0;i<t.length;i++){
	    	for(int j=1;j<t.length;j++){
	    		if(t[i].equals(t[j])){
	    			k++;
	    		}
	    	}
			System.out.println(t[i] + ":" +k);
		}*/
		int ss = 0;
		int st = 0;
		for(int i=0;i<t.length;i++){
			if(t[i].equals("张三")){
				k++;
			}
			if(t[i].equals("李四")){
				ss++;
			}
			if(t[i].equals("王五")){
				st++;
			}
		}
		System.out.println("张三:"+k+"李四:"+ss+"王五:"+st);
	}
}	
