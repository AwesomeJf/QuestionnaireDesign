package com.questionnaire.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.questionnaire.bean.Questionnaire;
import com.questionnaire.dao.QuestionnaireDao;

@WebServlet("/ModifyQuestionnaireStatusByIdServlet")
public class ModifyQuestionnaireStatusByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ModifyQuestionnaireStatusByIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		int id =  Integer.parseInt(request.getParameter("id"));
		String status =  request.getParameter("status");
		
		Questionnaire que=new Questionnaire();
		QuestionnaireDao qDao=new QuestionnaireDao();
		if("未发布".equals(status))
			que.setStatus("已发布");
		if("已发布".equals(status))
			que.setStatus("未发布");
		que.setId(id);
		qDao.modifyQuestionnaireByIdStatus(que);
		response.sendRedirect("QuestionnaireManageServlet");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
