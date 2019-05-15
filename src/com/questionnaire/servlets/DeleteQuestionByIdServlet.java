package com.questionnaire.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.questionnaire.bean.Question;
import com.questionnaire.dao.QuestionDao;

@WebServlet("/DeleteQuestionByIdServlet")
public class DeleteQuestionByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteQuestionByIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int id=Integer.parseInt(request.getParameter("id"));
		int ownerQuestionnaireId=Integer.parseInt(request.getParameter("ownerQuestionnaireId"));
		String ownerQuestionnaireTitle=request.getParameter("ownerQuestionnaireTitle");
		//System.out.println("DeleteQuestionByIdServlet::"+ownerQuestionnaireTitle);
		QuestionDao qDao = new QuestionDao ();
		Question que = new Question ();
		que.setId(id);
		qDao.deleteQuestionById(que);

		request.setAttribute("ownerQuestionnaireId",ownerQuestionnaireId);
		request.setAttribute("ownerQuestionnaireTitle",ownerQuestionnaireTitle);
		request.getRequestDispatcher("QuestionManageServlet").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
