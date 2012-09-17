package com.geeksun.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author 姜志强
 *  接收一个类名作为命令行参数，并检查它是否是应用程序：有main(), contains()包含
 *  2009-4-25
 */
public class InspectAppClass {

	public static void main(String[] args) {
		Class<?> inspect;
		try {
			if(args.length>0){
				inspect = Class.forName(args[0]);
				Method[] method = inspect.getDeclaredMethods();
				for(Method met:method){
					Class<?> reType = met.getReturnType();
					String modifier = Modifier.toString(met.getModifiers());
					Class<?>[] params = met.getParameterTypes();
					StringBuilder bu = new StringBuilder();
					for(int i=0;i<params.length;i++){
						if(i>0)
							bu.append(", ");
						bu.append(params[i].getName());
					}
					//System.out.print(bu+"\n");
					if(bu.toString().contains("java.lang.String")){	//value:[Ljava.lang.String;
						System.out.print("String[] type\n");
					}
					if(modifier.equals("public static")){
						System.out.print("public static\n");
					}
					if(reType.getName().equals("void")){
						System.out.print("void\n");
					}
					if(met.getName().equals("main")){
						System.out.print("Method: main()\n");
					}
				}
				
			}else{
				System.err.print("No enable param\n");
			}
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
