package com.base.optimize;

import java.util.Hashtable;

/**
 * @author ��־ǿ ����أ�������󣬿������Ӧ�õ��ٶȣ������ڴ���Ҫ����JDBC���ӳػ�EJBʵ����,�̳߳ء�
 *         ����ϵͳ���ܣ���Լϵͳ�ڴ濪����ͨ���������������Ĺ�������ã�������Ӧ���̷߳����ؽ���װ�ض���Ĺ�������Ҫ��ʱ�䣬
 *         ����Ҳ��Ч������Ƶ���������մ����ľ޴�ϵͳ������ 
 * 2009-4-30
 */
public abstract class ObjectPool {
	// ������δ����
	private Hashtable locked, unlocked;
	// ����ʱ��
	private long expirationTime;

	// ��������
	abstract Object create();

	// �������
	abstract void expire(Object o);

	// ������Ч����֤
	abstract void validate(Object o);

	// ��ȡ����
	synchronized Object getObject() {
		return null;
	}

	// �����ͷ�: ���󷽷���������Ϊͬ��, ��Ϊ�������ľ���ʵ�ֻ������������ͬ�������󣿿����������ʵ�ַ�������ʵ��
	synchronized void freeObject(Object o) {
		o = null;
	}
	
	// �����Ч����
	synchronized  void cleanUp(){
		
	}
}
