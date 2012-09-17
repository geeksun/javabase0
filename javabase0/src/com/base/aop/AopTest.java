package com.base.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author jzq
 * 客户端调用商业方法, 利用Java语言本身自带的动态代理功能来实现AOP. 
 * 采用AOP之后，日志记录和业务逻辑代码完全分开了，以后要改变日志记录的话只需要修改日志记录处理器就行了，而业务对象本身（BusinessObject）无需做任何修改。
 * 并且这个日志记录不会造成重复代码了，所有的商业处理对象都可以重用这个日志处理器。 
 * 2009-5-8
 */
public class AopTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BusinessInterface businessImp = new BusinessObject();
		InvocationHandler handler = new LogHandler(businessImp);
		
		BusinessInterface proxy = (BusinessInterface) Proxy.newProxyInstance(
				businessImp.getClass().getClassLoader(), businessImp.getClass()
						.getInterfaces(), handler);
		
		proxy.processBusiness(); 
		
	}

}
