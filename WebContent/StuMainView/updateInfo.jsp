<%@page import="com.questionnaire.bean.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改信息</title>
<link rel="stylesheet" href="css/layout.css" type="text/css" />
</head>
<body>
	<%
	Student student=(Student)request.getAttribute("student");
	%>
	<form action="UpdateInfoSubmitServlet" method="post">
	<table style="height:400px" class="div">
 		<tr>
			<td>编号：</td><td><input type="number" name="id" readonly="readonly" min="1" value="<%=(student.getId()==null)?"":student.getId()%>"/></td>
		</tr>
		<tr>
			<td>班级：</td><td><input type="text" name="ownerClassId"value="<%=student.getOwnerClassId()==null?"":student.getOwnerClassId()%>"/></td>
		</tr>
		<tr>
			<td><font size="4" color="red">手机号：</font></td><td><input type="number" name="phoneNumber" value="<%=student.getPhoneNumber()==null?"":student.getPhoneNumber()%>"/></td>
		</tr>
		<tr>
			<td>积分：</td><td><input type="number" name="score" readonly="readonly" value="<%=student.getScore()==null?"":student.getScore()%>"/></td>
		</tr>
		<tr>
			<td>学号：</td><td><input type="number" name="studyNumber" readonly="readonly" value="<%=student.getStudyNumber()==null?"":student.getStudyNumber()%>"/></td>
		</tr>
		<tr>
			<td>帐号：</td><td><input type="text" name="account" readonly="readonly" value="<%=student.getAccount()==null?"":student.getAccount()%>"/></td>
		</tr>
		<tr>
			<td><font size="4" color="red">密码：</font></td><td><input type="text" name="password" value="<%=student.getPassword()==null?"":student.getPassword()%>"/></td>
		</tr>
		<tr>
			<td>姓名：</td><td><input type="text" name="name" readonly="readonly" value="<%=student.getName()==null?"":student.getName()%>"/></td>
		</tr>
		<tr>
			<td><font size="4" color="red">性别：</font></td><td><input type="text" name="sex" value="<%=student.getSex()==null?"":student.getSex()%>"/></td>
		</tr>
		<tr>
			<td><font size="4" color="red">地址：</font></td><td><input type="text" name="address" value="<%=student.getAddress()==null?"":student.getAddress()%>"/></td>
		</tr>
		<tr>
			<td><font size="4" color="red">权限：</font></td><td>
				<select name="isAdmin" style="width:100%" readonly="readonly">
					<option value="<%="admin".equals(student.getIsAdmin())?"admin":"notAdmin"%>"><%="admin".equals(student.getIsAdmin())?"管理员":"非管理员"%></option>
					<option value="<%="admin".equals(student.getIsAdmin())?"notAdmin":"admin"%>"><%="admin".equals(student.getIsAdmin())?"非管理员":"管理员"%></option>
				</select>
			</td>
		</tr>
		<tr>
			<td>注册时间：</td><td><input type="text" name="registerTime" readonly="readonly" value="<%=student.getRegisterTime()==null?"":student.getRegisterTime()%>"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="提交" ></td>
		</tr>
	</table>
	</form>

</body>
</html>