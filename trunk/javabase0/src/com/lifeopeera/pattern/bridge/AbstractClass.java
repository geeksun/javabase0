package com.lifeopeera.pattern.bridge;

/**
 * @author ��־ǿ
 *  ������
 *  2009-5-20
 */
public abstract class AbstractClass {
	//���󷽷�
	public abstract void abstractMethod();
	
	/**
	 *  ��ȡʵ�ֶ���ķ���
	 */
	public ImplInterface getImpl(int type){
		if(type==1){
			return new ConcreteImplA();
		}else if(type==2){
			return new ConcreteImplB();
		}else{
			return new ConcreteImplA();
		}
	}
	
}
