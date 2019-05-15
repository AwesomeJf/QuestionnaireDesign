<%@page import="java.util.List"%>
<%@page import="com.questionnaire.bean.Student"%>
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
 			<th class="studentTable">编号</th>
 			<th class="studentTable">班级</th>
 			<th class="studentTable">手机号</th>
 			<th class="studentTable">积分</th>
 			<th class="studentTable">学号</th>
 			<th class="studentTable">帐号</th>
 			<th class="studentTable">密码</th>
 			<th class="studentTable">姓名</th>
 			<th class="studentTable">性别</th>
 			<th class="studentTable">地址</th>
 			<th class="studentTable">权限</th>
 			<th width="90px">注册时间</th>
 			<th class="studentTable">修改</th>
 			<th class="studentTable">删除</th>
 		</tr>
	 		<%
	 			List<Student> students=(List<Student>)request.getAttribute("students");
	 			for(Student student:students)
	 			{
	 		%>
	 			<tr>
	 				<td class="studentTable"><%=student.getId()%></td>
	 				<td class="studentTable"><%=student.getOwnerClassId()%></td>
	 				<td class="studentTable"><%=student.getPhoneNumber()%></td>
	 				<td class="studentTable"><%=student.getScore()%></td>
	 				<td class="studentTable"><%=student.getStudyNumber()%></td>
	 				<td class="studentTable"><%=student.getAccount()%></td>
	 				<td class="studentTable"><%=student.getPassword()%></td>
	 				<td class="studentTable"><%=student.getName()%></td>
	 				<td class="studentTable"><%=student.getSex()%></td>
	 				<td class="studentTable"><%=student.getAddress()%></td>
	 				<td class="studentTable"><%="admin".equals(student.getIsAdmin())?"管理员":"非管理员"%></td>
	 				<td class="studentTable"><%=student.getRegisterTime()%></td>
	 				<td class="studentTable"><a href="UpdateStudentByIdServlet?id=<%=student.getId()%>">修改</a></td>
	 				<td class="studentTable"><a href="DeleteStudentByIdServlet?id=<%=student.getId()%>">删除</a></td>
	 			</tr>
	 		<% }%>
	 		<tr style="border:0px"><td><a href="InsertEmptyStudentServlet">新增</a></td></tr>
 		</table>
	</form>	
</body>
</html>