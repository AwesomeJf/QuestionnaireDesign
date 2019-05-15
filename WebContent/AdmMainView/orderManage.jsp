<%@page import="java.util.List"%>
<%@page import="com.questionnaire.bean.Order"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="css/layout.css" type="text/css" />
<title>Insert title here</title>
</head>
<body>
	<form name="classManageForm" action="ClassManageServlet" method="post">
 		<table border="1px">
 		<tr>
 			<th class="orderHistoryTable">编号</th>
 			<th class="orderHistoryTable">兑换学生编号</th>
 			<th class="orderHistoryTable">礼品编号</th>
 			<th class="orderHistoryTable">礼品名称</th>
 			<th class="orderHistoryTable">地址</th>
 			<th class="orderHistoryTable">状态</th>
 			<th class="orderHistoryTable">申请时间</th>
 		</tr>
	 		<%
	 			List<Order> ords=(List<Order>)request.getAttribute("ords");
	 			for(Order ord:ords)
	 			{
	 		%>
	 			<tr>
	 				<td class="orderHistoryTable"><%=ord.getId()%></td>
					<td class="orderHistoryTable"><%=ord.getStudentId()%></td>
					<td class="orderHistoryTable"><%=ord.getGiftId()%></td>
					<td class="orderHistoryTable"><%=ord.getGiftName()%></td>
					<td class="orderHistoryTable"><%=ord.getAddress()%></td>
					<td class="orderHistoryTable"><a href="ModifyOrderStatusByIdServlet?id=<%=ord.getId()%>&status=<%=ord.getStatus()%>"><%=ord.getStatus()%></a></td>
					<td class="orderHistoryTable"><%=ord.getSubmitTime()%></td>
	 			</tr>
	 		<% }%>
 		</table>
	</form>	
</body>
</html>