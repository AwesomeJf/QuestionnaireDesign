package com.questionnaire.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.questionnaire.bean.Order;
import com.questionnaire.bean.Questionnaire;
import com.questionnaire.dao.OrderDao;
import com.questionnaire.dao.QuestionnaireDao;


@WebServlet("/ModifyOrderStatusByIdServlet")
public class ModifyOrderStatusByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ModifyOrderStatusByIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		int id =  Integer.parseInt(request.getParameter("id"));
		String status =  request.getParameter("status");
		
		Order ord=new Order();
		OrderDao oDao=new OrderDao();
		if("未审核".equals(status))
			ord.setStatus("成功");
		if("成功".equals(status))
			ord.setStatus("失败");
		if("失败".equals(status))
			ord.setStatus("未审核");
		ord.setId(id);
		oDao.modifyOrderStatusById(ord);
		response.sendRedirect("OrderManageServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
