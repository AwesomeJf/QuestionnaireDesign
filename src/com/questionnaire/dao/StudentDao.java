package com.questionnaire.dao;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.questionnaire.bean.RegClass;
import com.questionnaire.bean.Student;

public class StudentDao {
	public String login(Student s) throws Exception
	{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
	
			Student student= openSession.selectOne("org.mybatis.StudentMapper.loginStu",s);
			//System.out.println("#####"+student);
			if(student!=null)
			{
				if("admin".equals(student.getIsAdmin()))
					return "admin";
				return "notAdmin";
			}
			return "nameOrPasswordWrong";
			//System.out.println(answer);
		}
		finally {
			if(openSession!=null){
				openSession.close();
			}
		}
			
	}
	
	public Student selectInfoByAccount(Student s) throws Exception
	{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			Student student= openSession.selectOne("org.mybatis.StudentMapper.selectInfoByAccount",s);
			return student;

		}
		finally {
			if(openSession!=null){
				openSession.close();
			}
		}
	}
	
	public List<Student> selectAllStudent() throws Exception
	{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			List<Student> students = openSession.selectList("org.mybatis.StudentMapper.selectAllStudent");
			//System.out.println("Dao"+students);
			return students;
		}
		finally {
			if(openSession!=null){
				openSession.close();
			}
		}
	}
	
	public  void deleteStudentById(Student student) throws IOException
	{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			openSession.delete("org.mybatis.StudentMapper.deleteStudentById",student);
			openSession.commit();
		}
		finally {
			if(openSession!=null){
				openSession.close();
			}
		}
	}
	public Student selectStudentById(Student stu) throws IOException
	{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			Student student= openSession.selectOne("org.mybatis.StudentMapper.selectStudentById",stu.getId());
			System.out.println(student);
			return student ;
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
	public void UpdateStudentScoreById(Student stu) throws IOException
	{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			//System.out.println("******"+stu.toString());
			int number=openSession.update("org.mybatis.StudentMapper.UpdateStudentScoreById",stu);
			openSession.commit();
			//System.out.println(number);
		}
		finally {
			if(openSession!=null){
				openSession.close();
			}
		}
	}
	public void insertEmptyStudent() throws IOException
	{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	      
			Student stu=new Student(null,0,"",0,0,"","","","","","","");
			stu.setScore(0);
			stu.setIsAdmin("notAdmin");
			stu.setPassword("123456");
			stu.setRegisterTime(time.format(new Date()));
			openSession.insert("org.mybatis.StudentMapper.insertEmptyStudent",stu);
			openSession.commit();
		}
		finally {
			if(openSession!=null){
				openSession.close();
			}
		}
	}
}
