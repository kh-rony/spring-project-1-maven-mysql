//package com.khrony.springproject1mavenmysql.repositories;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import org.hibernate.HibernateException;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//import com.khrony.springproject1mavenmysql.SimpleSearchApplication;
//import com.khrony.springproject1mavenmysql.models.Developer;
//import com.khrony.springproject1mavenmysql.models.ProgrammingLanguage;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.junit.Test;
//import org.junit.runner.RunWith
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.jpa.provider.HibernateUtils;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = SimpleSearchApplication.class)
//@WebAppConfiguration
//public class TestManyToManyBetweenDeveloperAndProgrammingLanguage
//{
//	@Test
//	public void test()
//	{
//		SessionFactory sessionFactory = (SessionFactory)this.context.getBean("sessionFactory");
//		Session session = sessionFactory.openSession();
//
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		Transaction transaction = null;
//		try
//		{
//			transaction = session.beginTransaction();
//
//			Set<Course> courses = new HashSet<Course>();
//			courses.add(new Course("Maths"));
//			courses.add(new Course("Computer Science"));
//
//			Student student1 = new Student("Eswar", courses);
//			Student student2 = new Student("Joe", courses);
//			session.save(student1);
//			session.save(student2);
//
//			transaction.commit();
//		}
//		catch(HibernateException e)
//		{
//			transaction.rollback();
//			e.printStackTrace();
//		}
//		finally
//		{
//			session.close();
//		}
//
//	}
//}