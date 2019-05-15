<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" %>
<html>
<head>
	<title>登录</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="../css/layout.css" type="text/css" />
</head>
<body>
	<%!String uname; %>
	<%
		Cookie[] cookies=request.getCookies();
		for(Cookie cookie:cookies)
		{
			if("uname".equals(cookie.getName()))
				uname=cookie.getValue();
			//out.print(cookie.getName()+"---"+cookie.getValue()+"<br>");
		}
	%>
	
	<% session.removeAttribute("UserNameSession");%>
	<script type="text/javascript">
		function refresh(){
			loginForm.imgValidate.src = "validateCode.jsp?id=" + Math.random();
		}
		function reClear(){
			loginForm.uname.value="";
		}
	</script>
	<header>
		<a href="register.jsp" align="right"><h2>注册</h2></a>
	</header>
	<form name="loginForm" action="servlets/LoginServlet" method="post">
 		<table border="0">
	 		<tr><td width="200px" colspan="2"><h2 align="center">学生登录</h2></td>	</tr>
	 		<tr><td width="200px" >用户名：</td>	<td><input type="text" name="uname" value="<%=(uname==null?"":uname)%>"  onfocus="reClear()"></td></tr>
	 		<tr><td width="200px" >密码：</td>	<td><input type="text" name="upassword"></td></tr>
	 		<tr><td width="200px" >验证码:</td>	<td><input type="text" name="ucode"></td><tr>
	 		<tr><td width="200px" >     </td>	<td><img name="imgValidate" src="validateCode.jsp" onclick="refresh()"></td><tr>
	 		<tr><td width="200px" ></td><td align="right"><input type="reset" value="重置"  style="font-weight: 900"><input type="submit" value="提交"  style="font-weight: 900"></td></tr>
 		</table>
	</form>	
</body>
</html>