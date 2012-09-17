<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>this cursor</title>
	<script language="JavaScript" type="text/javascript"> 
		/*
		 *  js 中 this 指针的测试,this 指针是一个动态的变量
		 */
		function testCursor()
		{
			//  创建两个空对象 
			var obj1=new Object(); 
			var obj2=new Object(); 
			//  给两个对象都添加属性p，并分别等于1和2 
			obj1.p=1; 
			obj2.p=2; 
			//  给obj1添加方法，用于显示p的值 
			obj1.getP=function()
			{ 
			      alert(this.p); 				//  表面上this指针指向的是obj1 
			} 
			//  调用obj1的getP方法 
			obj1.getP(); 
			//  使obj2的getP方法等于obj1的getP方法 
			obj2.getP=obj1.getP; 
			//  调用obj2的getP方法,此时的this为obj2对象
			obj2.getP(); 
		}
		/*
		 *	$()在 js 中的用法
		 */
		function test(id)
		{
			var i = $(id);
			alert(i);
		}
	</script>
	
  </head>
  
  <body>
    <input type="button" name="this" value="this" onClick="testCursor()">
    <input type="button" name="test" value="test" onclick="test(5)">
  </body>
</html>
