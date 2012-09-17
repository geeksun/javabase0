package com.geeks.thread;
/**
 *  ThreadLocal 的测试,该类提供了线程局部变量
 *  ThreadLocal 实例通常是类中的私有静态字段，它们希望将状态与某一个线程（例如，用户 ID 或事务 ID）相关联。
 *  2009-9-11
 */
public class ThreadLocalTest {
    //  The next serial number to be assigned
	//  私有静态 ThreadLocal 实例
    private static int nextSerialNum = 0;

    private static ThreadLocal serialNum = new ThreadLocal() {
        protected synchronized Object initialValue() {
            return new Integer(nextSerialNum++);
        }
    };
    /**
     * @return 当前线程的序列号
     */
    public static int get() {
        return ((Integer) (serialNum.get())).intValue();
    }
}
