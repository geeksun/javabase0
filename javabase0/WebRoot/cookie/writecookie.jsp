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
		_cookie.setMaxAge(30*60); 		// ����Cookie�Ĵ��ʱ��Ϊ30����,�������&1200
		response.addCookie(_cookie);	// д��ͻ���Ӳ��
		out.print("дCookie���");
	%>

  </body>
</html>
