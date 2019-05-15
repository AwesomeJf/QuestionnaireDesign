<%@page import="java.util.List"%>
<%@page import="com.questionnaire.bean.Announce"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="css/layout.css" type="text/css" />
<title>公告管理</title>
</head>
<body>
	<form name="announceManageForm" action="announceManageServlet" method="post">
 		<table border="1px">
 		<tr>
 			<th class="announceTable">编号</th>
 			<th class="announceTable">创建人</th>
 			<th class="announceTable">内容</th>
 			<th class="announceTable">提交时间</th>
 			<th class="announceTable">删除</th>
 		</tr>
	 		<%
	 			List<Announce> anns=(List<Announce>)request.getAttribute("anns");
	 			for(Announce ann:anns)
	 			{
	 		%>
	 			<tr>
	 				<td class="announceTable"><%=ann.getId()%></td>
					<td class="announceTable"><%=ann.getSponsorId()%></td>
					<td class="announceTable"><%=ann.getContent()%></td>
					<td class="announceTable"><%=ann.getSubmitTime()%></td>
	
	 				<td class="announceTable"><a href="DeleteAnnounceByIdServlet?id=<%=ann.getId()%>">删除</a></td>
	 			</tr>
	 		<% }%>
 		</table>
	</form>
	<form name="insertAnnounceForm" action="InsertAnnounceServlet" method="post" >
 		<table border="1px" style="width:1018px">
	 		<tr>
				<td style="height:80px;width:33%" class="announceTable" >待分配</td>
				
				<td style="height:80px;width:33%" class="announceTable" ><textarea name="content" style="height:100%;width:100%;font-size:15px"></textarea></td>
				
				<td style="height:80px;width:33%" class="announceTable" colspan="3"><input type="reset" value="重置"  style="font-weight: 900"><input type="submit" value="提交"  style="font-weight: 900"></td>
				
			</tr>
 		</table>
	</form>
</body>
</html>