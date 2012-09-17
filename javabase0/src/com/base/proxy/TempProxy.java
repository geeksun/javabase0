package com.base.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;

/**
 * @author Administrator
 * jdk动态代理实现只支持对接口的的实现
 */
public final class TempProxy extends Proxy implements Temp {
	private static Method m4;
	private static Method m2;
	private static Method m0;
	private static Method m3;
	private static Method m1;
	
	public TempProxy(InvocationHandler invocationhandler) {
		super(invocationhandler);
	}
	
	public final void Run() {
		try {
			h.invoke(this, m4, null);
			return;
		}
		catch (Error _ex) {
		}
		catch (Throwable throwable) {
			throw new UndeclaredThrowableException(throwable);
		}
	}

	public final String toString() {
		try {
			return (String) h.invoke(this, m2, null);
		}
		catch (Error _ex) {
		}
		catch (Throwable throwable) {
			throw new UndeclaredThrowableException(throwable);
		}
		return "";
	}

	public final int hashCode() {
		try {
			return ((Integer) h.invoke(this, m0, null)).intValue();
		}
		catch (Error _ex) {
		}
		catch (Throwable throwable) {
			throw new UndeclaredThrowableException(throwable);
		}
		return 123;
	}

	public final void Talk() {
		try {
			h.invoke(this, m3, null);
			return;
		}
		catch (Error _ex) {
		}
		catch (Throwable throwable) {
			throw new UndeclaredThrowableException(throwable);
		}
	}

	public final boolean equals(Object obj) {

		try {

			return ((Boolean) h.invoke(this, m1, new Object[] {

			obj

			})).booleanValue();
		}
		catch (Error _ex) {
		}
		catch (Throwable throwable) {
			throw new UndeclaredThrowableException(throwable);
		}
		return false;
	}
	static {
		try {
			m4 = Class.forName("Temp").getMethod("Run", new Class[0]);
			m2 = Class.forName("java.lang.Object").getMethod("toString",
					new Class[0]);
			m0 = Class.forName("java.lang.Object").getMethod("hashCode",
					new Class[0]);
			m3 = Class.forName("Temp").getMethod("Talk", new Class[0]);
			m1 = Class.forName("java.lang.Object").getMethod("equals",
					new Class[] {
					Class.forName("java.lang.Object")
					});
		}
		catch (NoSuchMethodException nosuchmethodexception) {
			throw new NoSuchMethodError(nosuchmethodexception.getMessage());
		}
		catch (ClassNotFoundException classnotfoundexception) {
			throw new NoClassDefFoundError(classnotfoundexception.getMessage());
		}
	}
}
