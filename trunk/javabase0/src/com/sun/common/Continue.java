package com.sun.common;

/**
 * @author geeksun
 * @version continue语句用于使程序流转到循环语句的"}"处,重新执行新的流程
 */
public class Continue {
	public static void main(String[] args){
		for(int a=1;a<=10;a++){
			if(a<=5)
				continue;
			System.out.print(a+" ");
		}
	}
}
