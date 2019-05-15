package com.questionnaire.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.questionnaire.bean.Announce;
import com.questionnaire.bean.Student;
import com.questionnaire.dao.*;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginServlet() {
        super();
        
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

    	String code = request.getParameter("code");
		
		HttpSession session = request.getSession();
		String randStr = (String)session.getAttribute("randStrSession");
		response.setCharacterEncoding("UTF-8");
		//PrintWriter out = response.getWriter();
		//System.out.println(code);
		//System.out.println(randStr);
		
		if(!code.equals(randStr)){
			response.sendRedirect("fail.jsp?info=codeError");
		}
		else{
			response.setContentType("text/html;charset=gbk");
			//PrintWriter out =response.getWriter();
			String account=request.getParameter("account");
			String password=request.getParameter("password");
			StudentDao sDao=new StudentDao();
			Student s=new Student();
			
			s.setAccount(account);
			s.setPassword(password);
			try
			{
				String identity=sDao.login(s);
				//System.out.println(identity);
				if ("admin".equals(identity))
				{
					Student sInfo=sDao.selectInfoByAccount(s);
					session.setAttribute("UserNameSession",sInfo.getName());
					session.setAttribute("UserIdSession",sInfo.getId().toString());
					session.setAttribute("UserAddressSession",sInfo.getAddress());
					session.setAttribute("UserScoreSession",sInfo.getScore());
					response.sendRedirect("AdmMainView/adminMain.jsp");
				}
				else if("notAdmin".equals(identity))
				{
					Student sInfo=sDao.selectInfoByAccount(s);
					session.setAttribute("UserNameSession",sInfo.getName());
					session.setAttribute("UserIdSession",sInfo.getId());
					session.setAttribute("UserAddressSession",sInfo.getAddress());
					session.setAttribute("UserScoreSession",sInfo.getScore());
					
					AnnounceDao aDao=new AnnounceDao();
					List<Announce> anns;
					anns = aDao.selectAllAnnounce();

					session.setAttribute("msg", listToString(anns));
					//System.out.println("信息："+listToString(anns));
					response.sendRedirect("StuMainView/studentMain.jsp");
				}
				else
				{
					response.sendRedirect("fail.jsp?info=nameOrPasswordWrong");
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public String listToString(List<Announce> anns) {
		int i=1;
		String annString = "";
		for(Announce ann:anns)
        {
			annString=annString+i+":"+ann.getContent()+"\\n";
			i++;
        }
        return annString;
    }
}
