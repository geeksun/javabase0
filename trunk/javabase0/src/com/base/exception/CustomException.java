package com.base.exception;

/**
 * @author ��־ǿ
 * �Զ����쳣,��̳�Exception��
 */
class Cust extends Exception
{
	Cust(String errorMessage)
	{
		super(errorMessage);
	}
}
public class CustomException {
	static int avg(int a,int b) throws Cust
	{
		if(a<0||b<0)
			throw new Cust("��ֵ����");
		else if(a>100||b>100)
			throw new Cust("��ֵ����");
		return (a+b)/2;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			System.out.println(avg(10,102));
		}catch(Cust c)
		{
			System.out.println(c);
		}
	}
}
