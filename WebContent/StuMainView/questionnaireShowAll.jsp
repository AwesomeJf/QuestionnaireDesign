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
	<form name="classManageForm" method="post">
 		<table border="1px">
 		<tr>
 			<th class="questionnaireStudentTable">编号</th>
 			<th class="questionnaireStudentTable">创建人</th>
 			<th class="questionnaireStudentTable">分数</th>
 			<th class="questionnaireStudentTable">标题</th>
 			<th class="questionnaireStudentTable">描述</th>
 			<th class="questionnaireStudentTable">类型</th>
 			<th class="questionnaireStudentTable">创建时间</th>
 			<th class="questionnaireStudentTable">结果</th>
 			<th class="questionnaireStudentTable">作答</th>
 		</tr>
	 		<%
	 			List<Questionnaire> ques=(List<Questionnaire>)request.getAttribute("ques");
	 			for(Questionnaire que:ques)
	 			{
	 		%>
	 			<tr>
	 				<td class="questionnaireStudentTable"><%=que.getId()%></td>
					<td class="questionnaireStudentTable"><%=que.getSponsorId()%></td>
					<td class="questionnaireStudentTable"><%=que.getScore()%></td>
					<td class="questionnaireStudentTable"><%=que.getQuestionnaireTitle()%></td>
					<td class="questionnaireStudentTable"><%=que.getQuestionnaireDescription()%></td>
					<td class="questionnaireStudentTable"><%=que.getQuestionnaireType()%></td>
					<td class="questionnaireStudentTable"><%=que.getSubmitTime()%></td>
					<td class="questionnaireStudentTable"><a href="AnswerResultServlet?ownerQuestionnaireId=<%=que.getId()%>&ownerQuestionnaireTitle=<%=que.getQuestionnaireTitle()%>&ownerQuestionnaireScore=<%=que.getScore()%>">结果</a></td>
	 				<td class="questionnaireStudentTable"><a href="QuestionAnswerServlet?ownerQuestionnaireId=<%=que.getId()%>&ownerQuestionnaireTitle=<%=que.getQuestionnaireTitle()%>&ownerQuestionnaireScore=<%=que.getScore()%>">作答</a></td>
	 			</tr>
	 		<% }%>
 		</table>
	</form>	
</body>
</html>