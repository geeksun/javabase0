package com.base.exception;

/**
 * @author 姜志强
 * 自定义异常,须继承Exception类
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
			throw new Cust("负值不可");
		else if(a>100||b>100)
			throw new Cust("数值过大");
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
