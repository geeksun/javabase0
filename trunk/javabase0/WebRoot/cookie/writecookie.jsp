<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>write cookie</title>
  </head>
  
  <body>
    <% 
		Cookie _cookie=new Cookie("user_delfancom", "delfan");
		_cookie.setMaxAge(30*60); 		// 设置Cookie的存活时间为30分钟,以秒计算&1200
		response.addCookie(_cookie);	// 写入客户端硬盘
		out.print("写Cookie完成");
	%>

  </body>
</html>
