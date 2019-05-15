package com.questionnaire.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.questionnaire.bean.Student;
import com.questionnaire.dao.StudentDao;

/**
 * Servlet implementation class StudentManageServlet
 */
@WebServlet("/StudentManageServlet")
public class StudentManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentManageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			response.setCharacterEncoding("UTF-8");
			StudentDao studentDao=new StudentDao();
			List<Student> students;
			try {
				students = studentDao.selectAllStudent();
				//System.out.println(students);
				request.setAttribute("students", students);
				request.getRequestDispatcher("AdmMainView/studentManage.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
