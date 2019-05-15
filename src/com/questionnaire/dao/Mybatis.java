package com.questionnaire.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.questionnaire.bean.Answer;

public class Mybatis {
	
	/*
	 * 全局配置
	 */
	public  void selectAns() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			Answer answer= openSession.selectOne("org.mybatis.AnswerMapper.selectAns",6);
			System.out.println(answer);
		}
		finally {
			if(openSession!=null){
				openSession.close();
			}
		}
	}
	
	public  void insertAns(Answer answer) throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			//Answer answer=new Answer(null,10, 100, "干啥");
			openSession.insert("org.mybatis.AnswerMapper.insertAns",answer);
			openSession.commit();
			//System.out.println(answer);
		}
		finally {
			if(openSession!=null){
				openSession.close();
			}
		}
	}
	
	public  void deleteAns() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			openSession.delete("org.mybatis.AnswerMapper.deleteAns",7);
			openSession.commit();
			//System.out.println(answer);
		}
		finally {
			if(openSession!=null){
				openSession.close();
			}
		}
	}
	
	public  void updateAns() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			Answer answer= openSession.selectOne("org.mybatis.AnswerMapper.selectAns",6);
			if(answer==null)
				System.out.println("不存在");
			else
			{
				answer.setId(7000);
				int number=openSession.update("org.mybatis.AnswerMapper.updateAns",answer);
				openSession.commit();
				System.out.println( number);
			}
		}
		finally {
			if(openSession!=null){
				openSession.close();
			}
		}
	}
	
	public  void selectAllAns() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			
			List <Answer> answers= openSession.selectList("org.mybatis.AnswerMapper.selectAllAns");
			for(Answer answer:answers)
			{
				System.out.print(answer.getId()+"\t");
				System.out.print(answer.getOwnerQuestionId()+"\t");
				System.out.print(answer.getOwnerStudentId()+"\t");
				System.out.println(answer.getAnswer()+"\t");
			}
	
		}
		finally {
			if(openSession!=null){
				openSession.close();
			}
		}
	}
	public static void main(String args[]) throws IOException {
		Mybatis mybatis =new Mybatis();
		Answer answer=new Answer();
		//mybatis.selectAns();
		mybatis.insertAns(answer);
		System.out.println(answer.getId()); 
		//mybatis.deleteAns();
		//mybatis.updateAns();
		//mybatis.selectAllAns();
		 }
}
