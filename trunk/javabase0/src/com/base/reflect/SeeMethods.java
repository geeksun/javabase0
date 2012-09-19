package com.base.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author ��־ǿ
 * @reflect: ʹ�÷�������ķ���, ���� java.util.Random ������
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
				inspect = Class.forName(args[0]);		//���� Class ����
			}else{
				inspect = Class.forName("com.geeksun.reflect.SeeMethods");
			}
			Method[] methods = inspect.getDeclaredMethods();	//�ҳ����е����з������̳еĳ��⣩
			for(int i=0;i<methods.length;i++){
				Method methVal = methods[i];
				Class<?> returnVal = methVal.getReturnType();	//��������
				int mods = methVal.getModifiers(); 
				String modVal = Modifier.toString(mods);		//���η�
				Class<?>[] paramVal = methVal.getParameterTypes();	//�������յĲ�������
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
