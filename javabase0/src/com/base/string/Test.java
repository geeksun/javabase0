package com.base.string;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "aa,bb,cc,ii,aa,ii,oo,pp,ee";
		String[] st = str.split(",");
		java.util.Arrays.sort(st);
		for(int i=0;i<st.length-1;i++){
			System.out.println("result:"+st[i].equals(st[i+1]));
		}
	}

}
