package com.questionnaire.dao;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.questionnaire.bean.Gift;

public class GiftDao {
	
	public List<Gift> selectAllGift() throws Exception
	{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			List<Gift> gifts = openSession.selectList("org.mybatis.GiftMapper.selectAllGift");
			//System.out.println("Dao"+students);
			return gifts;
		}
		finally {
			if(openSession!=null){
				openSession.close();
			}
		}
	}
	
	public  void deleteGiftById(Gift gift) throws IOException
	{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			openSession.delete("org.mybatis.GiftMapper.deleteGiftById",gift);
			openSession.commit();
		}
		finally {
			if(openSession!=null){
				openSession.close();
			}
		}
	}
	public Gift selectGiftById(Gift gif) throws IOException
	{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			Gift gift= openSession.selectOne("org.mybatis.GiftMapper.selectGiftById",gif);
			//System.out.println(gif);
			return gift ;
		}
		finally {
			if(openSession!=null){
				openSession.close();
			}
		}
	}
	
	public void UpdateGiftByIdSubmit(Gift gif) throws IOException
	{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			//System.out.println("******"+stu.toString());
			int number=openSession.update("org.mybatis.GiftMapper.UpdateGiftByIdSubmit",gif);
			openSession.commit();
			//System.out.println(number);
		}
		finally {
			if(openSession!=null){
				openSession.close();
			}
		}
	}
	
	
	public void insertEmptyGift() throws IOException
	{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			Gift gift=new Gift(null,0,"","","");
			openSession.insert("org.mybatis.GiftMapper.insertEmptyGift",gift);
			openSession.commit();
		}
		finally {
			if(openSession!=null){
				openSession.close();
			}
		}
	}
}
