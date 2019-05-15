<%@page import="com.questionnaire.bean.RegClass"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="css/layout.css" type="text/css" />
<title>修改班级</title>
</head>
<body>
	<%
	RegClass rClass=(RegClass)request.getAttribute("rClass");
	%>
	<form action="UpdateClassByIdSubmitServlet" method="post">
	<table>
 		<tr>
			<td>编号：</td><td><input type="text" name="id" value="<%=rClass.getId()==null?"":rClass.getId() %>"/></td>
		</tr>
		<tr>
			<td>班级名称：</td><td><input type="text" name="className" value="<%=rClass.getClassName()==null?"":rClass.getClassName()%>"/></td>
		</tr>
		<tr>
			<td>班级描述：</td><td><input type="text" name="description" value="<%=rClass.getDescription()==null?"":rClass.getDescription()%>"/></td>
		</tr>
		<tr><td><input type="submit" value="提交" ></td></tr>
	</table>
	</form>
</body>
</html>