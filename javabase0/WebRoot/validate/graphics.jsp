<%@ page contentType="image/jpeg;charset=gbk" import="java.awt.*, java.awt.image.*,java.util.*,javax.imageio.*" %> 
<% 
// ���ڴ��д���ͼ�� 
int width=60, height=20; 
BufferedImage image = new BufferedImage(width, height, 
BufferedImage.TYPE_INT_RGB); 

// ��ȡͼ�������� 
Graphics g = image.getGraphics(); 

// �趨����ɫ 
g.setColor(new Color(0xDCDCDC)); 
g.fillRect(0, 0, width, height); 

//���߿� 
g.setColor(Color.black); 
g.drawRect(0,0,width-1,height-1); 

// ȡ�����������֤��(4λ����) 
String rand = request.getParameter("rand"); 
rand = rand.substring(0,rand.indexOf(".")); 
switch(rand.length()) 
{ 
case 1: rand = "000"+rand; break; 
case 2: rand = "00"+rand; break; 
case 3: rand = "0"+rand; break; 
default: rand = rand.substring(0,4); break; 
} 

// ����֤�����SESSION 
session.setAttribute("rand",rand); 

// ����֤����ʾ��ͼ���� 
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

// �������88�����ŵ㣬ʹͼ���е���֤�벻�ױ���������̽�⵽ 
Random random = new Random(); 
for (int i=0;i<20;i++) 
{ 
int x = random.nextInt(width); 
int y = random.nextInt(height); 
g.drawOval(x,y,0,0); 
} 

// ͼ����Ч 
g.dispose(); 

// ���ͼ��ҳ�� 
ImageIO.write(image, "JPEG", response.getOutputStream()); 
%>