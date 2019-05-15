package com.questionnaire.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.questionnaire.bean.RegClass;
import com.questionnaire.dao.ClassDao;

/**
 * Servlet implementation class UpdateClassByIdServlet
 */
@WebServlet("/UpdateClassByIdServlet")
public class UpdateClassByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public UpdateClassByIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int id=Integer.parseInt(request.getParameter("id"));
		RegClass rClasss=new RegClass();
		ClassDao cDao=new ClassDao();
		rClasss.setId(id);
		RegClass rClass= cDao.selectClassById(rClasss);
		request.setAttribute("rClass",rClass);
		request.getRequestDispatcher("AdmMainView/updateClass.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
