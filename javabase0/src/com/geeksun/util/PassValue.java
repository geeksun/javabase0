package com.geeksun.util;
/**
 * @author geeksun
 * @version 值传递的示例
 */
public class PassValue {
	public static void main(String[] args) {		 
		PassValue t = new PassValue();
		
		t.amathod();
	}	
	public void amathod(){
		int i =9;                               //  局部变量
		Temp v = new Temp();
		v.i = 30;
		another(v,i);                               
		System.out.println(v.i+"$$$$");			//  20 
	}
	class Temp {
		public int i = 10;	
	}
	public void another(Temp v,int i){          //  V为值传递，I为引用传递
		i=0;
		v.i=20;
		
		Temp vh = new Temp();
		v = vh;
		
		System.out.println(v.i+"***");          //  10
		System.out.println(i+"@@@@@");	        //  0			
	}

}
