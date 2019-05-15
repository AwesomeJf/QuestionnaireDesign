package com.student.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.questionnaire.bean.Gift;
import com.questionnaire.bean.Order;
import com.questionnaire.bean.Student;
import com.questionnaire.dao.GiftDao;
import com.questionnaire.dao.OrderDao;
import com.questionnaire.dao.StudentDao;

@WebServlet("/InsertOrderServlet")
public class InsertOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public InsertOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		Integer studentId =Integer.parseInt(request.getParameter("studentId"));
		String address = request.getParameter("address");
		String info =  request.getParameter("checkedGift");
	    String[] infoSplit = info.split(",");
	    SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Order ord=new Order();
		OrderDao oDao=new OrderDao();
		
		ord.setStudentId(studentId);
		ord.setGiftId(Integer.parseInt(infoSplit[0]));
		int giftScore=Integer.parseInt(infoSplit[1]);
		ord.setGiftName(infoSplit[2]);
		ord.setAddress(address);
		ord.setStatus("未审核");
		ord.setSubmitTime(time.format(new Date()));
		
		
		int stuScore=Integer.parseInt(session.getAttribute("UserScoreSession").toString());
		//System.out.println("stuScore："+stuScore+"----giftScore"+giftScore);
		if(stuScore<giftScore) {
			response.sendRedirect("fail.jsp?info=scoreNotEnough");
			//System.out.println("积分不足");
		}
		else {
			Student stu=new Student();
			StudentDao sDao=new StudentDao();
			int totalScore = stuScore - giftScore;
			stu.setId(studentId);
			stu.setScore(totalScore);
			sDao.UpdateStudentScoreById(stu);
			// 将新积分存入session
			session.setAttribute("UserScoreSession", totalScore);
			oDao.insertOrder(ord);
			// request.setAttribute("studentId",studentId);
			// System.out.println("studentId"+studentId);
			response.sendRedirect("OrderHistoryServlet?studentId=" + studentId);
		}
		//request.getRequestDispatcher("OrderHistoryServlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
