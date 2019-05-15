package com.student.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.questionnaire.bean.Questionnaire;
import com.questionnaire.dao.QuestionnaireDao;


@WebServlet("/QuestionnaireShowAllServlet")
public class QuestionnaireShowAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public QuestionnaireShowAllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		QuestionnaireDao qDao=new QuestionnaireDao();
		List<Questionnaire> ques;
		try {
			ques = qDao.selectAllReleaseQuestionnaire();
			request.setAttribute("ques", ques);
			request.getRequestDispatcher("StuMainView/questionnaireShowAll.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
