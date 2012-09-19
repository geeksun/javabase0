package com.base.reflect;

import java.lang.reflect.Field;

/**
 * @author geeksun
 *	���乤����
 */
public class ReflectUtil {
	
	/**
	 * @author yang_gz
	 * @function: ��������ȡ��ָ��ֵ
	 * @param strMacro ComboxMacroDefine�ӿ���궨�������
	 * @param strMacroValue �궨���ȡֵ
	 * @return �궨����ȡֵ��Ӧ����ʾֵ
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
