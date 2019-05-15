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
		background:-webkit-gradient(linear, 40% 0%, 0% 100%,from(#2dabd4), to(#f9e359)); /*谷歌*/ 
		}
	</style>
	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>管理员主页面</title>
</head>
<body style="margin:0">
	<table style="width:100%; height:100%"border=0 cellpadding="0" cellspacing="0" >
		<tr class="title"><td  colspan="3" style="height:10%;"><h1 align="center">欢迎使用校园问卷调查系统</h1><h3 align="right">&nbsp&nbsp欢迎${sessionScope.UserNameSession}&nbsp&nbsp积分：${sessionScope.UserScoreSession}&nbsp&nbsp<a href="../login.jsp">注销</a></h3></td></tr>

		<tr>
			<td style="width: 10%" class="orderList">
				<a href="../StudentManageServlet" target="myframe"><div class="characterSize">学生管理</div></a>
				
				<a href="../ClassManageServlet" target="myframe"><div class="characterSize">班级管理</div></a>
				
				<a href="addNewQuestionnaire.jsp" target="myframe"><div class="characterSize">新增问卷</div></a>
				
				<a href="../QuestionnaireManageServlet" target="myframe"><div class="characterSize">历史问卷</div></a>
				
				<a href="../GiftManageServlet" target="myframe"><div class="characterSize">礼品管理</div></a>
			
				<a href="../OrderManageServlet" target="myframe"><div class="characterSize">兑换审核</div></a>
				
				<a href="../AnnounceManageServlet" target="myframe"><div class="characterSize">公告管理</div></a>
			</td>
			<td style="width: 90%">
				<iframe src="../StudentManageServlet"  width="100%" height="100%" name="myframe"></iframe>
			</td>
		</tr>

		<tr style="background:white">
				<td colspan="3" style="height:5%"><div style="text-align:center">Copyright © 1977-2019 PDSU. All Rights Reserved.</div></td>
			</tr>
	</table>

</body>
</html>