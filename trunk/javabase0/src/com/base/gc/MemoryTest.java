package com.base.gc;

/**
 * @author 姜志强
 *  查看 JVM 回收内存的信息: java -verbosegc 命令查看
 *  E:\>java -verbosegc MemoryTest
	[GC 512K->132K(1984K), 0.0016676 secs]
	this is a GC test
	有 1984KB 内存被回收，耗时 0.0016676 秒
	加上gc(): 可见强制系统垃圾回收影响系统性能比较大
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
