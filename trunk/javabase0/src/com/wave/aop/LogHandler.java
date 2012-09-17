package com.wave.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.logging.Logger;

/**
 * @author jzq ��־���� 
 * AOP��ҪӦ������־��¼������ͳ�ƣ���ȫ����,������ȷ��档������Ҫ��ͼ��Ҫ����־��¼������ͳ�ƣ���ȫ���Ƶȵȴ������ҵ�߼�����������Ļ��ֳ�����
 * ���ǿ��԰���Щ��Ϊһ��һ����������ϵͳ��Ҫ��������⣬������ν����������ı��(��֪��AOP������������ı���Ƿ�Ƿ��)��
 * ͨ������Щ��Ϊ�ķ��룬����ϣ�����Խ����Ƕ��������õ���ҵ�����У���Ҫ�ı���Щ��ΪҲ����ҪӰ�쵽��ҵ�������롣 
 * 2009-5-8
 */
public class LogHandler implements InvocationHandler {

	private Logger logger = Logger.getLogger(this.getClass().getName());

	private Object delegate;

	public LogHandler(Object delegate) {
		this.delegate = delegate;
	}

	/**
	 *  ����
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
