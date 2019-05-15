<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" %>
<html>
<head>
	<title>登录</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="css/user.css" type="text/css" />
 	<script type="text/javascript">
		function refresh(){
			loginForm.imgValidate.src = "validateCode.jsp?id=" + Math.random();
		}
	</script>
</head>
<body>
	<%
		session.removeAttribute("UserNameSession");
		session.removeAttribute("UserIdSession");
		session.removeAttribute("UserAddressSession");
		session.removeAttribute("UserScoreSession");
	%>
	<div class="user-body-bg"></div>
	<div class="user-login-bg"></div>
	<div class="user-bottom-bg"></div>
	<div class="login-box">
		<form name="loginForm" action="LoginServlet" method="post">
			<label class="form-inline" style="text-align:center">
					<font size="7" color="white" face="微软雅黑">登录</font>
			</label>
			<label class="form-inline">
				<div class="form-inline-font">
					用户名 :
				</div>
				<div class="form-inline-input">
					<input type="text" name="account" maxlength="8" />
				</div>
			</label>
			<label class="form-inline">
				<div class="form-inline-font">
					密码 :
				</div>
				<div class="form-inline-input">
					<input type="password" name="password" maxlength="16" />
				</div>
			</label>
			<label class="form-inline form-inline1">
				<div class="form-inline-font">
					验证码:
				</div>
				<div class="form-inline-input">
					<input style="width:200px;vertical:top;position:relative;top:-15px;" type="text" name="code" maxlength="16"/>
					<img style="vertical:top;" name="imgValidate" src="validateCode.jsp" onclick="refresh()" style="height:40px;width:100px">
				</div>
			</label>
			<div class="login-btn login-btn1">
				<button type="reset">重置</button>
				<button type="submit">登录</button>
			</div>
		</form>
	</div>
</body>
</html>