package com.sun.common;

/**
 * @author geeksun
 * @version continue�������ʹ������ת��ѭ������"}"��,����ִ���µ�����
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
