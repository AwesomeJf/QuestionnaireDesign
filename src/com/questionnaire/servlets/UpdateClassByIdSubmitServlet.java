package com.questionnaire.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.questionnaire.bean.Gift;
import com.questionnaire.bean.RegClass;
import com.questionnaire.dao.ClassDao;
import com.questionnaire.dao.GiftDao;

@WebServlet("/UpdateClassByIdSubmitServlet")
public class UpdateClassByIdSubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UpdateClassByIdSubmitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int id =Integer.parseInt(request.getParameter("id"));
		String className = request.getParameter("className");
		String description = request.getParameter("description");
		RegClass rClass=new RegClass();
		ClassDao cDao=new ClassDao();
		rClass.setId(id);
		rClass.setClassName(className);
		rClass.setDescription(description);
		//System.out.println("########"+s.toString());
		cDao.UpdateClassByIdSubmit(rClass);
		response.sendRedirect("ClassManageServlet");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
