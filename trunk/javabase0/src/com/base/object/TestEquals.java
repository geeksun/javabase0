package com.base.object;
class A{
	
}
class B{
	/* 
	 * @see java.lang.Object#hashCode()
	 * ��д hashCode ����
	 */
	public int hashCode(){
		return 14285251;
	}
}
//equals���������Լ��Ĺ����ж����������Ƿ���ȣ�����д��equals�󣬰���java�Ĺ���������Ҫ��дhashCode ������hibernate��
public class TestEquals {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		//14285251 10267414
		System.out.println(a.hashCode()+" "+b.hashCode());
		//System.out.println(a==b);
		//�Ƚ����������Ƿ����
		System.out.println(a.equals(b));
		
		String aa = "123";
		String bb = "123";
		//�Ƚ������ַ��������Ƿ���ͬ
		System.out.println(aa==bb);
		
		
	}

	
	
	
	
	
}
