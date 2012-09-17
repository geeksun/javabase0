package com.geeksun.security;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import javax.crypto.KeyGenerator;

public class DESKeyGenerator {

	/**
	 * @param args
	 *  �ṩ���Գƣ���Կ�������� function
	 */
	public static void main(String[] args) {
		Security.addProvider(new com.sun.crypto.provider.SunJCE());
		try {
			KeyGenerator kg = KeyGenerator.getInstance("DES");
			//  ��Կ��Key��������Կ�Ķ���ӿ�,
			Key key = kg.generateKey();
			//  ������Կ�Ļ��������ʽ
			System.out.println("Key  format:  " + key.getFormat());
			//  �����Կ�㷨������
			System.out.println("Key  algorithm: " + key.getAlgorithm());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
}
