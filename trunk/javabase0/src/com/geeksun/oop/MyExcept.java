package com.geeksun.oop;

/**
 * @author Administrator
 * @see �Զ����쳣��Ӧ���̳�Exception��
 */
class MyException extends Exception{
	private static final long serialVersionUID = 1L;
	MyException(String ErrorMessage){
		super(ErrorMessage);
	}
}
public class MyExcept {
	static int avg(int a,int b) throws MyException{
		if(a<0||b<0){
			throw new MyException("��ֵ����");
		}
		else if(a>100||b>100){
			throw new MyException("��ֵ����");
		}
		return (a+b)/2;
	}
	public static void main(String args[]){
		try {
			System.out.println(avg(-22,33));
		} catch (MyException e) {
			e.printStackTrace();
		}
	}
}
