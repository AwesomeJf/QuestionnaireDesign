<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<style type="text/css">
		h3 {display: inline}
		a {
			text-decoration:none
		}
		.orderList a{
			width:100%;
			padding:0 30px;
			text-align:center;
		}
		.characterSize{
		font-size:20px;
		}
		body{
		background:-webkit-gradient(linear, 40% 0%, 0% 100%,from(#2dabd4), to(#f9e359));/*谷歌*/ 
		}
	</style>
	<script>
		var msg ='<%=session.getAttribute("msg")%>';
		if(msg!='null')
		{
			alert(msg);
			<%session.removeAttribute("msg");%>;
			msg=null;
		}
	</script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>学生主页面</title>
</head>
<body style="margin:0" class="linear">
	<table style="width:100%; height:100%"border=0 cellpadding="0" cellspacing="0" >
		<tr><td  colspan="3" style="height:10%;"><h1 align="center">欢迎使用校园问卷调查系统</h1><h3 align="right">&nbsp&nbsp欢迎${sessionScope.UserNameSession}&nbsp&nbsp积分：${sessionScope.UserScoreSession}&nbsp&nbsp<a href="../login.jsp">注销</a></h3></td></tr>

		<tr>
			<td style="width: 10%" class="orderList">
				<a href="../QuestionnaireShowAllServlet" target="myframe" target="_blank"><div class="characterSize">问卷中心</div></a>
				
				<a href="../GiftExchangeServlet" target="myframe"><div class="characterSize">礼品中心</div></a>
				
				<a href="../UpdateInfoServlet?id=${sessionScope.UserIdSession}" target="myframe"><div class="characterSize">信息管理</div></a>
			</td>
			<td style="width: 90%">
				<iframe src="../QuestionnaireShowAllServlet"  width="100%" height="100%" name="myframe"></iframe>
			</td>
		</tr>

	 	<tr style="background:white ">
				<td colspan="3" style="height:5%"><div style="text-align:center">Copyright © 1977-2019 PDSU. All Rights Reserved.</div></td>
			</tr>
	</table>
</body>
</html>