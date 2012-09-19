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
 * AES �ӽ���,����MD5
 **/

public class Encryptor {
    
    /**
     * ��һ���ַ�������MD5����,����һ�����ܺ������
     * @param String pwd
     *        Ҫ���ܵ��ַ���
     * @return ���ܺ���ַ���
     */
    public static String MD5(String pwd) throws NoSuchAlgorithmException,Exception
    {
        try{
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(pwd.getBytes());
            byte[] hash = md5.digest();
            
            /* �������Ƶ��ֽ���ת��ʮ�����Ƶ��ַ��� */
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
            //AES����
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
            
            //AES����
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128, new SecureRandom(pwd.getBytes()));
            SecretKey skey = kgen.generateKey();
            byte[] raw = skey.getEncoded();
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);

            //д�ļ�
            byte[] bytOut = cipher.doFinal(bytIn);
            String ecrOut = new String(bytOut,"UTF8");
            return ecrOut;
        }catch(Exception e){
            e.printStackTrace();
             throw new Exception();
        }
    }
    
    /**
     * ��һ������Ϊlen �������
     * @param int len
     *         ���ɵ��������ĳ���
     * @return String pwd
     *         �������ɵ��������
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
        System.out.println(ms+"----------------����");
        String key = getRandomKey(8);
        System.out.println(key+"----------------��Կ");
        String ins = AESEncrypt(key,ms);
        System.out.println(ins+"----------------����");
        String outs = AESDencrypt(key,ins);
        System.out.println(outs+"----------------�������");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("----------------------");
        }
    }
}

