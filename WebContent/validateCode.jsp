<%@ page language="java"
	import="java.awt.*"
	import="java.awt.image.BufferedImage"
	import="java.util.*"
	import="javax.imageio.ImageIO"	
	pageEncoding="utf-8"%>
<%
	response.setHeader("Cache-Control","no-cache"); 
	Random rnd = new Random();
	int width = 100, height = 40;
	BufferedImage image = new BufferedImage(width, height,
		BufferedImage.TYPE_INT_RGB);

	Graphics g = image.getGraphics();
	int randBGColor1 = rnd.nextInt(256);
	int randBGColor2 = rnd.nextInt(256);
	int randBGColor3 = rnd.nextInt(256);
	//g.setColor(new Color(randBGColor1, randBGColor2, randBGColor3));//这个背景看不清楚
	g.setColor(new Color(255,255,255));
	g.fillRect(0, 0, width, height);
	
	g.setColor(Color.black);
	g.setFont(new Font("", Font.PLAIN, 32));//字体大小
	int location=10;//初始X轴
	String sumNumber="";
	for(int i=1;i<=4;i++)
	{
		int randNumberColor1 = rnd.nextInt(256);
		int randNumberColor2 = rnd.nextInt(256);
		int randNumberColor3 = rnd.nextInt(256);
		g.setColor(new Color(randNumberColor1, randNumberColor2, randNumberColor3));
		int randNum = rnd.nextInt(10);
		String randStr = String.valueOf(randNum);
		sumNumber=sumNumber+randStr;
		g.drawString(randStr, location, 32);//第三位Y轴距离
		location=location+22;//水平间距
	}
	session.setAttribute("randStrSession", sumNumber);
	g.setColor(Color.black);
	for (int i = 0; i < 100; i++){
		int x = rnd.nextInt(width);
		int y = rnd.nextInt(height);
		g.drawOval(x, y, 1, 1);
	}

	ImageIO.write(image, "JPEG", response.getOutputStream());
	out.clear();
	out = pageContext.pushBody();
%>
