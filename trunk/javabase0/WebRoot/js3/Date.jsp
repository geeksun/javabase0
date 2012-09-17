<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>

<html>
  <head>
   
    <title>Date 对象的使用</title>
 
  <script type="text/javascript">
  
      var objDate = new Date();        //  创建一个日期的新对象
      var year = objDate.getFullYear();
      var month = objDate.getMonth()+1;    // 0-11
      var date = objDate.getDate();
      var day = objDate.getDay();       //   返回星期几 : 0-6
      var hour = objDate.getHours();
	  var minute = objDate.getMinutes();
	  var second = objDate.getSeconds();
      //  根据星期数的索引确定其中文表示
      switch(day){
          case 0 : day="星期日";  break;
      
          case 1:  day="星期一"; break;
      
          case 2 : day="星期二" ; break;
    
          case 3 : day="星期三" ;break;
    
          case 4 : day="星期四" ; break;
     
          case 5 : day="星期五" ; break;
      
          case 6 : day="星期六" ; break;
      }
      document.write("今天是:"+year+"年"+month+"月"+date+"日;"+day);
      
 
   </script>
  </head>
  
  <body>
    <%--<input type="button" id="day" value="依据周几得到具体日期">
  --%>
  </body>
</html>

   