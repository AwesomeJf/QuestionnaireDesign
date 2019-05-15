package com.questionnaire.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.questionnaire.dao.StudentDao;

@WebServlet("/InsertEmptyStudentServlet")
public class InsertEmptyStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public InsertEmptyStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		StudentDao sDao=new StudentDao();
		sDao.insertEmptyStudent();
		response.sendRedirect("StudentManageServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
