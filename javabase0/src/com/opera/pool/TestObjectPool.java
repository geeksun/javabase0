package com.opera.pool;

/**
 * @author ��־ǿ
 *  �ͻ��˵��ö����: ͨ�ö����ʹ���������Ǻܷ���ģ��������Է���ر���Ƶ����������Ŀ���������ͨ�ó̶ȸߡ�
 *  ���ź����ǣ�������Ҫʹ�ô��������Ͷ��� ��cast���������ټ���һЩ��Vector���ͬ��������ʹ������ĳЩ����¶����ܵĸĽ��ǳ����ޣ�
 *  �������Щ�������ڱȽ϶̵Ķ���
 *  2009-5-1
 */
public class TestObjectPool {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//��������ع���
		ObjectPoolFactory poolFactory = ObjectPoolFactory. getInstance ();
		//��������������ص�����
		ParameterObject paraObj = new ParameterObject(10,2);
		
		//���ö���ع���, ����һ����� StringBuffer ���Ͷ���Ķ����
		//ObjectPool pool = poolFactory.createPool(paraObj, StringBuffer.class);
		/*//�ӳ���ȡ��һ��StringBuffer����
		StringBuffer buffer = (StringBuffer)pool.getObject();
		
		//ʹ�ôӳ���ȡ����StringBuffer����
		buffer.append("hello");
		System.out.println(buffer.toString()); */
		
		//���ö���ع���, ����һ����� Man ����ʵ���Ķ����
		ObjectPool pool = poolFactory.createPool(paraObj, Man.class);
		Man man = (Man) pool.getObject();
		man.setAge(18);
		System.out.print(man.getAge());
		
	}

}
