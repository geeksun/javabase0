<%@ page  contentType="text/html;charset=gb2312" language="java" errorPage="" %>   						
<%   																				
	  String username = request.getParameter("username");   						
	  if("cc".equals(username))   											
	  	  out.print("�û����Ѿ���ע�ᣬ�����һ���û�����");   						
	  else   
	      out.print("�û�����δ��ʹ�ã������Լ�����");   
%>															