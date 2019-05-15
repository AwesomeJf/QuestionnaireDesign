package com.questionnaire.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.questionnaire.bean.Question;
import com.questionnaire.bean.RegClass;
import com.questionnaire.dao.ClassDao;
import com.questionnaire.dao.QuestionDao;

/**
 * Servlet implementation class InsertQuestionServlet
 */
@WebServlet("/InsertQuestionServlet")
public class InsertQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public InsertQuestionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Integer ownerQuestionnaireId =Integer.parseInt(request.getParameter("ownerQuestionnaireId"));
		String  questionHeading= request.getParameter("questionHeading");
		String  ownerQuestionnaireTitle= request.getParameter("ownerQuestionnaireTitle");
		String  questionType= request.getParameter("questionType");
		String  optionA= request.getParameter("optionA");
		String  optionB= request.getParameter("optionB");
		String  optionC= request.getParameter("optionC");
		String  optionD= request.getParameter("optionD");
		
		Question que=new Question();
		QuestionDao qDao=new QuestionDao();
		que.setOwnerQuestionnaireId(ownerQuestionnaireId);
		que.setOwnerQuestionnaireTitle(ownerQuestionnaireTitle);
		que.setQuestionHeading(questionHeading);
		que.setQuestionType(questionType);
		que.setOptionA(optionA);
		que.setOptionB(optionB);
		que.setOptionC(optionC);
		que.setOptionD(optionD);
		//System.out.println("InsertQuestionServlet::"+ownerQuestionnaireTitle);
		qDao.insertQuestion(que);

		request.setAttribute("ownerQuestionnaireId",ownerQuestionnaireId);
		request.setAttribute("ownerQuestionnaireTitle",ownerQuestionnaireTitle);
		request.getRequestDispatcher("QuestionManageServlet").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
