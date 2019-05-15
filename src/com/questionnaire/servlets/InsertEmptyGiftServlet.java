package com.questionnaire.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.questionnaire.bean.Gift;
import com.questionnaire.dao.GiftDao;
@WebServlet("/InsertEmptyGiftServlet")
public class InsertEmptyGiftServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public InsertEmptyGiftServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//Gift gif=new Gift();
		GiftDao gDao=new GiftDao();
		gDao.insertEmptyGift();
		System.out.println("添加心里品");
		response.sendRedirect("GiftManageServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
