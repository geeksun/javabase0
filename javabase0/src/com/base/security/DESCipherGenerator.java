package com.base.security;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;					//  û�д������쳣
import java.security.Security;
import java.security.NoSuchAlgorithmException;				//  û�д��㷨���쳣

/**
 * @author ��־ǿ
 *  �����ı��Ĵ���
 */
public class DESCipherGenerator {
	public static void main(String[] args) {
		Security.addProvider(new com.sun.crypto.provider.SunJCE());
		try {
			//  Cipher : ����,����,JCE��ܵĺ���
			Cipher cipher = Cipher.getInstance("DES");					//  CBC/PKCS5Padding
			//  ���ش� Cipher ������ṩ����
			System.out.println("Cipher  provider:  " + cipher.getProvider());		//  ��䷽��
			//  ���ش� Cipher ������㷨����
			System.out.println("Cipher  algorithm: " + cipher.getAlgorithm());		//  ����ģʽ
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		}
	}
}
