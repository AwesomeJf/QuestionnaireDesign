package com.questionnaire.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.questionnaire.bean.Gift;
import com.questionnaire.bean.RegClass;
import com.questionnaire.dao.ClassDao;
import com.questionnaire.dao.GiftDao;

@WebServlet("/UpdateGiftByIdServlet")
public class UpdateGiftByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdateGiftByIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int id=Integer.parseInt(request.getParameter("id"));
		String giftName=request.getParameter("giftName");
		Gift gif=new Gift();
		GiftDao gDao=new GiftDao();
		gif.setId(id);
		Gift gift= gDao.selectGiftById(gif);
		request.setAttribute("gift",gift);
		request.getRequestDispatcher("AdmMainView/updateGift.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
