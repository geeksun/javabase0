<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'Math object.jsp' starting page</title>
	<script type="text/javascript">
		//  ��ѧ����,���� y λС������������
		function round2(x,y)					  //  ������������,һ��ΪҪ���������,һ��ΪҪ������λС��
		{
			var p = Math.pow(10,y);				  //  �� 10 �� y �η�
			alert(p);
			x *= p;
			x = Math.round(x);
			alert(x/p);
			return x/p;
		}
		//  ������� Math.random() ����0��1֮���С��
		function random2()
		{
			var m = Math.random();
			alert(m);
			var n = Math.round(m*200);
			alert("0��200֮��������: "+n);
			var z = Math.round(m*100)+100;
			alert("100��200֮��������: "+z);
		}
		//  ʹ������������и��ʼ���,ģ��һ��ľ������۳�����,���һ�������εĸ����Ƕ���
		function probability()
		{
			var totalCount = 10000;
			var okCount = 0;
			for(var i=0;i<totalCount;i++)
			{
				var p1 = Math.random();							//  �õ���һ���ϵ�
				var p2 = Math.random();							//  �ڶ����ϵ�
				var s1 = Math.min(p1,p2);						//  �õ���һ�γ���
				var s2 = Math.max(p1,p2)-s1;					//  �õ��ڶ��γ���
				var s3 = 1-s1-s2;								//  �����γ���
				if(s1>=0.5||s2>=0.5||s3>=0.5) continue;			//  ����һ�߳�����0.5���������������
				okCount++;
			}
			alert(okCount/totalCount);
		}
	</script>
  </head>
  
  <body>
  	<input type="button" onClick="round2(1834.832620,3)" value="����С��λ�����������ѧ����" >
  	<input type="button" onClick="random2()" value="���������" >
  	<input type="button" onClick="probability();" value="ľ��������������β���" >
  	
  </body>
</html>
