package com.questionnaire.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.questionnaire.bean.Announce;
import com.questionnaire.bean.Gift;
import com.questionnaire.dao.AnnounceDao;
import com.questionnaire.dao.GiftDao;

@WebServlet("/AnnounceManageServlet")
public class AnnounceManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public AnnounceManageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		AnnounceDao aDao=new AnnounceDao();
		List<Announce> anns;
		try {
			anns = aDao.selectAllAnnounce();

			request.setAttribute("anns", anns);
			request.getRequestDispatcher("AdmMainView/announceManage.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
