package com.base.string;
/**
 * @author geeksun
 * @version Ҫ�����:����:2,����:3
 */
public class StringTest {
	public static void main(String[] args){
		String s = new String("����,����,����,����,����,����,����");
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
			if(t[i].equals("����")){
				k++;
			}
			if(t[i].equals("����")){
				ss++;
			}
			if(t[i].equals("����")){
				st++;
			}
		}
		System.out.println("����:"+k+"����:"+ss+"����:"+st);
	}
}	
