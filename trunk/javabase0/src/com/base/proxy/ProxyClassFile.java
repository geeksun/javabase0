package com.base.proxy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import sun.misc.ProxyGenerator;

/**
 * @author 姜志强
 *  动态代理诠释：动态代理的内部实现——代码生成
 *  2012-9-15
 */
public class ProxyClassFile {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String proxyName = "TempProxy";

        TempImpl t = new TempImpl("proxy");
		//TempProxy t = new TempProxy("proxy");
        Class[] interfaces =t.getClass().getInterfaces();
        byte[] proxyClassFile = ProxyGenerator.generateProxyClass(proxyName, interfaces);
        
        //File f = new File("classes/TempProxy.class");
        File f = new File("D:\\workspace\\mianshi\\WebRoot\\WEB-INF\\classes\\com\\geek\\proxy\\TempProxy.class");
        try {
            FileOutputStream fos = new FileOutputStream(f);
            fos.write(proxyClassFile);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
     }
}
