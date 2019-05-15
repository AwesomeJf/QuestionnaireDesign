package com.questionnaire.dao;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.questionnaire.bean.Order;

public class OrderDao {
	
	public List<Order> selectAllOrder() throws Exception
	{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			List<Order> orders = openSession.selectList("org.mybatis.OrderMapper.selectAllOrder");
			//System.out.println("Dao"+students);
			return orders;
		}
		finally {
			if(openSession!=null){
				openSession.close();
			}
		}
	}
	public List<Order> selectOrderListByStudentId(Order ord) throws Exception
	{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			List<Order> orders = openSession.selectList("org.mybatis.OrderMapper.selectOrderListByStudentId",ord);
			//System.out.println("Dao"+students);
			return orders;
		}
		finally {
			if(openSession!=null){
				openSession.close();
			}
		}
	}
	
	
	public  void deleteOrderById(Order order) throws IOException
	{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			openSession.delete("org.mybatis.OrderMapper.deleteOrderById",order);
			openSession.commit();
		}
		finally {
			if(openSession!=null){
				openSession.close();
			}
		}
	}
	
	
	public Order selectOrderById(Order ord) throws IOException
	{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			Order order= openSession.selectOne("org.mybatis.OrderMapper.selectOrderById",ord);
			//System.out.println(gif);
			return order ;
		}
		finally {
			if(openSession!=null){
				openSession.close();
			}
		}
	}
	//没用到
	public void modifyOrderStatusById(Order Order) throws IOException
	{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			//System.out.println("******"+stu.toString());
			int number=openSession.update("org.mybatis.OrderMapper.modifyOrderStatusById",Order);
			openSession.commit();
			//System.out.println(number);
		}
		finally {
			if(openSession!=null){
				openSession.close();
			}
		}
	}
	
	public void insertOrder(Order order) throws IOException
	{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			openSession.insert("org.mybatis.OrderMapper.insertOrder",order);
			openSession.commit();
		}
		finally {
			if(openSession!=null){
				openSession.close();
			}
		}
	}
}
