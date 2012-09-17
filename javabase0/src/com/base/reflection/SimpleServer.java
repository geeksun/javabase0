package com.base.reflection;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class SimpleServer {
	private Map remoteObjects = new HashMap();
	/**
	 * 把一个远程对象放到缓存中
	 * @param className
	 * @param remoteObject
	 */
	public void register(String className,Object remoteObject)
	{
		remoteObjects.put(className, remoteObject);
	}
	public void service() throws Exception
	{
		ServerSocket ss = new ServerSocket(8000);
		System.out.println("服务器启动");
		while(true)
		{
			Socket sk = ss.accept();
			InputStream in = sk.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(in);
			OutputStream out = sk.getOutputStream();
			ObjectOutputStream os = new ObjectOutputStream(out);
			
			Call call = (Call) ois.readObject();		// 接收客户发送的 Call 对象
			System.out.println(call);
			call = invoke(call);						// 调用相关对象的方法
			os.writeObject(call);						// 向客户发送包含了执行结果的 Call 对象
			
			ois.close();
			os.close();
			sk.close();
		}
	}
	public Call invoke(Call call) {
		// TODO Auto-generated method stub
		Object result = null;
		try
		{
			String className = call.getClassName();
			String methodName = call.getMethodName();
			Object[] params = call.getParams();
			Class cla = Class.forName(className);
			Class[] pt = call.getParamTypes();
			Method method = cla.getMethod(methodName, pt);
			Object remoteObject = remoteObjects.get(className);
			if(remoteObject==null)
			{
				throw new Exception(className+"的远程对象不存在");
			}else{
				result = method.invoke(remoteObject, params);
			}
		}catch(Exception e)
			{
				return call;
			}
			
		return null;
	}
	public static void main(String args[]) throws Exception 
	{ 
		SimpleServer ss = new SimpleServer();
		// 把事先创建好的 HelloServiceImpl 对象加入到服务器的缓存中
		ss.register("remotecall.HelloService", new HelloServiceImpl());
		ss.service(); 
	}
}
