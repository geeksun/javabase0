<%@ page contentType="image/jpeg;charset=gbk" import="java.awt.*, java.awt.image.*,java.util.*,javax.imageio.*" %> 
<% 
// 在内存中创建图象 
int width=60, height=20; 
BufferedImage image = new BufferedImage(width, height, 
BufferedImage.TYPE_INT_RGB); 

// 获取图形上下文 
Graphics g = image.getGraphics(); 

// 设定背景色 
g.setColor(new Color(0xDCDCDC)); 
g.fillRect(0, 0, width, height); 

//画边框 
g.setColor(Color.black); 
g.drawRect(0,0,width-1,height-1); 

// 取随机产生的认证码(4位数字) 
String rand = request.getParameter("rand"); 
rand = rand.substring(0,rand.indexOf(".")); 
switch(rand.length()) 
{ 
case 1: rand = "000"+rand; break; 
case 2: rand = "00"+rand; break; 
case 3: rand = "0"+rand; break; 
default: rand = rand.substring(0,4); break; 
} 

// 将认证码存入SESSION 
session.setAttribute("rand",rand); 

// 将认证码显示到图象中 
g.setColor(Color.black); 
Integer tempNumber = new Integer(rand); 
String numberStr = tempNumber.toString(); 

g.setFont(new Font("Atlantic Inline",Font.PLAIN,18)); 
String Str = numberStr.substring(0,1); 
g.drawString(Str,8,17); 

Str = numberStr.substring(1,2); 
g.drawString(Str,20,15); 
Str = numberStr.substring(2,3); 
g.drawString(Str,35,18); 

Str = numberStr.substring(3,4); 
g.drawString(Str,45,15); 

// 随机产生88个干扰点，使图象中的认证码不易被其它程序探测到 
Random random = new Random(); 
for (int i=0;i<20;i++) 
{ 
int x = random.nextInt(width); 
int y = random.nextInt(height); 
g.drawOval(x,y,0,0); 
} 

// 图象生效 
g.dispose(); 

// 输出图象到页面 
ImageIO.write(image, "JPEG", response.getOutputStream()); 
%>