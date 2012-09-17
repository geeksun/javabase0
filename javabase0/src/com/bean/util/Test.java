package com.bean.util;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

public class Test {
	
	/**
	 * @param args
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
		BeanUtils.copyProperties(args[0], args[1]); 
		
	}

}
