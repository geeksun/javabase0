package com.base.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author 姜志强
 * @reflect: 使用反射检查类的方法, 可用 java.util.Random 来测试
 * 2009-4-25
 */
public class SeeMethods {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Class<?> inspect; 
		try{
			if(args.length>0){
				inspect = Class.forName(args[0]);		//创建 Class 对象
			}else{
				inspect = Class.forName("com.geeksun.reflect.SeeMethods");
			}
			Method[] methods = inspect.getDeclaredMethods();	//找出类中的所有方法（继承的除外）
			for(int i=0;i<methods.length;i++){
				Method methVal = methods[i];
				Class<?> returnVal = methVal.getReturnType();	//返回类型
				int mods = methVal.getModifiers(); 
				String modVal = Modifier.toString(mods);		//修饰符
				Class<?>[] paramVal = methVal.getParameterTypes();	//方法接收的参数类型
				StringBuffer params = new StringBuffer(); 
				for(int j=0;j<paramVal.length;j++){
					if(j>0){
						params.append(", ");
					}
					params.append(paramVal[j].getName());
				}
				System.out.println("Method:"+methVal.getName()+"()");
				System.out.println("Modifiers:"+modVal);		
				System.out.println("Return Type:"+returnVal.getName());
				System.out.println("Parameters:"+params+"\n");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
