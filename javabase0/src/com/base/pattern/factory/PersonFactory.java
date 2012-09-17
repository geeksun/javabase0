package com.base.pattern.factory;

/**
 *  Person ������,�������ɴ��� Person,ǰ����ʵ����Person�ӿ�
 */
public class PersonFactory {
	/**
	 * ��� Person ʵ����ʵ����������
	 * @param ethnic
	 * @return  
	 */
	public Person getPerson(String ethnic)
	{
		// ���ݲ������� Person �ӿڵ�ʵ��
		if(ethnic.equalsIgnoreCase("chinese"))
		{
			return new Chinese();
		}
		else
		{
			return new American();
		}
	}

}
