<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>

<html>
  <head>
   
    <title>Date �����ʹ��</title>
 
  <script type="text/javascript">
  
      var objDate = new Date();        //  ����һ�����ڵ��¶���
      var year = objDate.getFullYear();
      var month = objDate.getMonth()+1;    // 0-11
      var date = objDate.getDate();
      var day = objDate.getDay();       //   �������ڼ� : 0-6
      var hour = objDate.getHours();
	  var minute = objDate.getMinutes();
	  var second = objDate.getSeconds();
      //  ����������������ȷ�������ı�ʾ
      switch(day){
          case 0 : day="������";  break;
      
          case 1:  day="����һ"; break;
      
          case 2 : day="���ڶ�" ; break;
    
          case 3 : day="������" ;break;
    
          case 4 : day="������" ; break;
     
          case 5 : day="������" ; break;
      
          case 6 : day="������" ; break;
      }
      document.write("������:"+year+"��"+month+"��"+date+"��;"+day);
      
 
   </script>
  </head>
  
  <body>
    <%--<input type="button" id="day" value="�����ܼ��õ���������">
  --%>
  </body>
</html>

   