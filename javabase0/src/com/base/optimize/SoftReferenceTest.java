package com.base.optimize;

import java.lang.ref.SoftReference;

/**
 * @author ��־ǿ
 *  �����ò��ԣ������ã�Soft Reference������Ҫ�ص��ǽ�ǿ�����ù��ܣ�ֻ�е��ڴ治����ʱ�򣬲Ż��������ڴ棬������ڴ��㹻��ʱ��
 *  ����ͨ�����ᱻ���ա������ö����ܱ�֤��Java�׳�OutOfMemory�쳣֮ǰ��������Ϊnull����������ʵ��һЩ������Դ�Ļ��棬ʵ��
 *  Cache �Ĺ��ܣ���֤����޶ȵ�ʹ���ڴ�������� OutOfMemory �� crash(����)��
 *  2009-4-29
 */
public class SoftReferenceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		A a = new A();
		//ʹ�� a
		//....;
		//ʹ������a����������Ϊsoft�������ͣ������ͷ�ǿ����
		SoftReference<A> sr = new SoftReference<A>(a);
		a = null;
		//�´�ʹ��ʱ
		if(sr!=null){
			a = sr.get();
		}else{
			//GC ���ڵ��ڴ棬���ͷ� a�����Ҫ��Ҫ����װ��
			a = new A();
			sr = new SoftReference<A>(a);
		}
		
	}

}
