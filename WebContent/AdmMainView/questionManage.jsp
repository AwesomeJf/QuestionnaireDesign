<%@page import="java.util.List"%>
<%@page import="com.questionnaire.bean.Question"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="css/layout.css" type="text/css" />
<title>班级管理</title>
</head>
<body>
	<%int i=1;
	%>
	<form name="classManageForm" action="ClassManageServlet" method="post">
 		<table border="1px" style="width:1100px;height:120px">
 		<tr>
 			<th class="questionTable" style="width:8%">题号</th>
 			<th class="questionTable" style="width:8%">类型</th>
 			<th class="questionTable" style="width:34%">问题</th>
 			<th class="questionTable" style="width:34%">选项</th>
 			<th class="questionTable" style="width:8%">操作</th>
 			<th class="questionTable" style="width:8%">问题编号</th>
 		</tr>
	 	<%
	 		List<Question> questions=(List<Question>)request.getAttribute("questions");
	 		for(Question question:questions)
	 		{
	 	%>
			<tr>
				<td class="questionTable" rowspan="4">问题<%=i%></td>
				<td class="questionTable" rowspan="4"><%=question.getQuestionType()%></td>
				<td class="questionTable" rowspan="4"><%=question.getQuestionHeading()%></td>
				<td class="questionTable"><%=question.getOptionA()%></td>
				<td class="questionTable" rowspan="4"><a href="DeleteQuestionByIdServlet?id=<%=question.getId()%>&ownerQuestionnaireId=<%=question.getOwnerQuestionnaireId()%>&ownerQuestionnaireTitle=<%=question.getOwnerQuestionnaireTitle()%>">删除</a></td>
				<td class="questionTable" rowspan="4"><%=question.getId()%></td>
			</tr>
				<tr><td class="questionTable"><%=question.getOptionB()%></td></tr>
				<tr><td class="questionTable"><%=question.getOptionC()%></td></tr>
				<tr><td class="questionTable"><%=question.getOptionD()%></td></tr>
		<%
			i++;
		}
	 		
		%>
			
	 		<!-- <tr style="border:0px"><td><a href="InsertEmptyStudentServlet">新增</a></td></tr> -->
 		</table>
	</form>	
	
	<form name="insertQuestionForm" action="InsertQuestionServlet" method="post" >
 		<table border="1px"  style="width:1100px;height:120px">
	 		<tr>
				<td class="questionTable" rowspan="4"  style="width:8%">添加问题</td>
				<td class="questionTable" rowspan="4"  style="width:8%;height:8px">
					<select name="questionType" style="height:20px">
					<option value="单选题">单选题</option>
					<option value="多选题">多选题</option>
					<option value="主观题">主观题</option>
				</select>
				</td>
				<td class="questionTable" rowspan="4"  style="width:34%"><input type="text" name="questionHeading" style="width:100%;height:50%;font-size:20px"></td>
				<td class="questionTable"  style="width:34%"><input type="text" name="optionA" style="width:100%"></td>
				<td class="questionTable" rowspan="4"  style="width:8%"><input type="reset" value="重置"  style="font-weight: 900"><input type="submit" value="提交"  style="font-weight: 900"></td>
				<td class="questionTable" rowspan="4"  style="width:8%">待分配</td>
			</tr>
			<tr><td class="questionTable"><input type="text" name="optionB" style="width:100%">  </td></tr>
			<tr><td class="questionTable"><input type="text" name="optionC" style="width:100%">  <input type="hidden" value="<%=request.getAttribute("ownerQuestionnaireTitle")%>" name="ownerQuestionnaireTitle"></input></td></tr>
			<tr><td class="questionTable"><input type="text" name="optionD" style="width:100%">  <input type="hidden" value="<%=request.getAttribute("ownerQuestionnaireId")%>" name="ownerQuestionnaireId"></input></td></tr>	
	 		<!-- <tr><td width="200px" ></td><td align="right"><input type="reset" value="重置"  style="font-weight: 900"><input type="submit" value="提交"  style="font-weight: 900"></td></tr> -->
 		</table>
	</form>
	
</body>
</html>