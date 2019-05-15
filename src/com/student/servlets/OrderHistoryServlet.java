package com.student.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.questionnaire.bean.Order;
import com.questionnaire.bean.Questionnaire;
import com.questionnaire.dao.OrderDao;
import com.questionnaire.dao.QuestionnaireDao;

@WebServlet("/OrderHistoryServlet")
public class OrderHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public OrderHistoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Order ord=new Order();
		OrderDao oDao=new OrderDao();
		int studentId=Integer.parseInt(request.getParameter("studentId"));
		System.out.println("OrderHistoryServlet:"+studentId);
		ord.setStudentId(studentId);
		List<Order> ords;
		try {
			ords = oDao.selectOrderListByStudentId(ord);
			//System.out.println("ords:"+ords);
			request.setAttribute("ords", ords);
			request.getRequestDispatcher("StuMainView/orderHistory.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
