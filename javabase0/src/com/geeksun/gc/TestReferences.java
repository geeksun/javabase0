package com.geeksun.gc;
import java.lang.ref.PhantomReference; 
import java.lang.ref.ReferenceQueue;  
import java.lang.ref.SoftReference;  
import java.lang.ref.WeakReference;  
class MyObject {  
     private String id;  
     public MyObject(String id) {  
         this.id = id;  
     }  
   
     public String toString() {  
         return id;  
     }  
   
     public void finalize() {  
         System.out.println("回收对象：" + id);  
     }  
}  

/**
 * @author geeksun
 *  gc() 不保证清理内存会马上执行
 */
public class TestReferences {  
     public static void main(String[] args) {  
    	 
         // 创建强引用：gc()只有显式的赋值为 null,gc 才会视为回收对象.
         MyObject ref = new MyObject("Hard");  
         System.out.println(ref);  
         ref = null;  
         System.gc();  
         System.out.println(ref);  
   
         // 创建软引用
         //SoftReference<myobject></myobject> softRef = new SoftReference<myobject></myobject>(new MyObject("Soft"));  
         SoftReference softRef = new SoftReference( new MyObject("Soft"));  
         System.out.println(softRef.get());  
         System.gc();  
         System.out.println(softRef.get());  
   
         // 创建弱引用：gc()可以对弱引用和虚引用达到立杆见影的效果
         //WeakReference<myobject></myobject> weakRef = new WeakReference<myobject></myobject>(  
         WeakReference weakRef = new WeakReference( new MyObject("Weak"));  
         System.out.println("before gc —— " + weakRef.get());  
         System.gc();  
         System.out.println("after gc —— " + weakRef.get());  
   
         // 创建虚引用
         //ReferenceQueue<myobject></myobject> rq = new ReferenceQueue<myobject></myobject>();  
         //PhantomReference<myobject></myobject> phantomRef = new PhantomReference<myobject></myobject>(  
         ReferenceQueue rq = new ReferenceQueue();
         PhantomReference phantomRef = new PhantomReference( new MyObject("Phantom"), rq);  
         System.out.println("before gc —— " + phantomRef.get());  
         System.gc();  
         System.out.println("after gc —— " + phantomRef.get());  
     }  
 }  
