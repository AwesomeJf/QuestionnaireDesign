package com.student.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.questionnaire.bean.Answer;
import com.questionnaire.bean.Question;
import com.questionnaire.bean.Questionnaire;
import com.questionnaire.dao.AnswerDao;
import com.questionnaire.dao.QuestionDao;

@WebServlet("/AnswerResultServlet")
public class AnswerResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AnswerResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String ownerQuestionnaireTitle =  request.getParameter("ownerQuestionnaireTitle");
		int ownerQuestionnaireId =  Integer.parseInt(request.getParameter("ownerQuestionnaireId"));

		AnswerDao aDao = new AnswerDao();
		Answer ans = new Answer();
		ans.setOwnerQuestionnaireId(ownerQuestionnaireId);
		ans.setOwnerStudentId(Integer.parseInt(session.getAttribute("UserIdSession").toString()));
		List<Answer> answers;
		try {
			ans.setOwnerQuestionnaireId(ownerQuestionnaireId);
	    	ans.setOwnerStudentId(Integer.parseInt(session.getAttribute("UserIdSession").toString()));
	    	answers=aDao.selectAllAnswerByQuestionnaireIdAndStudentId(ans);
			request.setAttribute("answers", answers);
			request.getRequestDispatcher("StuMainView/answerResult.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
