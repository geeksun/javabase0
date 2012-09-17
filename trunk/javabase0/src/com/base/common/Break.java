package com.base.common;

/**
 * @author geeksun
 * @version break 用于强制退出
 */
public class Break {
	public static void main(String[] args){
		for(int a=1;a<11;a++){				// a<11 处为 true 也可以
			if(a==8)break;
			System.out.print(a+" ");
		}
	}
}
