package com.questionnaire.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.questionnaire.bean.Announce;

public class AnnounceDao {
	public List<Announce> selectAllAnnounce() throws Exception
	{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			List<Announce> anns = openSession.selectList("org.mybatis.AnnounceMapper.selectAllAnnounce");
			//System.out.println("Dao"+students);
			return anns;
		}
		finally {
			if(openSession!=null){
				openSession.close();
			}
		}
	}
	
	public  void deleteAnnounceById(Announce announce) throws IOException
	{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			openSession.delete("org.mybatis.AnnounceMapper.deleteAnnounceById",announce);
			openSession.commit();
		}
		finally {
			if(openSession!=null){
				openSession.close();
			}
		}
	}
	public Announce selectAnnounceById(Announce ann) throws IOException
	{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			Announce announce= openSession.selectOne("org.mybatis.AnnounceMapper.selectAnnounceById",ann);
			//System.out.println(gif);
			return announce ;
		}
		finally {
			if(openSession!=null){
				openSession.close();
			}
		}
	}
	
	public void UpdateAnnounceByIdSubmit(Announce ann) throws IOException
	{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			//System.out.println("******"+stu.toString());
			int number=openSession.update("org.mybatis.AnnounceMapper.UpdateAnnounceByIdSubmit",ann);
			openSession.commit();
			//System.out.println(number);
		}
		finally {
			if(openSession!=null){
				openSession.close();
			}
		}
	}
	
	
	public void insertAnnounce(Announce announce) throws IOException
	{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			openSession.insert("org.mybatis.AnnounceMapper.insertAnnounce",announce);
			openSession.commit();
		}
		finally {
			if(openSession!=null){
				openSession.close();
			}
		}
	}
}
