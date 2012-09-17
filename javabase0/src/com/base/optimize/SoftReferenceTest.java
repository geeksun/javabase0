package com.base.optimize;

import java.lang.ref.SoftReference;

/**
 * @author 姜志强
 *  软引用测试：软引用（Soft Reference）的主要特点是较强的引用功能，只有当内存不够的时候，才回收这类内存，因此在内存足够的时候，
 *  它们通常不会被回收。软引用对象还能保证在Java抛出OutOfMemory异常之前，被设置为null。可以用于实现一些常用资源的缓存，实现
 *  Cache 的功能，保证最大限度的使用内存而不引起 OutOfMemory 和 crash(崩溃)。
 *  2009-4-29
 */
public class SoftReferenceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		A a = new A();
		//使用 a
		//....;
		//使用完了a，将它设置为soft引用类型，并且释放强引用
		SoftReference<A> sr = new SoftReference<A>(a);
		a = null;
		//下次使用时
		if(sr!=null){
			a = sr.get();
		}else{
			//GC 由于低内存，已释放 a，因此要需要重新装载
			a = new A();
			sr = new SoftReference<A>(a);
		}
		
	}

}
