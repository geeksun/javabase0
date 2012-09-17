<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:include  page ="b.jsp" /> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'a.jsp' starting page</title>

  </head>
  
  <body>
    This is my JSP page. <br>
  </body>
</html>
