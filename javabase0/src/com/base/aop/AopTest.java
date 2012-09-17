package com.base.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author jzq
 * �ͻ��˵�����ҵ����, ����Java���Ա����Դ��Ķ�̬��������ʵ��AOP. 
 * ����AOP֮����־��¼��ҵ���߼�������ȫ�ֿ��ˣ��Ժ�Ҫ�ı���־��¼�Ļ�ֻ��Ҫ�޸���־��¼�����������ˣ���ҵ�������BusinessObject���������κ��޸ġ�
 * ���������־��¼��������ظ������ˣ����е���ҵ������󶼿������������־�������� 
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
