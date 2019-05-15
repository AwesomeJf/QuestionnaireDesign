<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>失败</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="css/layout.css" type="text/css" />
</head>
<body>
	<%String info=request.getParameter("info");
	//System.out.println(info);
	//System.out.println(info.equals("accountRegistered"));
	session.setAttribute("info", info);
	%>
	<c:choose>
	<c:when test="${info=='accountRegistered'}"><h1>失败，该帐号已注册！</h1></c:when>
	<c:when test="${info=='nameOrPasswordWrong'}"><h1>用户名或密码错误！</h1></c:when>
	<c:when test="${info=='codeError'}"><h1>验证码错误！</h1></c:when>
	<c:when test="${info=='oldPasswordWrong'}"><h1>旧密码错误！</h1></c:when>
	<c:when test="${info=='dontKnow'}"><h1>未知错误！</h1></c:when>
	<c:when test="${info=='notChoose'}"><h1>失败，请选择项目！</h1></c:when>
	<c:when test="${info=='noAuthority'}"><h1>您没有权限访问此页面！</h1></c:when>
	<c:when test="${info=='scoreNotEnough'}"><h1>积分不足</h1></c:when>
	<c:otherwise><h1>失败</h1></c:otherwise>
	</c:choose>
</body>
</html>