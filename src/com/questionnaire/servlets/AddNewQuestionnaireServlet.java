package com.questionnaire.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.questionnaire.bean.Questionnaire;
import com.questionnaire.dao.QuestionnaireDao;


@WebServlet("/AddNewQuestionnaireServlet")
public class AddNewQuestionnaireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AddNewQuestionnaireServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String questionnaireTitle = request.getParameter("questionnaireTitle");
		String questionnaireDescription =  request.getParameter("questionnaireDescription");
		int score =  Integer.parseInt(request.getParameter("score"));
		String questionnaireType =  request.getParameter("questionnaireType");
		String status =  request.getParameter("status");
		
		Questionnaire que=new Questionnaire();
		QuestionnaireDao qDao=new QuestionnaireDao();
		que.setSponsorId(Integer.valueOf( (String) session.getAttribute("UserIdSession")));
		que.setQuestionnaireTitle(questionnaireTitle);
		que.setQuestionnaireDescription(questionnaireDescription);
		que.setScore(score);
		que.setQuestionnaireType(questionnaireType);
		que.setStatus(status);
		
		qDao.insertQuestionnaire(que);
		response.sendRedirect("QuestionnaireManageServlet");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
