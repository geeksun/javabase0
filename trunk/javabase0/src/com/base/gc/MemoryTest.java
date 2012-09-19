package com.base.gc;

/**
 * @author ��־ǿ
 *  �鿴 JVM �����ڴ����Ϣ: java -verbosegc ����鿴
 *  E:\>java -verbosegc MemoryTest
	[GC 512K->132K(1984K), 0.0016676 secs]
	this is a GC test
	�� 1984KB �ڴ汻���գ���ʱ 0.0016676 ��
	����gc(): �ɼ�ǿ��ϵͳ��������Ӱ��ϵͳ���ܱȽϴ�
	E:\>java -verbosegc MemoryTest
	[GC 512K->132K(1984K), 0.0016966 secs]
	[Full GC 584K->132K(1984K), 0.0274313 secs]
	this is a GC test
 *  2009-5-1
 */
public class MemoryTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for(int i=0;i<100000;i++){
			MemoryTest mt = new MemoryTest();
			//mt = null;
		}
		System.gc();
		System.err.print("this is a GC test\n");
	}

}
