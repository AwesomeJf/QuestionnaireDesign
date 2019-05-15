package com.questionnaire.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.questionnaire.bean.Questionnaire;
import com.questionnaire.bean.RegClass;
import com.questionnaire.dao.ClassDao;
import com.questionnaire.dao.QuestionnaireDao;


@WebServlet("/QuestionnaireManageServlet")
public class QuestionnaireManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public QuestionnaireManageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		QuestionnaireDao qDao=new QuestionnaireDao();
		List<Questionnaire> ques;
		try {
			ques = qDao.selectAllQuestionnaire();
			//System.out.println(rClasses);
			request.setAttribute("ques", ques);
			request.getRequestDispatcher("AdmMainView/questionnaireManage.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
