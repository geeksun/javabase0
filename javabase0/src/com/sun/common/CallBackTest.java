package com.sun.common;

/**
 * @author geeksun
 * @version 回调函数
 */
public class  CallBackTest
{
   public static void main(String[] args)             //主函数
	{
	   
	}
}


interface InterFace2
{
	public void go();
}

class Super
{
	public void go()
	{
		System.out.println("Super go()");
	}
}

class Sun extends Super
{
	public void interGo(){                            //普通方法
		new InterFace2(){                             //创建对象       定义: 方法内部的匿名类
			public void go() 
			{
				System.out.println("InterFace2 go()");
			}}.go();                                  // 匿名类相当于一个对象:无变量引用的对象
	}
}

class Sun2 extends Super
{
	private void myGo(){                              //  私有成员
		System.out.println("Sun2 go()");
	}
	public void interGo()                    
	{
		new InterFace2(){

			public void go()
			{
				myGo();
				
			}}.go();
	}
}
class Sun3 extends Super
{
	private void myGo()
	{
		System.out.println("Sun2 go()");
	}
	
	private class Inner implements InterFace2
	{

		public void go()
		{
			myGo();
		}
	}
	public InterFace2 getCallbackref()
	{
		return new Inner();
	}
}
