package com.base.inner;

/**
 * @category ˵�����£� 
 * һ.��̬�ڲ�������о�̬��Ա�����Ǿ�̬�ڲ��������о�̬��Ա�� �� A��B �� 
 * ��.��̬�ڲ���ķǾ�̬��Ա���Է����ⲿ��ľ�̬�����������ɷ����ⲿ��ķǾ�̬������return d1 ���� �� D �� 
 * ��.�Ǿ�̬�ڲ���ķǾ�̬��Ա���Է����ⲿ��ķǾ�̬������ �� C ��ȷ 
 * ��.��ΪC��E 
 */
public class Outer {
	private static double d1 = 1.0; 
	/*class InnerOne{ 
		public static double methoda() 
		{
			return d1;
		} */
		/*public class InnerOne{ 
			static double methoda() {return d1;} 
			} */
	/*private class InnerOne{ 
		double methoda() {return d1;} 
	} */
	static class InnerOne{ 
		protected double methoda() {
			return d1;
		} 
	}
	
	abstract class InnerTwo{ 
		public abstract double methoda(); 
	} 
}
