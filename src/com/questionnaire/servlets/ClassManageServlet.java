package com.questionnaire.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.questionnaire.bean.RegClass;
import com.questionnaire.dao.ClassDao;

/**
 * Servlet implementation class ClassManageServlet
 */
@WebServlet("/ClassManageServlet")
public class ClassManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ClassManageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		ClassDao classDao=new ClassDao();
		List<RegClass> rClasses;
		try {
			rClasses = classDao.selectAllRegClass();
			//System.out.println(rClasses);
			request.setAttribute("rClasses", rClasses);
			request.getRequestDispatcher("AdmMainView/classManage.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
