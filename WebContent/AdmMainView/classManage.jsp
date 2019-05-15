<%@page import="java.util.List"%>
<%@page import="com.questionnaire.bean.RegClass"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="css/layout.css" type="text/css" />
<title>班级管理</title>
</head>
<body>
	<form name="classManageForm" action="ClassManageServlet" method="post">
 		<table>
 		<tr>
 			<th class="classTable">编号</th>
 			<th class="classTable">班级名称</th>
 			<th class="classTable">班级描述</th>
 			<th class="classTable">修改</th>
 			<th class="classTable">删除</th>
 		</tr>
	 		<%
	 			List<RegClass> rClasses=(List<RegClass>)request.getAttribute("rClasses");
	 			for(RegClass rClass:rClasses)
	 			{
	 		%>
	 			<tr>
	 				<td class="classTable"><%=rClass.getId()%></td>
	 				<td class="classTable"><%=rClass.getClassName()%></td>
	 				<td class="classTable"><%=rClass.getDescription()%></td>
	 				<td class="classTable"><a href="UpdateClassByIdServlet?id=<%=rClass.getId()%>">修改</a></td>
	 				<td class="classTable"><a href="DeleteClassByIdServlet?id=<%=rClass.getId()%>">删除</a></td>
	 			</tr>
	 		<% }%>
	 		<tr style="border:0px"><td><a href="InsertEmptyClassServlet">新增</a></td></tr>
 		</table>
	</form>	
</body>
</html>