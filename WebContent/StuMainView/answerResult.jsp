<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List"%>
<%@page import="com.questionnaire.bean.Answer"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="css/layout.css" type="text/css" />
	<title>查看结果</title>
</head>
<body>
		<% 
			List<Answer> answers=(List<Answer>)request.getAttribute("answers");
			int i=1;
		%>
		<table border="1px" style="width:1100px;">
			<tr style="height:40px">
	 			<th class="answerResultTable">问题</th>
	 			<th class="answerResultTable">结果</th>
	 		</tr>
	 	<%
	 		for(Answer ans:answers)
	 		{
	 	%>
	 		<tr style="height:40px">
 				<td class="answerResultTable">
		 			问题<%=i%>:<%=ans.getOwnerQuestionHeading()%>
		 		</td>
		 		<td class="questionTable">
		 			<%=ans.getOption()%>:<%=ans.getAnswer()%>
		 		</td>
			</tr>
		<%
			i++;}
		%>	
 		</table>
</body>
</html>