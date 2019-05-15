package com.questionnaire.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.questionnaire.bean.Gift;
import com.questionnaire.bean.Questionnaire;
import com.questionnaire.dao.GiftDao;
import com.questionnaire.dao.QuestionnaireDao;

@WebServlet("/DeleteGiftByIdServlet")
public class DeleteGiftByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteGiftByIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int id=Integer.parseInt(request.getParameter("id"));
		Gift gif=new Gift();
		GiftDao gDao=new GiftDao();
		gif.setId(id);
		gDao.deleteGiftById(gif);
		response.sendRedirect("GiftManageServlet");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
