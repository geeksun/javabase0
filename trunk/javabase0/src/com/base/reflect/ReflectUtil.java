package com.base.reflect;

import java.lang.reflect.Field;

/**
 * @author geeksun
 *	反射工具类
 */
public class ReflectUtil {
	
	/**
	 * @author yang_gz
	 * @function: 从数组中取出指定值
	 * @param strMacro ComboxMacroDefine接口里宏定义的名称
	 * @param strMacroValue 宏定义的取值
	 * @return 宏定义中取值对应的显示值
	 */
	public static String getMacroDisplayValue(String strMacro, String strMacroValue) {
		String strReturn = "";
		try {
			Field field = MacroDefine.class.getDeclaredField(strMacro);

			String[][] strs = (String[][]) field.get(null);

			for (int i = 0; i < strs.length; i++) {
				if (strs[i][0].equals(strMacroValue) == true) {
					strReturn = strs[i][1];
					break;
				}
			}
		} catch (Exception e) {
			return strReturn;
		}
		return strReturn;
	}
	
	
	
}
