package com.questionnaire.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.questionnaire.bean.Order;
import com.questionnaire.dao.OrderDao;

@WebServlet("/OrderManageServlet")
public class OrderManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public OrderManageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Order ord=new Order();
		OrderDao oDao=new OrderDao();
		try {
			List<Order> ords = oDao.selectAllOrder();
			//System.out.println("ords:"+ords);
			request.setAttribute("ords", ords);
			request.getRequestDispatcher("AdmMainView/orderManage.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
