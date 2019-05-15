package com.questionnaire.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.questionnaire.bean.Answer;
import com.questionnaire.bean.Question;
import com.questionnaire.bean.Student;

public class AnswerDao {
	public List<Answer> selectAllAnswerByQuestionnaireIdAndStudentId(Answer ans) throws Exception
	{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			List<Answer> answers = openSession.selectList("org.mybatis.AnswerMapper.selectAllAnswerByQuestionnaireIdAndStudentId",ans);
			//System.out.println("Dao"+students);
			return answers;
		}
		finally {
			if(openSession!=null){
				openSession.close();
			}
		}
	}
	
	public  void deleteAnswerById(Answer answer) throws IOException
	{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			openSession.delete("org.mybatis.AnswerMapper.deleteAnswerById",answer);
			openSession.commit();
		}
		finally {
			if(openSession!=null){
				openSession.close();
			}
		}
	}
	public Answer selectAnswerById(Answer ans) throws IOException
	{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			Answer answer= openSession.selectOne("org.mybatis.AnswerMapper.selectAnswerById",ans.getId());
			System.out.println(answer);
			return answer ;
		}
		finally {
			if(openSession!=null){
				openSession.close();
			}
		}
	}
	public List<Answer> selectAllAnswerByQuestionnaireId(Answer ans) throws IOException
	{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			List<Answer> answers = openSession.selectList("org.mybatis.AnswerMapper.selectAllAnswerByQuestionnaireId",ans);
			//System.out.println("根据问卷编号查问题:"+answers);
			return answers ;
		}
		finally {
			if(openSession!=null){
				openSession.close();
			}
		}
	}
	public int selectCountByQuestionnaireIdAndQuestionIdAndOption(Answer ans) throws IOException
	{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			int count = openSession.selectOne("org.mybatis.AnswerMapper.selectCountByQuestionnaireIdAndQuestionIdAndOption",ans);
			//System.out.println(count);
			return count ;
		}
		finally {
			if(openSession!=null){
				openSession.close();
			}
		}
	}

	
	public void insertAnswer(Answer ans) throws IOException
	{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			openSession.insert("org.mybatis.AnswerMapper.insertAnswer",ans);
			openSession.commit();
		}
		finally {
			if(openSession!=null){
				openSession.close();
			}
		}
	}
}
