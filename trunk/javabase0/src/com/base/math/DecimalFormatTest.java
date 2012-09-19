package com.base.math;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class DecimalFormatTest {
	 public static void main(String args[]) {
		  DecimalFormat myformat1 = new DecimalFormat("###,###.0000");//使用系统默认的格式
		  System.out.println(myformat1.format(111111123456.12));

		  Locale.setDefault(Locale.US);
		  DecimalFormat myformat2 = new DecimalFormat("###,###.0000");//使用美国的格式
		  System.out.println(myformat2.format(111111123456.12));

		  //----------------------------also use applypattern------------------------------//

		  DecimalFormat myformat3 = new DecimalFormat();
		  myformat3.applyPattern("##,###.000");
		  System.out.println(myformat3.format(11112345.12345));
		//-----------------控制指数输出-------------------------------------------------//

		     DecimalFormat myformat4 = new DecimalFormat();
		  myformat4.applyPattern("0.000E0000");
		  System.out.println(myformat4.format(10000));
		  System.out.println(myformat4.format(12345678.345));
		//------------------百分数的输出-------------------------------------------//
		/*     DecimalFormat是NumberFormat的一个子类,其实例被指定为特定的地区。因此，你可以使用NumberFormat.getInstance 指定一个地区，
		然后将结构强制转换为一个DecimalFormat对象。文档中提到这个技术可以在大多情况下适用，但是你需要用try/catch 块包围强制转换以防转
		换不能正常工作 (大概在非常不明显得情况下使用一个奇异的地区)。    */
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

		/*---------------------------------运行结果-------------------------------------------//
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
