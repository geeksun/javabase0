package com.base.reflection;

import java.io.Serializable;

/**
 *  Զ�̷�������,�ڵ��������÷������, Call��ʾ�ͻ��˷����һ��Զ�̵���
 */
public class Call implements Serializable{
	private String className;		//  ��ʾ������ӿ���
	private String methodName;		//  ��ʾ������
	private Class[] paramTypes;		//  ��ʾ������������
	private Object[] params;		//  ��ʾ��������ֵ
	private Object result;			//  ��ʾ������ִ�н��
	private Call(){}
	Call(String className,String methodName,Class[] paramTypes,Object[] params) 
	{
		this.className = className;
		this.methodName = methodName;
		this.paramTypes = paramTypes;
		this.params = params;
	}
	public String getClassName()
	{
		return className;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public Object[] getParams() {
		return params;
	}
	public void setParams(Object[] params) {
		this.params = params;
	}
	public Class[] getParamTypes() {
		return paramTypes;
	}
	public void setParamTypes(Class[] paramTypes) {
		this.paramTypes = paramTypes;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String toString()
	{
		return "className="+className+" methodName="+methodName;
	}
}
