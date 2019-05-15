<%@page import="java.util.List"%>
<%@page import="com.questionnaire.bean.Gift"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="css/layout.css" type="text/css" />
	<title>礼品兑换</title>
</head>
<body>
	<form name="giftExchangeForm" action="InsertOrderServlet" method="post">
 		<table border="1px">
 		<input type="hidden" value="<%=session.getAttribute("UserAddressSession")%>" name="address"></input>
 		<input type="hidden" value="<%=session.getAttribute("UserIdSession")%>" name="studentId"></input>
 		<tr>
 			<th class="giftTable">选项</th>
 			<th class="giftTable">编号</th>
 			<th class="giftTable">积分</th>
 			<th class="giftTable">礼品名称</th>
 			<th class="giftTable">礼品描述</th>
 			<th class="giftTable">图片</th>
 		</tr>
	 		<%
	 			List<Gift> gifs=(List<Gift>)request.getAttribute("gifs");
	 			for(Gift gif:gifs)
	 			{
	 		%>
	 			<tr>
	 				<td class="giftTable"><input type="radio" name="checkedGift" value="<%=gif.getId()%>,<%=gif.getScore()%>,<%=gif.getGiftName()%>" ></td>	
	 				<td class="giftTable"><%=gif.getId()%></td>
					<td class="giftTable"><%=gif.getScore()%></td>
					<td class="giftTable"><%=gif.getGiftName()%></td>
					<td class="giftTable"><%=gif.getGiftDescription()%></td>
					<td class="giftTable"><img src="picture/<%=gif.getGiftSrc()%>"  alt="<%=gif.getGiftSrc()%>" /></td>
	 			</tr>
	 		<% }%>
	 		<tr><td align="center"  colspan="6"><a href="OrderHistoryServlet?studentId=<%=session.getAttribute("UserIdSession")%>">历史兑换记录</a><input type="reset" value="重置"  style="font-weight: 900"><input type="submit" value="提交"  style="font-weight: 900"></td></tr>
 		</table>
	</form>	
</body>
</html>