package com.geeksun.util;

/**
 * @author geeksun
 * @version �ص������������ɳ���Ա��д�ģ���WINDOWSϵͳ���õĺ���,��Ҫ�����첽ͨ��,����AJAX��
 * JAVA �лص�����һ����ͨ���ӿ�ʵ�ֵ�
 */
public class CallBack {
	   public static void main(String[] args){
	     FooBar foo=new FooBar();
	     foo.setCallBack(new ICallBack(){
	        public void postExec(){System.out.println("method executed.");}
	     });
	   }
	}

	