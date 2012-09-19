package com.base.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;


/**
 * AES 加解密,附加MD5
 **/

public class Encryptor {
    
    /**
     * 对一个字符串进行MD5加密,返回一个加密后的密文
     * @param String pwd
     *        要加密的字符串
     * @return 加密后的字符串
     */
    public static String MD5(String pwd) throws NoSuchAlgorithmException,Exception
    {
        try{
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(pwd.getBytes());
            byte[] hash = md5.digest();
            
            /* 将二进制的字节码转成十六进制的字符串 */
            String result = Base64.getBase64Encode(hash);
            return result;
        }catch(NoSuchAlgorithmException e){
            throw new NoSuchAlgorithmException();
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public static String AESEncrypt(String pwd,String strEncpt)throws Exception
    {
        try{
            byte[] bytIn = strEncpt.getBytes("UTF8");
            //AES加密
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128, new SecureRandom(pwd.getBytes()));
            SecretKey skey = kgen.generateKey();
            byte[] raw = skey.getEncoded();
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);

            byte[] bytOut = cipher.doFinal(bytIn);
            String ecrOut = Base64.getBase64Encode(bytOut);
            return ecrOut;

        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new Exception();
        }
    }
    
    public static String AESDencrypt(String pwd,String strDencpt)throws Exception
    {
        try{
            byte[] bytIn = Base64.getBase64Dencode(strDencpt);
            
            //AES加密
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128, new SecureRandom(pwd.getBytes()));
            SecretKey skey = kgen.generateKey();
            byte[] raw = skey.getEncoded();
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);

            //写文件
            byte[] bytOut = cipher.doFinal(bytIn);
            String ecrOut = new String(bytOut,"UTF8");
            return ecrOut;
        }catch(Exception e){
            e.printStackTrace();
             throw new Exception();
        }
    }
    
    /**
     * 生一个长度为len 的随机数
     * @param int len
     *         生成的随机密码的长度
     * @return String pwd
     *         返回生成的随机密码
     */
    public static String getRandomKey(int len)
    {
        StringBuffer buffer = new StringBuffer("123456789");
        StringBuffer pwd = new StringBuffer(); 
        Random r = new Random(); 
        int range = buffer.length(); 
        for (int i = 0; i < len; i ++) {
            int k = Math.abs(r.nextInt(range));
            if(k>=0 && k<range){
                pwd.append(buffer.charAt(k)); 
            }
        } 
        return pwd.toString(); 
    }
    
    
    public static void main(String[] args)
    {
        try{
        //String ms = MD5("12345678");
        String ms = "abcdefg==akl;k/*,";
        System.out.println(ms+"----------------明文");
        String key = getRandomKey(8);
        System.out.println(key+"----------------密钥");
        String ins = AESEncrypt(key,ms);
        System.out.println(ins+"----------------密文");
        String outs = AESDencrypt(key,ins);
        System.out.println(outs+"----------------解后明文");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("----------------------");
        }
    }
}

