<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="gbk"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>object script</title>
	<script type="text/javascript">
		function show(){
			alert("hello");
			var a,b=2,c;
			c=3;
			a=c;
			alert(a);			// 3	
		}
		function Temp(){		//  定义类和定义方法在一起
			var a = 9;
		}
		function test(){
			var mm = new Temp();
			alert(mm.a);
			alert(typeof(mm));				//  typeof() 用来获取一个变量所包含数据的类型													
		}
		function oper(){
			var arr = new Array();
			arr["push"]("abds");					//  为数组添加一个元素
			var len = arr["length"];				//  获得数组的长度
			alert(len);
		}
		//  测试值传递
		function pass(){
			function addFlag(obj){
				obj.flag = "object";
			}
			var obj = new Object();
			alert(obj.flag);
			addFlag(obj);
			alert(obj.flag);
		}
		//  javascript come true recursion
		function sum(n){
			if(0==n) return 0;
			return n+sum(n-1);
		}
	</script>
  </head>
  
  <body onload = "test()">
      <input type="button" onclick="pass()" value="测试 Pass By Reference" >			
      <input type="button" onclick="alert(sum(10))" value="递归测试" >																						
  </body>
</html>
