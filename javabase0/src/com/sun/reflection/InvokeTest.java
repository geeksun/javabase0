package com.sun.reflection;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
/**
 *   方法调用的测试
 */
public class InvokeTest {
	public int add(int param1,int param2)
	{
		return param1 + param2;
	}
	public String echo(String msg)
	{
		return "echo:" + msg;
	}
	/**
	 * @param args
	 * @throws IllegalAccessException 
	 * @throws InstantiationException   
	 * @throws NoSuchMethodException  
	 * @throws SecurityException   
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 */
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		Class cla = InvokeTest.class;
		Object invokeTest = cla.newInstance();
		
		// 调用 InvokeTest 对象的 add() 方法
		Method addMethod = cla.getMethod("add", new Class[]{int.class,int.class});
		Object result = addMethod.invoke(invokeTest, new Object[]{new Integer(100),new Integer(200)});
		System.out.println(result);
		
		// 调用 InvokeTest 对象的 echo() 方法
		Method echoMethod = cla.getMethod("echo", new Class[]{String.class});
		result = echoMethod.invoke(invokeTest, new Object[]{"Hello"});
		System.out.println(result);
	}
}
