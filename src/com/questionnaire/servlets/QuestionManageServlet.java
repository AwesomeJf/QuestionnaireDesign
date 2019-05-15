package com.questionnaire.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.questionnaire.bean.Question;
import com.questionnaire.bean.Questionnaire;
import com.questionnaire.bean.RegClass;
import com.questionnaire.dao.ClassDao;
import com.questionnaire.dao.QuestionDao;

@WebServlet("/QuestionManageServlet")
public class QuestionManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public QuestionManageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String ownerQuestionnaireTitle =  request.getParameter("ownerQuestionnaireTitle");
		int ownerQuestionnaireId =  Integer.parseInt(request.getParameter("ownerQuestionnaireId"));
		QuestionDao qDao = new QuestionDao ();
		Question q = new Question ();
		q.setOwnerQuestionnaireId(ownerQuestionnaireId);
		q.setOwnerQuestionnaireTitle(ownerQuestionnaireTitle);
		List<Question> questions;
		try {
			//System.out.println("QuestionManageServlet::"+ownerQuestionnaireTitle);
			questions = qDao.selectQuestionListById(q);
			// System.out.println(rClasses);
			request.setAttribute("questions",questions);
			request.setAttribute("ownerQuestionnaireId",ownerQuestionnaireId);
			request.setAttribute("ownerQuestionnaireTitle",ownerQuestionnaireTitle);
			
			request.getRequestDispatcher("AdmMainView/questionManage.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
