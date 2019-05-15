package com.questionnaire.dao;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.questionnaire.bean.Questionnaire;
import com.questionnaire.bean.Student;

public class QuestionnaireDao {
	public List<Questionnaire> selectAllQuestionnaire() throws Exception
	{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			List<Questionnaire> questionnaires = openSession.selectList("org.mybatis.QuestionnaireMapper.selectAllQuestionnaire");
			//System.out.println("Dao"+students);
			return questionnaires;
		}
		finally {
			if(openSession!=null){
				openSession.close();
			}
		}
	}
	
	public List<Questionnaire> selectAllReleaseQuestionnaire() throws Exception
	{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			List<Questionnaire> questionnaires = openSession.selectList("org.mybatis.QuestionnaireMapper.selectAllReleaseQuestionnaire");
			//System.out.println("Dao"+students);
			return questionnaires;
		}
		finally {
			if(openSession!=null){
				openSession.close();
			}
		}
	}
	
	public  void deleteQuestionnaireById(Questionnaire questionnaire) throws IOException
	{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			openSession.delete("org.mybatis.QuestionnaireMapper.deleteQuestionnaireById",questionnaire);
			openSession.commit();
		}
		finally {
			if(openSession!=null){
				openSession.close();
			}
		}
	}
	public Questionnaire selectQuestionnaireById(Questionnaire que) throws IOException
	{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			Questionnaire questionnaire= openSession.selectOne("org.mybatis.QuestionnaireMapper.selectStudentById",que.getId());
			System.out.println(questionnaire);
			return questionnaire ;
		}
		finally {
			if(openSession!=null){
				openSession.close();
			}
		}
	}
	
	public void modifyQuestionnaireByIdStatus(Questionnaire que) throws IOException
	{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			//System.out.println("******"+stu.toString());
			int number=openSession.update("org.mybatis.QuestionnaireMapper.modifyQuestionnaireByIdStatus",que);
			openSession.commit();
			//System.out.println(number);
		}
		finally {
			if(openSession!=null){
				openSession.close();
			}
		}
	}
	
	
	public void insertQuestionnaire(Questionnaire que) throws IOException
	{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			que.setSubmitTime(time.format(new Date()));
			openSession.insert("org.mybatis.QuestionnaireMapper.insertQuestionnaire",que);
			openSession.commit();
		}
		finally {
			if(openSession!=null){
				openSession.close();
			}
		}
	}
}
