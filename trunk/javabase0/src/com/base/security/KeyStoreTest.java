package com.base.security;
/*package com.geeksun.security;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;

import javax.crypto.Cipher;

*//**
 * @author jzq
 * @annotation: keytool -genkey -dname "CN=demo, OU=softDept, O=company, L=puddong,S=shanghai, C=cn" -alias demo -keyalg RSA -keysize 1024 -keystore demoKeystore -validity 3650 -storepass storePwd -keypass demoPwd
 * ���ɱ��湫Կ��˽Կ����Կ�ֿ⣬������demoKeystore�ļ��С�����storepass �� keypass ��Ҫ��java ������ʽ�е������ַ������������Ҫת���鷳��
 * keytool -export -alias demo -keystore demoKeystore -rfc -file demo.cer //����Կ�ֿ��е������湫Կ��֤��
 * ����keypass ��demoPwd  
 * @create at 2009-4-8
 *//*

public class KeyStoreTest {

	*//**
	 * @param args
	 *//*
	public static void main(String[] args) {
		try{     
			   //��Կ�ֿ�
			   KeyStore ks = KeyStore.getInstance("JKS");
//			��ȡ��Կ�ֿ�
			   FileInputStream ksfis = new FileInputStream("demoKeystore");
			   BufferedInputStream ksbufin = new BufferedInputStream(ksfis);
			   char[] storePwd = "storePwd".toCharArray();
			   ks.load(ksbufin, storePwd);
			   ksbufin.close();
			   char[] keyPwd = "demoPwd".toCharArray();
//			����Կ�ֿ�õ�˽Կ
			   PrivateKey priK = (PrivateKey) ks.getKey("demo", keyPwd);  
//			����cipher
			   Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding",new org.bouncycastle.jce.provider.BouncyCastleProvider());
//			��˽Կ��ʼ��cipher
			   cipher.init(Cipher.ENCRYPT_MODE, priK);
			   byte[] plain = "This is plain text".getBytes("UTF-8");
			   
			   //��Ϊ�õ�1024λrsa�㷨��һ��ֻ�ܼ���1024/8-11�ֽ����ݣ��ֿ�����
			   byte[] code = new byte[(((plain.length-1)/117+1))*128];  
			            int ixplain = 0;
			            int ixcode = 0;
			            while((plain.length - ixplain) > 117) {//ÿ117�ֽ���һ�μ���
			                ixcode += cipher.doFinal(plain, ixplain, 117, code, ixcode);
			                ixplain += 117;
			            }
			            cipher.doFinal(plain, ixplain, plain.length - ixplain, code, ixcode);
			            //���ܺ��code
			            System.out.println(Arrays.toString(code));
			            //ͨ������base64����
			           String base64 = encoder.encode(code);

			   CertificateFactory certificatefactory = CertificateFactory
			     .getInstance("X.509");
			   //��ȡ֤��
			   FileInputStream fin = new FileInputStream("demo.cer");
			   X509Certificate certificate = (X509Certificate) certificatefactory
			     .generateCertificate(fin);
			   fin.close();
			   //�õ���Կ
			   PublicKey pubK = certificate.getPublicKey();
			         //��ʼ��cipher
			            cipher.init(Cipher.DECRYPT_MODE, pubK);
			      //base64����
			            code = decoder.decodeBuffer(base64);
			            System.out.println(Arrays.toString(code));
			            byte[] plain2 = new byte[code.length];
			            int ixplain2 = 0;
			            int ixcode2 = 0;
			            while((code.length - ixcode2) > 128) {//ÿ128�ֽ���һ�ν���
			                ixplain2 += cipher.doFinal(code, ixcode2, 128, plain2, ixplain2);
			                ixcode2 += 128;
			            }
			            ixplain2 += cipher.doFinal(code, ixcode2, code.length - ixcode2, plain2, ixplain2);
			            String s2 = new String(plain2, 0, ixplain2, "UTF-8");
			            System.out.println(s2);
			   
			  }catch(Exception ex){
			   ex.printStackTrace();
			  }

	}

}
*/