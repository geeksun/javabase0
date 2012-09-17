package com.sun.common;

/**
 * @author geeksun
 * @version �ص�����
 */
public class  CallBackTest
{
   public static void main(String[] args)             //������
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
	public void interGo(){                            //��ͨ����
		new InterFace2(){                             //��������       ����: �����ڲ���������
			public void go() 
			{
				System.out.println("InterFace2 go()");
			}}.go();                                  // �������൱��һ������:�ޱ������õĶ���
	}
}

class Sun2 extends Super
{
	private void myGo(){                              //  ˽�г�Ա
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
