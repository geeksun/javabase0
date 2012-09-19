package com.base.security;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;					//  没有此填充的异常
import java.security.Security;
import java.security.NoSuchAlgorithmException;				//  没有此算法的异常

/**
 * @author 姜志强
 *  加密文本的传输
 */
public class DESCipherGenerator {
	public static void main(String[] args) {
		Security.addProvider(new com.sun.crypto.provider.SunJCE());
		try {
			//  Cipher : 计算,密码,JCE框架的核心
			Cipher cipher = Cipher.getInstance("DES");					//  CBC/PKCS5Padding
			//  返回此 Cipher 对象的提供程序
			System.out.println("Cipher  provider:  " + cipher.getProvider());		//  填充方案
			//  返回此 Cipher 对象的算法名称
			System.out.println("Cipher  algorithm: " + cipher.getAlgorithm());		//  反馈模式
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		}
	}
}
