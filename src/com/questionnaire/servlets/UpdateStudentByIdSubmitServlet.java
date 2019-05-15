package com.questionnaire.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.questionnaire.bean.Student;
import com.questionnaire.dao.StudentDao;

@WebServlet("/UpdateStudentByIdSubmitServlet")
public class UpdateStudentByIdSubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdateStudentByIdSubmitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Integer id =Integer.parseInt(request.getParameter("id"));
		Integer ownerClassId = Integer.parseInt(request.getParameter("ownerClassId"));
		String phoneNumber= request.getParameter("phoneNumber");
		Integer score = Integer.parseInt(request.getParameter("score"));
		Integer studyNumber = Integer.parseInt(request.getParameter("studyNumber"));
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String address = request.getParameter("address");
		String isAdmin = request.getParameter("isAdmin");
		String registerTime = request.getParameter("registerTime");
		
		//this.id = id;
		//this.ownerClassId = ownerClassId;
		//this.phoneNumber = phoneNumber;
		//this.score = score;
		//this.studyNumber = studyNumber;
		//this.account = account;
		//this.password = password;
		//this.name = name;
		//this.sex = sex;
		//this.address = address;
		//this.isAdmin = isAdmin;
		//this.registerTime = registerTime;
		
		StudentDao sDao=new StudentDao();
		Student s=new Student();
		s.setId(id);
		s.setOwnerClassId(ownerClassId);
		s.setPhoneNumber(phoneNumber);
		s.setScore(score);
		s.setStudyNumber(studyNumber);
		s.setAccount(account);
		s.setPassword(password);
		s.setName(name);
		s.setSex(sex);
		s.setAddress(address);
		s.setIsAdmin(isAdmin);
		s.setRegisterTime(registerTime);
		//System.out.println("########"+s.toString());
		sDao.UpdateStudentByIdSubmit(s);
		response.sendRedirect("StudentManageServlet");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
