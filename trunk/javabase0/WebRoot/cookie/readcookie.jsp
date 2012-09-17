<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>read cookie</title>
  </head>
  
  <body>
  <%
	Cookie cookies[]=request.getCookies(); // 将适用目录下所有Cookie读入并存入cookies数组中
	Cookie sCookie=null;
	String sname=null;
	String name=null;
	if(cookies==null)   // 如果没有任何cookie,必须先判断 cookie 是否为空
		out.print("none any cookie");
	else
	{
		out.println(cookies.length + " ");
		for(int i=0;i<cookies.length;i++){
			sCookie=cookies[i];
			sname=sCookie.getName();
			name = sCookie.getValue();
			out.println(sname + "->" + name + "	");
		}
	}
  %>

  </body>
</html>
