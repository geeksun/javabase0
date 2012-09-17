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
	 *  对传输的文本加密和解密(text)
	 *  JCE：Java Cryptographic Extension: Java 密码扩展框架
	 */
	public static void main(String[] args) {
		Security.addProvider(new  com.sun.crypto.provider.SunJCE());   
        try  {   
                KeyGenerator  kg  =  KeyGenerator.getInstance("DES");  
                // 密钥
                Key  key  =  kg.generateKey();
                // 密码：提供了针对加密和解密的密码 cipher 功能
                Cipher  cipher  =  Cipher.getInstance("DES");   

                byte[]  data  =  "Hello  World!".getBytes();   
                //  原始数据
                System.out.println("Original  data : " +  new  String(data));   

                //  用密钥初始化此 Cipher,用加密模式
                cipher.init(Cipher.ENCRYPT_MODE, key);   
                // 按单部分操作加密或解密数据，或者结束一个多部分操作。数据被加密还是解密取决于此 cipher 的初始化方式。 
                byte[]  result  =  cipher.doFinal(data);   
                System.out.println("Encrypted  data: " + new  String(result));   

                //  用密钥初始化此密码计算,用解密模式
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
