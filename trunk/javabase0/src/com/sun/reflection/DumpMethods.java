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
	 * 此方法使用时,需要在命令行输入参数,如:java.util.Stack,java.lang.String
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		// 加载并初始化命令行参数指定的类
		Class classType = Class.forName(args[0]);
		// 获得类的所有方法
		Method methods[] = classType.getDeclaredMethods();
		for(int i=0;i<methods.length;i++)
		{
			System.out.println(methods[i].toString());
		}
	}
}
