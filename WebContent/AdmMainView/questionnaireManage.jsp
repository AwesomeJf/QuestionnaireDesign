<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.questionnaire.bean.Questionnaire"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="css/layout.css" type="text/css" />
	<title>问卷管理</title>
</head>
<body>
	<form name="classManageForm" action="ClassManageServlet" method="post">
 		<table border="1px">
 		<tr>
 			<th class="questionnaireTable">编号</th>
 			<th class="questionnaireTable">创建人</th>
 			<th class="questionnaireTable">分数</th>
 			<th class="questionnaireTable">标题</th>
 			<th class="questionnaireTable">描述</th>
 			<th class="questionnaireTable">类型</th>
 			<th class="questionnaireTable">创建时间</th>
 			<th class="questionnaireTable">状态</th>
 			<th class="questionnaireTable">编辑题目</th>
 			<th class="questionnaireTable">统计结果</th>
 			<th class="questionnaireTable">删除</th>
 		</tr>
	 		<%
	 			List<Questionnaire> ques=(List<Questionnaire>)request.getAttribute("ques");
	 			for(Questionnaire que:ques)
	 			{
	 		%>
	 			<tr>
	 				<td class="questionnaireTable"><%=que.getId()%></td>
					<td class="questionnaireTable"><%=que.getSponsorId()%></td>
					<td class="questionnaireTable"><%=que.getScore()%></td>
					<td class="questionnaireTable"><%=que.getQuestionnaireTitle()%></td>
					<td class="questionnaireTable"><%=que.getQuestionnaireDescription()%></td>
					<td class="questionnaireTable"><%=que.getQuestionnaireType()%></td>
					<td class="questionnaireTable"><%=que.getSubmitTime()%></td>
					<td class="questionnaireTable"><a href="ModifyQuestionnaireStatusByIdServlet?id=<%=que.getId()%>&status=<%=que.getStatus()%>"><%=que.getStatus()%></a></td>
	 				<td class="questionnaireTable"><a href="QuestionManageServlet?ownerQuestionnaireId=<%=que.getId()%>&ownerQuestionnaireTitle=<%=que.getQuestionnaireTitle()%>">编辑题目</a></td>
	 				<td class="questionnaireTable"><a href="AnalyzeQuestionnaireByIdServlet?ownerQuestionnaireId=<%=que.getId()%>">统计结果</a></td>
	 				<td class="questionnaireTable"><a href="DeleteQuestionnaireByIdServlet?id=<%=que.getId()%>">删除</a></td>
	 			</tr>
	 		<% }%>
 		</table>
	</form>	
</body>
</html>