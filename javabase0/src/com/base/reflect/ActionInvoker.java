package com.base.reflect;

import java.lang.reflect.Method;

public class ActionInvoker {

	private Method method;
	private Car car;

	public ActionInvoker(Car bean, Method method) {
		this.method = method;
		this.car = bean;
	}

	public ActionInvoker() {
		// TODO Auto-generated constructor stub
	}

	public String invoke() throws Exception {
		try {
			return (String) method.invoke(car, null);
		} catch (Exception e) {
			throw new Exception("Error invoking Action.  Cause: " + e, e);
		}
	}
	
	
}
