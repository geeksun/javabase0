package com.wave.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.logging.Logger;

/**
 * @author jzq 日志处理 
 * AOP主要应用于日志记录，性能统计，安全控制,事务处理等方面。它的主要意图就要将日志记录，性能统计，安全控制等等代码从商业逻辑代码中清楚的划分出来，
 * 我们可以把这些行为一个一个单独看作系统所要解决的问题，就是所谓的面向问题的编程(不知将AOP译作面向问题的编程是否欠妥)。
 * 通过对这些行为的分离，我们希望可以将它们独立地配置到商业方法中，而要改变这些行为也不需要影响到商业方法代码。 
 * 2009-5-8
 */
public class LogHandler implements InvocationHandler {

	private Logger logger = Logger.getLogger(this.getClass().getName());

	private Object delegate;

	public LogHandler(Object delegate) {
		this.delegate = delegate;
	}

	/**
	 *  调用
	 */
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object o = null;
		try {
			logger.info("method stats..." + method);
			o = method.invoke(delegate, args);
			logger.info("method ends..." + method);
		} catch (Exception e) {
			logger.info("Exception happends...");
			// excetpion handling.
		}
		return o;
	}

}
