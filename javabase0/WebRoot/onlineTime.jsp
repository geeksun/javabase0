<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<html>
  <head>
    <title>在线时间统计</title>
	<script type="text/javascript">
		/*
		 *	 在线时间统计的 script
		 *   window.setInterval ("OnlineStayTimes( );",1000)函数实现每隔1秒调用OnlineStayTimes( )函数。
		 *   得到用户在线的统计时间，并将其设置为状态栏的文本值。
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
			window.status ="停留时间"+hour+"小时"+minute+"分钟"+second+"秒";
		}
	</script>
  </head>
  
  <body bgcolor ="#ffffcc">
      1.用户登录时记录下登录时间，如果用户点击“注销”，可以记录退出时间；如果是直接关闭浏览器，或者突然断电，如何记录？
      resolve proposal:
      a. 用 Ajax 实现，定时（隔相同的时间）向服务器发送一下数据；实现没问题，太耗资源！
      b. 关闭浏览器的时候回发一个请求，用javascript;
      c. session listener应该可以解决这个问题
		public final class YourSessionListener implements HttpSessionListener{
		   public void sessionCreated(HttpSessionEvent event) {
		           //计时开始
		    }
		    public void sessionDestroyed(HttpSessionEvent event) {
		           //计时结束
		    }
		}
		
		然后在web.xml定义一下
	  d. 用COOKIE存了用户的一些登陆信息，登陆时间，登陆ip，同时更新进数据库。
	      现在要做用户在线时间统计和登陆次数叠加。
	      用js的onunload 可以获得用户关闭浏览器事件,这样可以在用户关闭浏览器时更新进数据库： 
		 http://www.w3school.com.cn/htmldom/event_onunload.asp
		 在页面关闭时会显示一个对话框：
		<!-- <body onunload="alert('The onunload event was triggered')">
		</body>  -->
	    支持该事件的 HTML 标签：
		body, frameset
		支持该事件的 JavaScript 对象：
		window
	  e. 需要记录 ip,logintime,layouttime.
	  f. 设置coke session的时限！
	  g. 
<listener>
<listener-class>com.yourcompany.YourSessionListener</listener-class>
</listener>
      
  </body>
</html>
