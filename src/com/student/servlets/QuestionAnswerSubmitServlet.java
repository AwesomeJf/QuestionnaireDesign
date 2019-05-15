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
import com.questionnaire.bean.Student;
import com.questionnaire.dao.AnswerDao;
import com.questionnaire.dao.QuestionDao;
import com.questionnaire.dao.StudentDao;

@WebServlet("/QuestionAnswerSubmitServlet")
public class QuestionAnswerSubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public QuestionAnswerSubmitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String ownerQuestionnaireTitle =  request.getParameter("ownerQuestionnaireTitle");
		int ownerQuestionnaireId =  Integer.parseInt(request.getParameter("ownerQuestionnaireId"));
		int ownerQuestionnaireScore =  Integer.parseInt(request.getParameter("ownerQuestionnaireScore"));
		
		List<Question> questions=(List<Question>)session.getAttribute("questions");
		//将新积分存入数据库
		Student stu=new Student();
		StudentDao sDao=new StudentDao();
		int stuScore=Integer.parseInt(session.getAttribute("UserScoreSession").toString());
		int stuId=Integer.parseInt(session.getAttribute("UserIdSession").toString());
		int totalScore=stuScore+ownerQuestionnaireScore;
		stu.setId(stuId);
		stu.setScore(totalScore);
		sDao.UpdateStudentScoreById(stu);
		//将新积分存入session
		session.setAttribute("UserScoreSession", totalScore);
		//将所选答案存入数据库
		AnswerDao aDao = new AnswerDao();
		Answer ans = new Answer();
		ans.setOwnerQuestionnaireId(ownerQuestionnaireId);
    	ans.setOwnerStudentId(Integer.parseInt(session.getAttribute("UserIdSession").toString()));
    	/*System.out.println("questions:"+questions);
    	System.out.println("ownerQuestionnaireTitle:"+ownerQuestionnaireTitle);
    	System.out.println("ownerQuestionnaireId:"+ownerQuestionnaireId);*/
    	for(Question question:questions)
 		{
			String info =  request.getParameter(question.getId().toString());
		    String[] infoSplit = info.split(",");
		    ans.setId(null);
		    ans.setOwnerQuestionId(Integer.parseInt(infoSplit[0]));
		    ans.setOwnerQuestionHeading(question.getQuestionHeading());
		    ans.setOption(infoSplit[1]);
		    ans.setAnswer(infoSplit[2]);
		    //System.out.println("QuestionId:"+infoSplit[0]+"Option:"+infoSplit[1]+"Answer:"+infoSplit[2]);
		    aDao.insertAnswer(ans);
 		}
		request.getRequestDispatcher("QuestionnaireShowAllServlet").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
