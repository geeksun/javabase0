package com.geeksun.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * @author geeksun
 * @category : System.in���ڴӼ��̶�ȡ����
 * @see �Ӽ��̶�ȡһ������
 */
public class SystemIn2 {
	public static void main(String[] args) throws IOException{
		System.out.println("����һ������,����Enter����");
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
		
		String s = br.readLine();
		System.out.println("�ղ����������Ϊ:"+s);
	}
}
