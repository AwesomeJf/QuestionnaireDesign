package com.questionnaire.servlets;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.questionnaire.bean.Student;
import com.questionnaire.dao.StudentDao;

/**
 * Servlet implementation class UpdateStudentByIdServlet
 */
@WebServlet("/UpdateStudentByIdServlet")
public class UpdateStudentByIdServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       

    public UpdateStudentByIdServlet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int id=Integer.parseInt(request.getParameter("id"));
		Student stu=new Student();
		StudentDao sDao=new StudentDao();
		stu.setId(id);
		Student student= sDao.selectStudentById(stu);
		request.setAttribute("student",student);
		request.getRequestDispatcher("AdmMainView/updateStudent.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
