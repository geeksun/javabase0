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
         System.out.println("���ն���" + id);  
     }  
}  

/**
 * @author geeksun
 *  gc() ����֤�����ڴ������ִ��
 */
public class TestReferences {  
     public static void main(String[] args) {  
    	 
         // ����ǿ���ã�gc()ֻ����ʽ�ĸ�ֵΪ null,gc �Ż���Ϊ���ն���.
         MyObject ref = new MyObject("Hard");  
         System.out.println(ref);  
         ref = null;  
         System.gc();  
         System.out.println(ref);  
   
         // ����������
         //SoftReference<myobject></myobject> softRef = new SoftReference<myobject></myobject>(new MyObject("Soft"));  
         SoftReference softRef = new SoftReference( new MyObject("Soft"));  
         System.out.println(softRef.get());  
         System.gc();  
         System.out.println(softRef.get());  
   
         // ���������ã�gc()���Զ������ú������ôﵽ���˼�Ӱ��Ч��
         //WeakReference<myobject></myobject> weakRef = new WeakReference<myobject></myobject>(  
         WeakReference weakRef = new WeakReference( new MyObject("Weak"));  
         System.out.println("before gc ���� " + weakRef.get());  
         System.gc();  
         System.out.println("after gc ���� " + weakRef.get());  
   
         // ����������
         //ReferenceQueue<myobject></myobject> rq = new ReferenceQueue<myobject></myobject>();  
         //PhantomReference<myobject></myobject> phantomRef = new PhantomReference<myobject></myobject>(  
         ReferenceQueue rq = new ReferenceQueue();
         PhantomReference phantomRef = new PhantomReference( new MyObject("Phantom"), rq);  
         System.out.println("before gc ���� " + phantomRef.get());  
         System.gc();  
         System.out.println("after gc ���� " + phantomRef.get());  
     }  
 }  
