package com.sun.reflection;
import java.lang.reflect.Method;
public class DumpMethods {
	private int i;
	private String s;
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public String getS() {
		return s;
	}
	public void setS(String s) {
		this.s = s;
	}
	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * �˷���ʹ��ʱ,��Ҫ���������������,��:java.util.Stack,java.lang.String
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		// ���ز���ʼ�������в���ָ������
		Class classType = Class.forName(args[0]);
		// ���������з���
		Method methods[] = classType.getDeclaredMethods();
		for(int i=0;i<methods.length;i++)
		{
			System.out.println(methods[i].toString());
		}
	}
}
