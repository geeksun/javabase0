<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'request.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<form action = "index.jsp" method = "get" >
     <table align="center" width="800" >
      <tr>
         <td>Name:</td><td><input type="text" size = "20" name="name"></td>
          </tr>
          <tr>
       	  <td>Password:</td><td><input type="password" size = "20" name="pwd"></td>         
          </tr>
          <tr>
           <td></td><td><input type="submit" value="submit" ></td> 
          </tr>
     </table>
    </form>
  	
  </body>
</html>

