package com.geeksun.util2;

import java.util.Random;

/**
 * @author Administrator
 * @category Random:�����,�ṩ��������������Ĺ���
 */
public class Random1 {
	public static void main(String[] args) {
		Random rd = new Random();
		for(int i=0;i<10;i++){
			System.out.println(rd.nextInt(10));						// 0~9֮��������(����)
			System.out.println(2*rd.nextInt(10));					// 0~18֮��������(����)
			System.out.println(rd.nextInt(10)+5);					// 5~9֮��������(����)
		}
	}
}
