<%@ page language="java" import="java.io.*" pageEncoding="gbk"%>
<%
	String a = request.getServletPath();
	String b = request.getContextPath();
	String c = this.getServletContext().toString();
	InputStream e = this.getServletContext().getResourceAsStream("/WEB-INF/cn.xls");	//  加载文件，得到输出流
	String d = this.getServletName();
	out.println("---:"+a+"---:"+b+"---:"+c+"---:"+d);
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Hello Ajax</title>      

  </head>
  
  <body>
     Hello,Ajax,<%=request.getParameter("name")%>!
  </body>
</html>
