<%@ page contentType="text/html;charset=GBK" %>
<%@ page language="java" import="com.geeksun.xml.*"%>
<%if(request.getParameter("act")!=null && request.getParameter("act").equals("add")){
XmlOperate.AddXML(request);
out.println("<p align='center'><br><br>��ӳɹ�<br><br><a href=''>����</a>");
}
else if(request.getParameter("act")!=null && request.getParameter("act").equals("del")){
XmlOperate.DelXML(request);
out.println("<p align='center'><br><br>ɾ���ɹ�<br><br><a href=''>����</a>");
}
else if(request.getParameter("act")!=null && request.getParameter("act").equals("edit")){
XmlOperate.EditXML(request);
out.println("<p align='center'><br><br>�޸ĳɹ�<br><br><a href=''>����</a>");
}
else{out.print("<p align='center'><br><br>�Ƿ�����<br><br><a href=''>����</a>");} 