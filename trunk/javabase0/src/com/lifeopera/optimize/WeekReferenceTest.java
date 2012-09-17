package com.lifeopera.optimize;

import java.lang.ref.WeakReference;

/**
 * @author ��־ǿ
 *  �����ã�WeakReference���벻���ӽ׶εĶ���
    ���һ������ֻ���������ã��Ǿ������ڿ��п����������Ʒ���������������õ��������ڣ�ֻ���������õĶ���ӵ�и����ݵ��������ڡ�
    �������������߳�ɨ���� ����Ͻ���ڴ�����Ĺ����У�һ��������ֻ���������õĶ��󣬲��ܵ�ǰ�ڴ�ռ��㹻��񣬶�����������ڴ档
    ����������������������һ�����ȼ��ܵ͵��̣߳� ��˲�һ����ܿ췢����Щֻ���������õĶ��� �����ÿ��Ժ�һ�����ö���
    ��ReferenceQueue������ʹ�ã���������������õĶ����������գ�Java������ͻ����������ü��뵽��֮���������ö����С�
    2009-4-29
 */
public class WeekReferenceTest {
	boolean isLoop = false;
	
	/** 
	 *  �����ӽ׶εĶ���
	 *  ������ʹ����֮�����䲻����������ʹ�ã���ʱӦ������������Ϊ�ա�
	 *  �ɽ�������Ϊ null, ��JVM��ʱ��������������󣬲��ҿ��Լ�ʱ���ոö�����ռ�õ�ϵͳ��Դ��
	 */
	public void process(){
		try{
			A a = new A(); 
			a.run();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		while(isLoop){ 		//loop forever
			//�������� a ��˵�Ѿ������ӵ���
			//�������Ĵ���������������
			//a.run();
		}
	}
	
	public static void main(String[] args) {
		A a = new A();
		//ʹ�� a
		//������
		//ʹ������ a, ��������Ϊweak�������ͣ������ͷ�ǿ����
		WeakReference<A> wr = new WeakReference<A>(a);
		a = null;
		//�´�ʹ��ʱ
		if(wr!=null){
			a = wr.get();
		}else{
			a = new A();
			wr = new WeakReference<A>(a);
		}
		
	}

}
