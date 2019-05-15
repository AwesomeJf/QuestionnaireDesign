<%@page import="java.util.List"%>
<%@page import="com.questionnaire.bean.Gift"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" %>
<html>
<head>
	<title>登录</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="css/layout.css" type="text/css" />
</head>
<body>
	<form name="giftManageForm" action="giftManageServlet" method="post">
 		<table border="1px">
 		<tr>
 			<th class="giftTable">编号</th>
 			<th class="giftTable">积分</th>
 			<th class="giftTable">礼品名称</th>
 			<th class="giftTable">礼品描述</th>
 			<th class="giftTable">图片</th>
 			<th class="giftTable">编辑</th>
 			<th class="giftTable">删除</th>
 		</tr>
	 		<%
	 			List<Gift> gifs=(List<Gift>)request.getAttribute("gifs");
	 			for(Gift gif:gifs)
	 			{
	 		%>
	 			<tr>
	 				<td class="giftTable"><%=gif.getId()%></td>
					<td class="giftTable"><%=gif.getScore()%></td>
					<td class="giftTable"><%=gif.getGiftName()%></td>
					<td class="giftTable"><%=gif.getGiftDescription()%></td>
					<td class="giftTable"><img src="picture/<%=gif.getGiftSrc()%>"  alt="<%=gif.getGiftSrc()=="404.jpg"?"无图片":gif.getGiftSrc()%>" /></td>
	 				<td class="giftTable"><a href="UpdateGiftByIdServlet?id=<%=gif.getId()%>&giftName=<%=gif.getGiftName()%>">编辑</a></td>
	 				<td class="giftTable"><a href="DeleteGiftByIdServlet?id=<%=gif.getId()%>">删除</a></td>
	 			</tr>
	 		<% }%>
	 		<tr><td><a href="InsertEmptyGiftServlet">新增</a></td></tr>
 		</table>
	</form>	
</body>
</html>