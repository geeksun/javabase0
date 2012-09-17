package com.base.reflection;

import java.io.Serializable;

/**
 *  远程方法调用,在调用中运用反射机制, Call表示客户端发起的一个远程调用
 */
public class Call implements Serializable{
	private String className;		//  表示类名或接口名
	private String methodName;		//  表示方法名
	private Class[] paramTypes;		//  表示方法参数类型
	private Object[] params;		//  表示方法参数值
	private Object result;			//  表示方法的执行结果
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
