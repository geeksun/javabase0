package com.geeksun.util;

/**
 *  @author geeksun
 *  @version ��ǩ��ʹ��,�������ת����ǩ���ڵĵط�
 */
public class Label {
	public static void main(String[] args){
		label:for(int i=1;i<=3;i++){
			for(int j=1;j<=2;j++){
				if(i<=2) continue label;
				System.out.println(i+" "+j);
			}
			System.out.println("���"+i);
		}
	}
}
