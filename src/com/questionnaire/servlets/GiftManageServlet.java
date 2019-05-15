package com.questionnaire.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.questionnaire.bean.Gift;
import com.questionnaire.bean.Question;
import com.questionnaire.bean.Questionnaire;
import com.questionnaire.dao.GiftDao;
import com.questionnaire.dao.QuestionDao;
import com.questionnaire.dao.QuestionnaireDao;

@WebServlet("/GiftManageServlet")
public class GiftManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GiftManageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		GiftDao gDao=new GiftDao();
		List<Gift> gifs;
		try {
			gifs = gDao.selectAllGift();
			//System.out.println(rClasses);
			request.setAttribute("gifs", gifs);
			request.getRequestDispatcher("AdmMainView/giftManage.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
