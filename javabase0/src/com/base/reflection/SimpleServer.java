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
	 * ��һ��Զ�̶���ŵ�������
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
		System.out.println("����������");
		while(true)
		{
			Socket sk = ss.accept();
			InputStream in = sk.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(in);
			OutputStream out = sk.getOutputStream();
			ObjectOutputStream os = new ObjectOutputStream(out);
			
			Call call = (Call) ois.readObject();		// ���տͻ����͵� Call ����
			System.out.println(call);
			call = invoke(call);						// ������ض���ķ���
			os.writeObject(call);						// ��ͻ����Ͱ�����ִ�н���� Call ����
			
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
				throw new Exception(className+"��Զ�̶��󲻴���");
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
		// �����ȴ����õ� HelloServiceImpl ������뵽�������Ļ�����
		ss.register("remotecall.HelloService", new HelloServiceImpl());
		ss.service(); 
	}
}
