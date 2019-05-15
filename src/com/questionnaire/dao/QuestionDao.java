package com.questionnaire.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.questionnaire.bean.Question;
import com.questionnaire.bean.Student;

public class QuestionDao {
	public List<Question> selectQuestionListById(Question que) throws Exception
	{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			List<Question> questions = openSession.selectList("org.mybatis.QuestionMapper.selectQuestionListById",que);
			//System.out.println("Dao"+students);
			return questions;
		}
		finally {
			if(openSession!=null){
				openSession.close();
			}
		}
	}
	
	public  void deleteQuestionById(Question question) throws IOException
	{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			openSession.delete("org.mybatis.QuestionMapper.deleteQuestionById",question);
			openSession.commit();
		}
		finally {
			if(openSession!=null){
				openSession.close();
			}
		}
	}
	public Question selectQuestionById(Question que) throws IOException
	{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			Question question= openSession.selectOne("org.mybatis.QuestionMapper.selectQuestionById",que.getId());
			System.out.println(question);
			return question ;
		}
		finally {
			if(openSession!=null){
				openSession.close();
			}
		}
	}
	
	public void UpdateStudentByIdSubmit(Student stu) throws IOException
	{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			//System.out.println("******"+stu.toString());
			int number=openSession.update("org.mybatis.StudentMapper.UpdateStudentByIdSubmit",stu);
			openSession.commit();
			//System.out.println(number);
		}
		finally {
			if(openSession!=null){
				openSession.close();
			}
		}
	}
	
	
	public void insertQuestion(Question que) throws IOException
	{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			openSession.insert("org.mybatis.QuestionMapper.insertQuestion",que);
			openSession.commit();
		}
		finally {
			if(openSession!=null){
				openSession.close();
			}
		}
	}
}
