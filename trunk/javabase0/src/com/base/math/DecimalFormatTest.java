package com.base.math;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class DecimalFormatTest {
	 public static void main(String args[]) {
		  DecimalFormat myformat1 = new DecimalFormat("###,###.0000");//ʹ��ϵͳĬ�ϵĸ�ʽ
		  System.out.println(myformat1.format(111111123456.12));

		  Locale.setDefault(Locale.US);
		  DecimalFormat myformat2 = new DecimalFormat("###,###.0000");//ʹ�������ĸ�ʽ
		  System.out.println(myformat2.format(111111123456.12));

		  //----------------------------also use applypattern------------------------------//

		  DecimalFormat myformat3 = new DecimalFormat();
		  myformat3.applyPattern("##,###.000");
		  System.out.println(myformat3.format(11112345.12345));
		//-----------------����ָ�����-------------------------------------------------//

		     DecimalFormat myformat4 = new DecimalFormat();
		  myformat4.applyPattern("0.000E0000");
		  System.out.println(myformat4.format(10000));
		  System.out.println(myformat4.format(12345678.345));
		//------------------�ٷ��������-------------------------------------------//
		/*     DecimalFormat��NumberFormat��һ������,��ʵ����ָ��Ϊ�ض��ĵ�������ˣ������ʹ��NumberFormat.getInstance ָ��һ��������
		Ȼ�󽫽ṹǿ��ת��Ϊһ��DecimalFormat�����ĵ����ᵽ������������ڴ����������ã���������Ҫ��try/catch ���Χǿ��ת���Է�ת
		�������������� (����ڷǳ������Ե������ʹ��һ������ĵ���)��    */
		       DecimalFormat myformat5 = null;
		  try{
		      myformat5 = (DecimalFormat)NumberFormat.getPercentInstance();
		  }catch(ClassCastException e)
		  {
		   System.err.println(e); 
		  }
		  myformat5.applyPattern("00.0000%");
		  System.out.println(myformat5.format(0.34567));
		  System.out.println(myformat5.format(1.34567));
		 
		 }

		/*---------------------------------���н��-------------------------------------------//
		 F:\2004-04-12>java DecimalFormatSample
		111,111,123,456.1200
		111,111,123,456.1200
		11,112,345.123
		1.000E0004
		1.235E0007
		34.5670%
		134.5670%
		*/

}
