<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>read cookie</title>
  </head>
  
  <body>
  <%
	Cookie cookies[]=request.getCookies(); // ������Ŀ¼������Cookie���벢����cookies������
	Cookie sCookie=null;
	String sname=null;
	String name=null;
	if(cookies==null)   // ���û���κ�cookie,�������ж� cookie �Ƿ�Ϊ��
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
