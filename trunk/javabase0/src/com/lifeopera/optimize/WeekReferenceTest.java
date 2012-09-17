package com.lifeopera.optimize;

import java.lang.ref.WeakReference;

/**
 * @author 姜志强
 *  弱引用（WeakReference）与不可视阶段的对象：
    如果一个对象只具有弱引用，那就类似于可有可物的生活用品。弱引用与软引用的区别在于：只具有弱引用的对象拥有更短暂的生命周期。
    在垃圾回收器线程扫描它 所管辖的内存区域的过程中，一旦发现了只具有弱引用的对象，不管当前内存空间足够与否，都会回收它的内存。
    不过，由于垃圾回收器是一个优先级很低的线程， 因此不一定会很快发现那些只具有弱引用的对象。 弱引用可以和一个引用队列
    （ReferenceQueue）联合使用，如果弱引用所引用的对象被垃圾回收，Java虚拟机就会把这个弱引用加入到与之关联的引用队列中。
    2009-4-29
 */
public class WeekReferenceTest {
	boolean isLoop = false;
	
	/** 
	 *  不可视阶段的对象：
	 *  对象在使用完之后，在其不可视区域不再使用，此时应主动将其设置为空。
	 *  可将对象设为 null, 帮JVM及时发现这个垃圾对象，并且可以及时回收该对象所占用的系统资源。
	 */
	public void process(){
		try{
			A a = new A(); 
			a.run();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		while(isLoop){ 		//loop forever
			//这个区域对 a 来说已经不可视的了
			//因此下面的代码编译会引发错误
			//a.run();
		}
	}
	
	public static void main(String[] args) {
		A a = new A();
		//使用 a
		//。。。
		//使用完了 a, 将它设置为weak引用类型，并且释放强引用
		WeakReference<A> wr = new WeakReference<A>(a);
		a = null;
		//下次使用时
		if(wr!=null){
			a = wr.get();
		}else{
			a = new A();
			wr = new WeakReference<A>(a);
		}
		
	}

}
