package com.sun.reflection;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *   客户端
 *   2010-9-27
 *   姜志强
 */
public class SimpleClient {
	
	public void invoke() throws UnknownHostException, IOException, ClassNotFoundException {
		Socket ss = new Socket("localhost",8000);
		OutputStream out = ss.getOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(out);
		InputStream in = ss.getInputStream();
		ObjectInputStream ois = new ObjectInputStream(in);
		
		//Call call = new Call("remotecall.HelloService","getTime",new Class[]{},new Object[]{}); 
		Call call = new Call("remotecall.HelloService","echo",new Class[]{String.class},new Object[]{"Hello"});
		oos.writeObject(call);
		call = (Call) ois.readObject(); 
		System.out.println(call.getResult()); 
		
		ois.close();
		oos.close();
		ss.close();
	}
	
	public static void main(String args[]) throws UnknownHostException, IOException, ClassNotFoundException
	{
		new SimpleClient().invoke(); 
	}
}
