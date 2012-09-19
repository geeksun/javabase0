package com.base.util2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ��־ǿ
 * ģʽ�ࣨ������ʽ��
 */
public class PatternTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Pattern myRE = Pattern.compile("d.*ian");
		Matcher matcher = myRE.matcher("darwinian pterodactyls soared over the devonian space");
		// find() : look for next element
		matcher.lookingAt();
		
		String result = matcher.group(0);
		System.out.println(result);

	}

}
