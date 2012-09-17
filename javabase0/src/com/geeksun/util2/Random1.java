package com.geeksun.util2;

import java.util.Random;

/**
 * @author Administrator
 * @category Random:随机类,提供产生各种随机数的功能
 */
public class Random1 {
	public static void main(String[] args) {
		Random rd = new Random();
		for(int i=0;i<10;i++){
			System.out.println(rd.nextInt(10));						// 0~9之间的随机数(整数)
			System.out.println(2*rd.nextInt(10));					// 0~18之间的随机数(整数)
			System.out.println(rd.nextInt(10)+5);					// 5~9之间的随机数(整数)
		}
	}
}
