package com.questionnaire.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.questionnaire.bean.Announce;
import com.questionnaire.bean.Questionnaire;
import com.questionnaire.dao.AnnounceDao;
import com.questionnaire.dao.QuestionnaireDao;


@WebServlet("/InsertAnnounceServlet")
public class InsertAnnounceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertAnnounceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Announce ann= new Announce();
		AnnounceDao aDao= new AnnounceDao();
		
		String content = request.getParameter("content");
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		ann.setSponsorId(Integer.valueOf( (String) session.getAttribute("UserIdSession")));
		ann.setContent(content);
		ann.setSubmitTime(time.format(new Date()));
		aDao.insertAnnounce(ann);
		response.sendRedirect("AnnounceManageServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
