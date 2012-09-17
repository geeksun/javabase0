package com.geeksun.security;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import javax.crypto.KeyGenerator;

public class DESKeyGenerator {

	/**
	 * @param args
	 *  提供（对称）密钥生成器的 function
	 */
	public static void main(String[] args) {
		Security.addProvider(new com.sun.crypto.provider.SunJCE());
		try {
			KeyGenerator kg = KeyGenerator.getInstance("DES");
			//  密钥：Key是所有密钥的顶层接口,
			Key key = kg.generateKey();
			//  返回密钥的基本编码格式
			System.out.println("Key  format:  " + key.getFormat());
			//  获得密钥算法的名称
			System.out.println("Key  algorithm: " + key.getAlgorithm());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
}
