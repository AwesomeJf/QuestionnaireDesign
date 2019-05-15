<%@page import="com.questionnaire.bean.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="css/layout.css" type="text/css" />

<title>修改学生</title>
</head>
<body>
	<%
	Student student=(Student)request.getAttribute("student");
	%>
	<form action="UpdateStudentByIdSubmitServlet" method="post">
	<table style="height:400px" class="div">
 		<tr>
			<td>编号：</td><td><input type="number" name="id" min="1" value="<%=(student.getId()==null)?"":student.getId()%>"/></td>
		</tr>
		<tr>
			<td>班级：</td><td><input type="text" name="ownerClassId" value="<%=student.getOwnerClassId()==null?"":student.getOwnerClassId()%>"/></td>
		</tr>
		<tr>
			<td>手机号：</td><td><input type="number" name="phoneNumber" value="<%=student.getPhoneNumber()==null?"":student.getPhoneNumber()%>"/></td>
		</tr>
		<tr>
			<td>积分：</td><td><input type="number" name="score" value="<%=student.getScore()==null?"":student.getScore()%>"/></td>
		</tr>
		<tr>
			<td>学号：</td><td><input type="number" name="studyNumber" value="<%=student.getStudyNumber()==null?"":student.getStudyNumber()%>"/></td>
		</tr>
		<tr>
			<td>帐号：</td><td><input type="text" name="account" value="<%=student.getAccount()==null?"":student.getAccount()%>"/></td>
		</tr>
		<tr>
			<td>密码：</td><td><input type="text" name="password" value="<%=student.getPassword()==null?"":student.getPassword()%>"/></td>
		</tr>
		<tr>
			<td>姓名：</td><td><input type="text" name="name" value="<%=student.getName()==null?"":student.getName()%>"/></td>
		</tr>
		<tr>
			<td>性别：</td><td><input type="text" name="sex" value="<%=student.getSex()==null?"":student.getSex()%>"/></td>
		</tr>
		<tr>
			<td>地址：</td><td><input type="text" name="address" value="<%=student.getAddress()==null?"":student.getAddress()%>"/></td>
		</tr>
		<tr>
			<td>权限：</td><td>
				<select name="isAdmin" style="width:100%">
					<option value="admin">管理员</option>
					<option value="notAdmin">非管理员</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>注册时间：</td><td><input type="text" name="registerTime" value="<%=student.getRegisterTime()==null?"":student.getRegisterTime()%>"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="提交" ></td>
		</tr>
	</table>
	</form>

</body>
</html>