package com.geeks.thread;
/**
 *  ThreadLocal �Ĳ���,�����ṩ���ֲ߳̾�����
 *  ThreadLocal ʵ��ͨ�������е�˽�о�̬�ֶΣ�����ϣ����״̬��ĳһ���̣߳����磬�û� ID ������ ID���������
 *  2009-9-11
 */
public class ThreadLocalTest {
    //  The next serial number to be assigned
	//  ˽�о�̬ ThreadLocal ʵ��
    private static int nextSerialNum = 0;

    private static ThreadLocal serialNum = new ThreadLocal() {
        protected synchronized Object initialValue() {
            return new Integer(nextSerialNum++);
        }
    };
    /**
     * @return ��ǰ�̵߳����к�
     */
    public static int get() {
        return ((Integer) (serialNum.get())).intValue();
    }
}
