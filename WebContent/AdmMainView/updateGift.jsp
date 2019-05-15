<%@page import="java.util.List"%>
<%@page import="com.questionnaire.bean.Gift"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="css/layout.css" type="text/css" />
<title>礼品编辑</title>
</head>
<body>
	<%
	Gift gift=(Gift)request.getAttribute("gift");
	%>
	<form action="UpdateGiftByIdSubmitServlet" method="post" enctype="multipart/form-data">
	<table>
 		<tr>
			<td>编号：</td><td><input type="text" name="id" value="<%=gift.getId()==null?"":gift.getId() %>"/></td>
		</tr>
		<tr>
			<td>积分：</td><td><input type="text" name="score" value="<%=gift.getScore()==null?"":gift.getScore()%>"/></td>
		</tr>
		<tr>
			<td>礼品名称：</td><td><input type="text" name="giftName" value="<%=gift.getGiftName()==null?"":gift.getGiftName()%>"/></td>
		</tr>
		<tr>
			<td>礼品描述：</td><td><input type="text" name="giftDescription" value="<%=gift.getGiftDescription()==null?"":gift.getGiftDescription()%>"/></td>
		</tr>
		<tr>
			<td>图片：</td><td><input type="file" name="giftSrc" />
			</td>
		</tr>
		<tr><td><input type="submit" value="提交" ></td></tr>
	</table>
	</form>
</body>
</html>