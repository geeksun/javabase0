<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'Math object.jsp' starting page</title>
	<script type="text/javascript">
		//  数学运算,保留 y 位小数的四舍五入
		function round2(x,y)					  //  接收两个参数,一个为要计算的数字,一个为要保留几位小数
		{
			var p = Math.pow(10,y);				  //  即 10 的 y 次方
			alert(p);
			x *= p;
			x = Math.round(x);
			alert(x/p);
			return x/p;
		}
		//  随机函数 Math.random() 生成0到1之间的小数
		function random2()
		{
			var m = Math.random();
			alert(m);
			var n = Math.round(m*200);
			alert("0到200之间的随机数: "+n);
			var z = Math.round(m*100)+100;
			alert("100到200之间的随机数: "+z);
		}
		//  使用随机函数进行概率计算,模拟一根木棒随机折成三段,组成一个三角形的概率是多少
		function probability()
		{
			var totalCount = 10000;
			var okCount = 0;
			for(var i=0;i<totalCount;i++)
			{
				var p1 = Math.random();							//  得到第一个断点
				var p2 = Math.random();							//  第二个断点
				var s1 = Math.min(p1,p2);						//  得到第一段长度
				var s2 = Math.max(p1,p2)-s1;					//  得到第二段长度
				var s3 = 1-s1-s2;								//  第三段长度
				if(s1>=0.5||s2>=0.5||s3>=0.5) continue;			//  任意一边长超过0.5都不能组成三角形
				okCount++;
			}
			alert(okCount/totalCount);
		}
	</script>
  </head>
  
  <body>
  	<input type="button" onClick="round2(1834.832620,3)" value="保留小数位四舍五入的数学运算" >
  	<input type="button" onClick="random2()" value="随机数测试" >
  	<input type="button" onClick="probability();" value="木棒随机生成三角形测试" >
  	
  </body>
</html>
