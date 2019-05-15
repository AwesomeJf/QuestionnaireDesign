package com.questionnaire.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.questionnaire.bean.Student;
import com.questionnaire.dao.StudentDao;

@WebServlet("/DeleteStudentByIdServlet")
public class DeleteStudentByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteStudentByIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int id=Integer.parseInt(request.getParameter("id"));
		Student stu=new Student();
		StudentDao sDao=new StudentDao();
		stu.setId(id);
		sDao.deleteStudentById(stu);
		response.sendRedirect("StudentManageServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
