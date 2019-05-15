package com.questionnaire.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.reflection.SystemMetaObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.questionnaire.bean.Answer;
import com.questionnaire.bean.Question;
import com.questionnaire.dao.AnswerDao;

@WebServlet("/AnalyzeQuestionnaireByIdServlet")
public class AnalyzeQuestionnaireByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AnalyzeQuestionnaireByIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ownerQuestionnaireId=  Integer.parseInt(request.getParameter("ownerQuestionnaireId"));
		AnswerDao aDao = new AnswerDao();
		Answer ans = new Answer();
		ans.setOwnerQuestionnaireId(ownerQuestionnaireId);
		//查询该问卷下的全部问题编号，并去重
		List<Answer> answers=aDao.selectAllAnswerByQuestionnaireId(ans);
		//为了便于ABCD赋值，采用了字符数组形式
		String []info= {"A","B","C","D"};
		//接收全部的数，便于转换为JSON
		List<Map> maps = new ArrayList<Map>();
		//遍历四个选项
		for(int i=0;i<info.length;i++)
		{
			//接收name属性和单个选项的个数数组data
			Map<String,Object> map=new LinkedHashMap<String,Object>();
			//接收单个选项的个数数组
			List<Integer> list=new ArrayList<Integer>();
			//遍历去重后的Answer,此Answer只存了问题编号
			for(Answer answer:answers)
		 	{
				//用来算数的Answer类
				Answer countAnswer = new Answer();
				answer.setOwnerQuestionnaireId(ownerQuestionnaireId);
				answer.setOption(info[i]);
				//根据问卷编号、问题编号和选项查个数
				int count=aDao.selectCountByQuestionnaireIdAndQuestionIdAndOption(answer);
				//将查到的数存入list
				list.add(count);
				//System.out.println(answer+String.valueOf(count));
			}
			//把name和data存入map
			map.put("name",info[i] );
			map.put("data", list);
			//把所有map存入maps
			maps.add(map);
 		}
/*		测试用的，在实际运行中没使用
		Map<String,Object> map1=new LinkedHashMap<String,Object>();
		Map<String,Object> map2=new LinkedHashMap<String,Object>();
		Map<String,Object> map3=new LinkedHashMap<String,Object>();
		Map<String,Object> map4=new LinkedHashMap<String,Object>();
		List<Map> maps = new ArrayList<Map>();
		map1.put("name", "A");
		List<Integer> list=new ArrayList<Integer>();
		list.add(1);
    	list.add(2);
    	list.add(3);
    	list.add(4);
    	list.add(5);
		map1.put("data", list);
		map2.put("name", "B");
		map2.put("data", new int[]{1, 2, 4, 1, 5});
		map3.put("name", "C");
		map3.put("data", new int[]{1, 2, 4, 1, 5});
		map4.put("name", "D");
		map4.put("data", new int[]{1, 2, 4, 1, 5});
		
		maps.add(map1);
		maps.add(map2);
		maps.add(map3);
		maps.add(map4);*/
		ObjectMapper mapper =new ObjectMapper();
		String json=mapper.writeValueAsString(maps);
		//用于ajax返回值
		//mapper.writeValue(response.getWriter(),maps);
		//System.out.println(json);
		request.setAttribute("data", json);
		request.getRequestDispatcher("AdmMainView/analyzeResult.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
