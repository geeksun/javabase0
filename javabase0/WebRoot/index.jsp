<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  <body>
    <table>
    	<li>111</li>
    		<tt>
    		<td><strong>222</strong></td>
    		<td></td>
    	
    </table>
    [b]���ּӴ�[/b]
    <a href=mailto:geeksun@163.com>Email</a>
    
    <%
    	/*
    	String pp = request.getParameter("test");
    	*/
    
     %>
     <!-- pp -->
     <br>
      �ı��ֶα߿�����Ч�����������ָ�����
     <input name="SearchtxtKeyWordOne" id="SearchtxtKeyWordOne" type="text" class="smallInput1_blue" 
     onFocus="javascript:if(this.value=='С����ַ|����') {this.value=''}" 
     onBlur="javascript:if(this.value==''){this.value='С����ַ|����'}" value="С����ַ|����"   
     style="border:1px  dashed;">
     <br>
     <strong>����<span class="red">*</span>��</strong>
     <br>
     �������� div �� innerhtml ���Բ������ݣ�<br>
     <div class="note" id="password_condition">
				������5-20λӢ����ĸ��������ɣ����ִ�Сд,
				����ΪӢ����ĸ(a-z)������(0-9)��ϣ����ڼ��䣬���ױ��³���<br/><font color="red">ע�⣺�������û�����ͬ��</font>
	 </div>
  </body>
</html>
