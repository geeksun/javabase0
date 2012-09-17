package com.geeksun.security;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;

public class DESCryptoTest {
	/**
	 * @param args
	 *  �Դ�����ı����ܺͽ���(text)
	 *  JCE��Java Cryptographic Extension: Java ������չ���
	 */
	public static void main(String[] args) {
		Security.addProvider(new  com.sun.crypto.provider.SunJCE());   
        try  {   
                KeyGenerator  kg  =  KeyGenerator.getInstance("DES");  
                // ��Կ
                Key  key  =  kg.generateKey();
                // ���룺�ṩ����Լ��ܺͽ��ܵ����� cipher ����
                Cipher  cipher  =  Cipher.getInstance("DES");   

                byte[]  data  =  "Hello  World!".getBytes();   
                //  ԭʼ����
                System.out.println("Original  data : " +  new  String(data));   

                //  ����Կ��ʼ���� Cipher,�ü���ģʽ
                cipher.init(Cipher.ENCRYPT_MODE, key);   
                // �������ֲ������ܻ�������ݣ����߽���һ���ಿ�ֲ��������ݱ����ܻ��ǽ���ȡ���ڴ� cipher �ĳ�ʼ����ʽ�� 
                byte[]  result  =  cipher.doFinal(data);   
                System.out.println("Encrypted  data: " + new  String(result));   

                //  ����Կ��ʼ�����������,�ý���ģʽ
                cipher.init(Cipher.DECRYPT_MODE, key);   
                byte[]  original  =  cipher.doFinal(result);   
                System.out.println("Decrypted   data:  "  +  new  String(original));   
        }   
        catch  (NoSuchAlgorithmException  e) {   
                e.printStackTrace();   
        }   
        catch  (NoSuchPaddingException  e) {   
                e.printStackTrace();   
        }   
        catch  (InvalidKeyException   e) {   
                e.printStackTrace();   
        }   
        catch  (IllegalStateException  e) {   
                e.printStackTrace();   
        }   
        catch (IllegalBlockSizeException  e) {   
                e.printStackTrace();   
        }   
        catch (BadPaddingException  e) {   
                e.printStackTrace();   
        }  
	}
}   
