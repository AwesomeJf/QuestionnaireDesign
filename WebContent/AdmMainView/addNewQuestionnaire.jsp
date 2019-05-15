<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" %>
<html>
<head>
	<title>登录</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="../css/layout.css" type="text/css" />
</head>
<body><!-- style="width:300px;height:50px;font-size:18px" -->
<form name="loginForm" action="../AddNewQuestionnaireServlet" method="post">
 		<table border="0px">
	 		<tr><td width="200px" colspan="2" class="addQuestionnaireTable"><h2 align="center">添加问卷</h2></td>	</tr>
	 		<tr><td width="200px" class="addQuestionnaireTable">题目：</td>	<td class="addQuestionnaireTable"><input type="text" name="questionnaireTitle"></td></tr>
	 		<tr><td width="200px" class="addQuestionnaireTable">描述：</td>	<td class="addQuestionnaireTable"><input type="text" name="questionnaireDescription"></td></tr>
	 		<tr><td width="200px" class="addQuestionnaireTable">分数：</td>	<td class="addQuestionnaireTable"><select  name="score">
													  <option value ="1">1分</option>
													  <option value ="2">2分</option>
													  <option value ="3">3分</option>
													  <option value ="4">4分</option>
													  <option value ="5">5分</option>
													</select>
												</td><tr>
	 		<tr><td width="200px" class="addQuestionnaireTable">类型：</td>	<td class="addQuestionnaireTable"><select  name="questionnaireType" style="width:300px">
													  <option value ="人文">人文</option>
													  <option value ="科技">科技</option>
													  <option value ="历史">历史</option>
													  <option value ="校园">校园</option>
													</select>
												</td><tr>
	 		<tr><td width="200px" class="addQuestionnaireTable">状态：</td>	<td><select  name="status" style="width:300px" class="addQuestionnaireTable">
													  <option value ="未发布">未发布</option>
													  <option value ="发布">发布</option>
													</select></td><tr>

	 		<tr><td width="200px" class="addQuestionnaireTable"></td><td align="right" class="addQuestionnaireTable"><input type="reset" value"重置"  style="font-weight: 900"><input type="submit" value="提交"  style="font-weight: 900"></td></tr>
 		</table>
	</form>	
</body>
</html>