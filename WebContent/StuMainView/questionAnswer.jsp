<%@page import="java.util.List"%>
<%@page import="com.questionnaire.bean.Question"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="css/layout.css" type="text/css" />
	<title>问卷作答</title>
</head>
<body>
<form name="questionManageForm" action="QuestionAnswerSubmitServlet" method="post">
		<% 
			List<Question> questions=(List<Question>)request.getAttribute("questions");
			session.setAttribute("questions",questions);
			int i=1;
		%>
		<h3 align="center"><%=request.getAttribute("ownerQuestionnaireTitle")%></h3>
 		<table border="1px" style="width:1100px;height:120px">
 		
 		<input type="hidden" value="<%=request.getAttribute("ownerQuestionnaireId")%>" name="ownerQuestionnaireId"></input>
		<input type="hidden" value="<%=request.getAttribute("ownerQuestionnaireTitle")%>" name="ownerQuestionnaireTitle"></input>
		<input type="hidden" value="<%=request.getAttribute("ownerQuestionnaireScore")%>" name="ownerQuestionnaireScore"></input>
		<%-- <input type="hidden" value="<%=questions%>" name="questions"></input> --%>
	 	<%
	 		
	 		for(Question question:questions)
	 		{
	 	%>
	 		<tr style="height:40px">
 				<td class="questionTable" colspan="4">
		 			问题<%=i%>:<%=question.getQuestionHeading()%>
		 			
		 		</td>
			</tr>
			<tr>
		 		<td class="questionTable"><input type="radio" name="<%=question.getId()%>" value="<%=question.getId()%>,A,<%=question.getOptionA()%>" >A:<%=question.getOptionA()%></td>
		 		<td class="questionTable"><input type="radio" name="<%=question.getId()%>" value="<%=question.getId()%>,B,<%=question.getOptionB()%>" >B:<%=question.getOptionB()%></td>
		 		<td class="questionTable"><input type="radio" name="<%=question.getId()%>" value="<%=question.getId()%>,C,<%=question.getOptionC()%>" >C:<%=question.getOptionC()%></td>
		 		<td class="questionTable"><input type="radio" name="<%=question.getId()%>" value="<%=question.getId()%>,D,<%=question.getOptionD()%>" >D:<%=question.getOptionD()%></td>
 			</tr>
		<%
			i++;}
		%>
			<tr><td align="center"  colspan="4"><input type="reset" value="重置"  style="font-weight: 900"><input type="submit" value="提交"  style="font-weight: 900"></td></tr>
 		</table>
	</form>	
</body>
</html>