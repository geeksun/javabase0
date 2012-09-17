package com.base.pattern.bridge;

/**
 * @author ��־ǿ
 *  ����ģʽ: 
 *  2009-5-21
 */
public class BridgeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//����������� A ��ʵ��������ͨ���乹����ָ��ʵ�ֵ�����Ϊ ConcreteImplA
		ConcreteObjectA con = new ConcreteObjectA(1);
		//���þ������ A �ķ���
		con.abstractMethod();
		//������ ConcreteImplA �ķ���
		con.getImpl(1).implMethod();	
		
		//����������� A ��ʵ��������ͨ���乹����ָ��ʵ�ֵ�����Ϊ ConcreteImplB
		ConcreteObjectA con2 = new ConcreteObjectA(2);
		//���þ������ A �ķ����������� ConcreteImplB �ķ���
		con2.abstractMethod();
		
		//����������� B ��ʵ��������ͨ���乹����ָ��ʵ�ֵ�����Ϊ ConcreteImplA
		ConcreteObjectB co = new ConcreteObjectB(1);
		//���þ������ B �ķ����������� ConcreteImplA �ķ���
		co.abstractMethod();
		
		//����������� B ��ʵ��������ͨ���乹����ָ��ʵ�ֵ�����Ϊ ConcreteImplB
		ConcreteObjectB co2 = new ConcreteObjectB(2);
		//���þ������ B �ķ����������� ConcreteImplB �ķ���
		co2.abstractMethod();
	}

}
