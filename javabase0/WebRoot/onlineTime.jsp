<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<html>
  <head>
    <title>����ʱ��ͳ��</title>
	<script type="text/javascript">
		/*
		 *	 ����ʱ��ͳ�Ƶ� script
		 *   window.setInterval ("OnlineStayTimes( );",1000)����ʵ��ÿ��1�����OnlineStayTimes( )������
		 *   �õ��û����ߵ�ͳ��ʱ�䣬����������Ϊ״̬�����ı�ֵ��
		 */
		var second=0;
		var minute=0;
		var hour=0;
		window.setInterval ("OnlineStayTimes( );",1000);
		function OnlineStayTimes(){
			second++;
			if(second==60){
				second=0;
				minute+=1;
			}
			if(minute==60){
				minute=0;
				hour+=1;
			}
			window.status ="ͣ��ʱ��"+hour+"Сʱ"+minute+"����"+second+"��";
		}
	</script>
  </head>
  
  <body bgcolor ="#ffffcc">
      1.�û���¼ʱ��¼�µ�¼ʱ�䣬����û������ע���������Լ�¼�˳�ʱ�䣻�����ֱ�ӹر������������ͻȻ�ϵ磬��μ�¼��
      resolve proposal:
      a. �� Ajax ʵ�֣���ʱ������ͬ��ʱ�䣩�����������һ�����ݣ�ʵ��û���⣬̫����Դ��
      b. �ر��������ʱ��ط�һ��������javascript;
      c. session listenerӦ�ÿ��Խ���������
		public final class YourSessionListener implements HttpSessionListener{
		   public void sessionCreated(HttpSessionEvent event) {
		           //��ʱ��ʼ
		    }
		    public void sessionDestroyed(HttpSessionEvent event) {
		           //��ʱ����
		    }
		}
		
		Ȼ����web.xml����һ��
	  d. ��COOKIE�����û���һЩ��½��Ϣ����½ʱ�䣬��½ip��ͬʱ���½����ݿ⡣
	      ����Ҫ���û�����ʱ��ͳ�ƺ͵�½�������ӡ�
	      ��js��onunload ���Ի���û��ر�������¼�,�����������û��ر������ʱ���½����ݿ⣺ 
		 http://www.w3school.com.cn/htmldom/event_onunload.asp
		 ��ҳ��ر�ʱ����ʾһ���Ի���
		<!-- <body onunload="alert('The onunload event was triggered')">
		</body>  -->
	    ֧�ָ��¼��� HTML ��ǩ��
		body, frameset
		֧�ָ��¼��� JavaScript ����
		window
	  e. ��Ҫ��¼ ip,logintime,layouttime.
	  f. ����coke session��ʱ�ޣ�
	  g. 
<listener>
<listener-class>com.yourcompany.YourSessionListener</listener-class>
</listener>
      
  </body>
</html>
