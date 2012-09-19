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
 * 生成保存公钥和私钥的密钥仓库，保存在demoKeystore文件中。这里storepass 和 keypass 不要有java 正则表达式中的特殊字符，否则程序里要转义麻烦。
 * keytool -export -alias demo -keystore demoKeystore -rfc -file demo.cer //从密钥仓库中导出保存公钥的证书
 * 输入keypass 即demoPwd  
 * @create at 2009-4-8
 *//*

public class KeyStoreTest {

	*//**
	 * @param args
	 *//*
	public static void main(String[] args) {
		try{     
			   //密钥仓库
			   KeyStore ks = KeyStore.getInstance("JKS");
//			读取密钥仓库
			   FileInputStream ksfis = new FileInputStream("demoKeystore");
			   BufferedInputStream ksbufin = new BufferedInputStream(ksfis);
			   char[] storePwd = "storePwd".toCharArray();
			   ks.load(ksbufin, storePwd);
			   ksbufin.close();
			   char[] keyPwd = "demoPwd".toCharArray();
//			从密钥仓库得到私钥
			   PrivateKey priK = (PrivateKey) ks.getKey("demo", keyPwd);  
//			生成cipher
			   Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding",new org.bouncycastle.jce.provider.BouncyCastleProvider());
//			用私钥初始化cipher
			   cipher.init(Cipher.ENCRYPT_MODE, priK);
			   byte[] plain = "This is plain text".getBytes("UTF-8");
			   
			   //因为用的1024位rsa算法，一次只能加密1024/8-11字节数据，分开加密
			   byte[] code = new byte[(((plain.length-1)/117+1))*128];  
			            int ixplain = 0;
			            int ixcode = 0;
			            while((plain.length - ixplain) > 117) {//每117字节做一次加密
			                ixcode += cipher.doFinal(plain, ixplain, 117, code, ixcode);
			                ixplain += 117;
			            }
			            cipher.doFinal(plain, ixplain, plain.length - ixplain, code, ixcode);
			            //加密后的code
			            System.out.println(Arrays.toString(code));
			            //通常会用base64编码
			           String base64 = encoder.encode(code);

			   CertificateFactory certificatefactory = CertificateFactory
			     .getInstance("X.509");
			   //读取证书
			   FileInputStream fin = new FileInputStream("demo.cer");
			   X509Certificate certificate = (X509Certificate) certificatefactory
			     .generateCertificate(fin);
			   fin.close();
			   //得到公钥
			   PublicKey pubK = certificate.getPublicKey();
			         //初始化cipher
			            cipher.init(Cipher.DECRYPT_MODE, pubK);
			      //base64解码
			            code = decoder.decodeBuffer(base64);
			            System.out.println(Arrays.toString(code));
			            byte[] plain2 = new byte[code.length];
			            int ixplain2 = 0;
			            int ixcode2 = 0;
			            while((code.length - ixcode2) > 128) {//每128字节做一次解密
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