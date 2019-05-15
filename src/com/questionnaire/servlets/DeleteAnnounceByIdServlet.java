package com.questionnaire.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.questionnaire.bean.Announce;
import com.questionnaire.bean.Gift;
import com.questionnaire.dao.AnnounceDao;
import com.questionnaire.dao.GiftDao;

@WebServlet("/DeleteAnnounceByIdServlet")
public class DeleteAnnounceByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteAnnounceByIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int id=Integer.parseInt(request.getParameter("id"));
		Announce ann= new Announce();
		AnnounceDao aDao= new AnnounceDao();
		ann.setId(id);
		aDao.deleteAnnounceById(ann);
		response.sendRedirect("AnnounceManageServlet");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
