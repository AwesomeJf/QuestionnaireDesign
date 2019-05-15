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
import com.questionnaire.bean.RegClass;
import com.questionnaire.bean.Student;

public class ClassDao {
	public List<RegClass> selectAllRegClass() throws Exception
	{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			List<RegClass> rClasses= openSession.selectList("org.mybatis.RegClassMapper.selectAllRegClass");
			//System.out.println("Dao"+rClasses);
			return rClasses;
		}
		finally {
			if(openSession!=null){
				openSession.close();
			}
		}
	}
	
	public  void deleteClassById(RegClass rClass) throws IOException
	{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			openSession.delete("org.mybatis.RegClassMapper.deleteClassById",rClass.getId());
			openSession.commit();
		}
		finally {
			if(openSession!=null){
				openSession.close();
			}
		}
	}
	public RegClass selectClassById(RegClass rC) throws IOException
	{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			RegClass rClass= openSession.selectOne("org.mybatis.RegClassMapper.selectClassById",rC.getId());
			//System.out.println(rClass);
			return rClass;
		}
		finally {
			if(openSession!=null){
				openSession.close();
			}
		}
	}
	public void UpdateClassByIdSubmit(RegClass rClass) throws IOException
	{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			int number=openSession.update("org.mybatis.RegClassMapper.UpdateClassByIdSubmit",rClass);
			openSession.commit();
			//System.out.println(number);
		}
		finally {
			if(openSession!=null){
				openSession.close();
			}
		}
	}
	
	
	public void insertEmptyClass() throws IOException
	{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			RegClass rClass=new RegClass(null,"","");
			openSession.insert("org.mybatis.RegClassMapper.insertEmptyClass",rClass);
			openSession.commit();
		}
		finally {
			if(openSession!=null){
				openSession.close();
			}
		}
	}
}
