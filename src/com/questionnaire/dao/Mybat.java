package com.questionnaire.dao;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.questionnaire.bean.Student;

public class Mybat{
	public  void login() throws Exception
	{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			Map<String, Object> param=new HashMap<String, Object>();
			//System.out.println("account"+s.getAccount());
			//System.out.println(s.getPassword());
			param.put("account","qwe");
			param.put("password","asd1");
			Student student=new Student();
			student= openSession.selectOne("org.mybatis.StudentMapper.loginStu","qwe");
			System.out.println(student);
			//if(student!=null)
				//return true;
			//return false;
			//System.out.println(answer);
		}
		finally {
			if(openSession!=null){
				openSession.close();
			}
		}
			
	}
	
	public static void main(String args[]) throws Exception {
		Mybat mybat =new Mybat();
		
			mybat.login();
		
	}
}
